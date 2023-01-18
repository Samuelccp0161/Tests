package Exceptions;

import Exercise_11.Files.Format;
import Exercise_11.Files.HandlerTest;
import Exercise_11.Files.SimpleException;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.*;
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
        message.setStackTrace(traceElements);
    }
    @Test
    public void printLevelsTest(){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        HandlerTest handler = new HandlerTest();
        Format format = new Format();
        logger.addHandler(handler);
        handler.setFormatter(format);

        logger.info(": SAI DAQUI!");
        logger.severe(": SAI DAQUI!");
        logger.finer(": SAI DAQUI!");
        logger.info(": GET OUT!");

        String expected = Level.INFO + ": SAI DAQUI!\n";
        expected += Level.SEVERE + ": SAI DAQUI!\n";
        expected += Level.FINER + ": SAI DAQUI!\n";
        expected += Level.INFO + ": GET OUT!\n";

        assertEquals(expected, handler.printLevels());
        System.out.println(handler.printLevels());
    }
    @Test
    public void warningTest(){
        Logger logger = Logger.getLogger(getClass().getName());
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        HandlerTest handler = new HandlerTest();
        Format format = new Format(handler);
        logger.addHandler(handler);
        handler.setFormatter(format);

        logger.info(": SAI DAQUI!");
        logger.info(": SE!");
        logger.finer(": SAI DAQUI!");

        String expected = Level.INFO + ": SAI DAQUI!(INFO total = " + 1+")\n";
        expected += Level.INFO + ": SE!(INFO total = " + 2+")\n";
        expected += Level.FINER + ": SAI DAQUI!(FINER total = " + 1+")\n";

        assertEquals(expected, handler.printLevels());
        System.out.println(handler.printLevels());
    }
}