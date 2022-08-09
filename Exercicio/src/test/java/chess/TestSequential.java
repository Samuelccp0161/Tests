package chess;

import chess.Sequential;
import org.junit.Test;
import java.util.Vector;
import static org.junit.Assert.assertEquals;

public class TestSequential {
    @Test
    public void SequenceTest(){
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12", Sequential.sequence(12));
        assertEquals("1 2 3 4 5* 6 7 8 9 10* 11 12 13 14 15*", Sequential.sequence(15));
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

        System.out.println(sequence01);

        assertEquals(sequence01, Sequential.subStringVector(Sequential.sequence(6)));
    }
    @Test
    public void SequenceTest2(){
        String sequence = Sequential.sequence(6);
        Vector sequence01 = Sequential.subStringVector(sequence);

        assertEquals(sequence, Sequential.vectorToString(sequence01));

        sequence = Sequential.sequence(7);
        sequence01 = Sequential.subStringVector(sequence);
        assertEquals(sequence, Sequential.vectorToString(sequence01));
    }
}
