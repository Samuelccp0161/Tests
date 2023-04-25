package Exercise_14;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RingTest {

    @Test
    public void createRingTest() {
        Ring ring = new Ring();

        assertEquals(0, ring.size());
    }

    @Test
    public void addMultipleNumberTest() {
        Ring ring = new Ring();

        int number1 = 4;
        int number2 = 8;
        int number3 = 12;

        ring.add(number1);
        assertEquals(1, ring.size());
        assertEquals(number1, ring.get());

        ring.add(number2);
        assertEquals(2, ring.size());
        assertEquals(number2, ring.get());

        ring.add(number3);
        assertEquals(3, ring.size());
        assertEquals(number3, ring.get());
    }

    @Test
    public void testNext() {
        Ring ring = new Ring();

        ring.add(2);
        ring.add(1);
        ring.add(3);

        assertEquals(3, ring.get());
        ring.next();
        assertEquals(2, ring.get());
        ring.next();
        assertEquals(1, ring.get());
        ring.next();
        assertEquals(3, ring.get());

    }

    @Test
    public void testPrevious() {
        Ring ring = new Ring();

        ring.add(1);
        ring.add(2);
        ring.add(3);

        assertEquals(3, ring.get());
        ring.prev();
        assertEquals(2, ring.get());
        ring.prev();
        assertEquals(1, ring.get());
        ring.prev();
        assertEquals(3, ring.get());

    }@Test
    public void testRemove() {
        Ring ring = new Ring();

        ring.add(1);
        ring.add(2);
        ring.add(3);

        ring.remove();

        assertEquals(1, ring.get());
        ring.prev();
        assertEquals(2, ring.get());
        ring.prev();
        assertEquals(1, ring.get());

//        assertEquals(1, ring.get());
//        ring.next();
//        assertEquals(2, ring.get());
//        ring.next();
//        assertEquals(1, ring.get());
    }
}
