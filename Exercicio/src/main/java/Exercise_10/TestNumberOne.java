package Exercise_10;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class TestNumberOne {
    @Test
    public void testQuestOne(){
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("2");
        BigDecimal c = a.add(b);

        assertEquals(new BigDecimal("1"), a);
        assertEquals(new BigDecimal("2"), b);
        assertEquals(new BigDecimal("3"), c);
    }
    @Test
    public void testQuestTwo(){
        BigDecimal a = new BigDecimal("10.00");
        BigDecimal b = new BigDecimal("1");
        assertNotEquals(a,b);

        BigDecimal c = b.multiply(new BigDecimal("10.00"));
        BigDecimal d = a.divideToIntegralValue(new BigDecimal("10.00"));
        assertEquals(new BigDecimal("10.00"), c);
        assertEquals(new BigDecimal("1"), d);
    }
    @Test
    public void testQuestThree(){
        float a = 0.9f;
        float b = 0.005f;
        float c = 0.005f * 2;
        assertNotEquals(a,c);
        assertEquals(a, c, 0.89);

        double aa = 0.9;
        double bb = 0.005;
        double cc = 0.005 * 2;
        assertNotEquals(aa, cc);
        assertEquals(aa, cc, 0.89);
    }
    @Test
    public void testQuestFour(){
        float x = 0.01f;
        double xx = (float)0.01;
    }
    @Test
    public void testQuestFive(){
        assertEquals(57005, Integer.decode("0xDEAD").intValue());
    }
    @Test
    public void testQuestSix(){
        final float tolerance = 0.5f;
        final float x = 1f;

        assertFalse(Double.NaN > 0.0);
        assertFalse(Double.NaN < 1.0);
        assertFalse(Double.NaN == 1.0);

        assertEquals(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY * 100, tolerance);
        assertEquals(Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY * -1, tolerance);
        assertEquals(Float.POSITIVE_INFINITY, x / 0f, tolerance);
        assertEquals(Float.NEGATIVE_INFINITY, x / -0f, tolerance);
        assertTrue(Float.isNaN(x % 0f));
    }
    @Test
    public void testQuestSeven(){
//        float ff = 15;
//        Float.;
//        assertNotEquals(ff, fe);
    }
}
