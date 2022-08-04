package chess;

import org.junit.Test;

import java.util.Vector;

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
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Factorial.sequence(12));
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12 13 14 15*", Factorial.sequence(15));
    }
    @Test
    public void SequenceTest1(){
        Vector<String> sequence01 = new Vector<String>();
        sequence01.add("1");
        sequence01.add("2");
        sequence01.add("3");
        sequence01.add("4");
        sequence01.add("5*");
        sequence01.add("6");

        assertEquals(sequence01, Factorial.stringVersion(Factorial.sequence(6)));
    }
    @Test
    public void SequenceTest2(){
        String sequence = Factorial.sequence(6);
        Vector<String> sequence01 = Factorial.stringVersion(sequence);

        assertEquals(sequence, Factorial.sequence1(sequence01));
    }
}
