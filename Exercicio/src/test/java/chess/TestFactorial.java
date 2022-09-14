package chess;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestFactorial {
    @Test
    public void factorial(){
        assertEquals(120, Factorial.factorial1(5));
        assertEquals(24, Factorial.factorial1(4));
    }
    @Test
    public void factorialForFor(){
        assertEquals(24, Factorial.factorial2(4));
    }
    @Test
    public void factorialForDo(){
        assertEquals(24, Factorial.factorial3(4));
    }
    @Test
    public void factorialForTrue(){
        assertEquals(24, Factorial.factorial4(4));
    }
}