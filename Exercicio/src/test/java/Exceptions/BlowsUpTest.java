package Exceptions;

import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;
import static org.junit.Assert.*;

public class BlowsUpTest {
    private int ;

    @Test
    public void blowsUpTest(){
        try{
            blowsUp();
            fail();
        }
        catch (SimpleException success){
            Assert.assertEquals("Somebody should catch this!", success.getMessage());
            success.printStackTrace();
        }
    }
    public void blowsUp(){
        throw new SimpleException("Somebody should catch this!");

    }
    @Test
    public void rethrowsTest(){
        try {
            rethrows();
            fail();
        }
        catch (RuntimeException exception){
            assertEquals("Somebody should catch this!", exception.getCause().getMessage());
            exception.printStackTrace();
        }
    }
    public void rethrows(){
        try {
            blowsUp();
        }
        catch (RuntimeException exception){
            exception.getStackTrace();
            throw new RuntimeException(exception);
        }
    }
    @Test
    public void testWithProblems() {
        Logger logger = Logger.getLogger(getClass().getName());
        try {
            doSomething();
            fail("no exception");
        }
        catch (Exception success) {
            success.printStackTrace();
            logReverse(success);
            success.printStackTrace();
            logger.log(Level.INFO, "Não usa isso!!!",success);
        }
    }
    public void doSomething() throws Exception{
         throw new Exception("blah");
    }
    private void log(String message){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.info(message);
    }
    public void logReverse(Exception message){
        StackTraceElement[] traceElements = message.getStackTrace();
        StackTraceElement auxiliar;
        for (int i = 0; i <= traceElements.length/2; i++) {
            auxiliar = traceElements[i];
            traceElements[i] = traceElements[traceElements.length -1 -i];
            traceElements[traceElements.length-1-i] = auxiliar;
        }

        //auxiliar = D
        //HGFDSA

        message.setStackTrace(traceElements);
//        traceElements = parei aqui por que nao sei o que fazer a partir daqui.
    }
    @Test
    public void loggGuardian(){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        HandlerTest handler = new HandlerTest();
        Format format = new Format();
        format.format();
//        handler.setFilter(new MyFilter());
        logger.addHandler(handler);
        logger.info("INFO: SAI DAQUI!");
        assertEquals(1, handler.getCount(Level.INFO.getName()));
        String message = String.format(Level.INFO.getName(), handler.getMessage());
        log(message);
        System.out.println(message);
    }
//    public void customLog(){
//        Logger logger = Logger.getLogger(getClass().getName());
//        logger.setLevel(Level.ALL);
//        HandlerTest handler = new HandlerTest();
//        logger.addHandler(handler);
//        assertEquals();
//    }
// parei aqui por conta que eu não sei o que fazer aqui em cima por conta que eu fiz o farmat, não sei se está correto.

}