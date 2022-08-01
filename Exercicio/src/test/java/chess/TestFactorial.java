package chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    @Test
    public void SequenceTest(){
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12", Factorial.sequence(12));
    }
}
