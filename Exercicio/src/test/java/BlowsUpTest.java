import org.junit.Test;

import static org.junit.Assert.*;

public class BlowsUpTest {
    @Test
    public void blowsUpTest(){
        try{
            blowsUp();
            fail();
        }
        catch (RuntimeException success){
            assertEquals("Somebody should catch this!", success.getMessage());
        }
    }
    public void blowsUp(){
        throw new RuntimeException("Somebody should catch this!");
    }
    @Test
    public void rethrowsTest(){
        try {
            rethrows();
            fail();
        }
        catch (RuntimeException exception){
//            success.getCause().getMessage();
            assertEquals("Somebody should catch this!", exception.getCause().getMessage());
//            exception.printStackTrace();
        }
    }
    public void rethrows(){
        try {
            blowsUp();
        }
        catch (RuntimeException exception){

        }
    }
}