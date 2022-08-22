import org.junit.Test;

import static org.junit.Assert.*;

public class BlowsUpTest {
    @Test
    public void blowsUpTest(){
        try{
            blowsUp();
            fail();
        }
        catch (SimpleException success){
            assertEquals("Somebody should catch this!", success.getMessage());
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
//            exception.getCause().getMessage();
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
        try {
            doSomething();
            fail("no exception");
        }
        catch (Exception success) {
        }
    }
    public void doSomething() {
        throw new Exception("blah");
    }
}