package Exercise_14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RingTest {

    @Test
    public void createRingTest() {
        Ring<Integer> ring = new Ring<>();

        assertEquals(0, ring.size());
    }

    @Test
    public void addMultipleTest() {
        Ring<String> ring = new Ring<>();

        ring.add("number1");
        assertEquals(1, ring.size());
        assertEquals("number1", ring.get());

        ring.add("number2");
        assertEquals(2, ring.size());
        assertEquals("number2", ring.get());

        ring.add("number3");
        assertEquals(3, ring.size());
        assertEquals("number3", ring.get());
    }

    @Test
    public void testNext() {
        Ring<Integer> ring = new Ring<>();

        ring.add(2);
        ring.add(1);
        ring.add(3);

        assertEquals(3, ring.get().intValue());
        ring.next();
        assertEquals(2, ring.get().intValue());
        ring.next();
        assertEquals(1, ring.get().intValue());
        ring.next();
        assertEquals(3, ring.get().intValue());

    }

    @Test
    public void testPrevious() {
        Ring<Integer> ring = new Ring<>();

        ring.add(1);
        ring.add(2);
        ring.add(3);

        assertEquals(3, ring.get().intValue());
        ring.prev();
        assertEquals(2, ring.get().intValue());
        ring.prev();
        assertEquals(1, ring.get().intValue());
        ring.prev();
        assertEquals(3, ring.get().intValue());

    }@Test
    public void testRemove() {
        Ring<Integer> ring = new Ring<>();

        ring.add(1);
        ring.add(2);
        ring.add(3);

        ring.remove();

        assertEquals(2, ring.get().intValue());
        ring.prev();
        assertEquals(1, ring.get().intValue());
        ring.prev();
        assertEquals(2, ring.get().intValue());

        assertEquals(2, ring.get().intValue());
        ring.next();
        assertEquals(1, ring.get().intValue());
        ring.next();
        assertEquals(2, ring.get().intValue());
    }

    @Test
    public void errorGetExceptionRingTest() {
        try{
            Ring<Integer> ring = new Ring<>();
//            ring.add(3);
            ring.get();
//            ring.next();
//            ring.prev();
            fail("Should have thrown");
        }catch (EmptyRingException exceptionRing){
            assertEquals("could not get the element", exceptionRing.getMessage());
        }
    }

    @Test
    public void errorNextExceptionRingTest() {
        try {
            Ring ring = new Ring();
            ring.next();
            fail("Should have thrown");
        }catch (EmptyRingException exceptionRing){
            assertEquals("it was not possible to go to the next one, because the ring is empty", exceptionRing.getMessage());
        }
    }

    @Test
    public void errorPreviousExceptionRingTest() {
        try {
            Ring ring = new Ring();
            ring.prev();
            fail("Should have thrown");
        }catch (EmptyRingException exceptionRing){
            assertEquals("it was not possible to go to the previous one, because the ring is empty", exceptionRing.getMessage());
        }
    }

    @Test
    public void errorRemoveExceptionRingTest() {
        try {
            Ring ring = new Ring();
            ring.remove();
            fail("Should have thrown");
        }catch (EmptyRingException exceptionRing){
            assertEquals("could not remove because the ring is empty", exceptionRing.getMessage());
        }
    }

    @Test
    public void testIterator() {
        Ring<Integer> ring = new Ring<>();

        ring.add(1);
        ring.add(2);
        ring.add(3);
        ring.add(60);
        ring.next();

        List<Integer> numbers = new ArrayList<>();

        for (int n : ring) {
            numbers.add(n);
        }

        assertEquals(Arrays.asList(1, 2, 3, 60) , numbers);
    }
}
