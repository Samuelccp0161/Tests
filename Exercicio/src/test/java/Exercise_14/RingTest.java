package Exercise_14;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RingTest {
    @Test
    public void ringAddTest() {
        Ring ring = new Ring();

        int number = 4;

        ring.add(number);

        assertEquals(4, ring.get());

        ring.next();

        assertEquals(4, ring.get());
    }

    @Test
    public void addMultipleNumberTest() {
        Ring ring = new Ring();

        int number1 = 4;
        int number2 = 8;

        ring.add(number1);
        ring.add(number2);

        assertEquals(8, ring.get());

        ring.next();

        assertEquals(4, ring.get());

        ring.next();

        assertEquals(8, ring.get());

    }
}
