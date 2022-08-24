package Exceptions;

import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class BlowsUpTest {
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
    public void logReverse(){
        StackTraceElement[] traceElements;
//        traceElements

//        traceElements = parei aqui por que nao sei o que fazer a partir daqui.
    }
}