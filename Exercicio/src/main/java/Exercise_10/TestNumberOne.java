package Exercise_10;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        Float p = Float.valueOf(8);
        Float p6 = Float.valueOf("8.0");
        assertTrue(p != p6);
        float p1 = 8f;
        float p2 = 8.0f;
        assertTrue(p1 == p2);
    }
    @Test
    public void testQuestEight(){
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(6);
        expected.add(9);

        List<Integer> actual = division(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, actual);

        expected.add(15);
        actual = division(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15);
        assertEquals(expected, actual);
    }
    private List<Integer> division(int... valor){
        List<Integer> base = new ArrayList<>();
        for (int j : valor)
            if ((j % 3) == 0)
                base.add(j);
        return base;
    }
    @Test
    public void testQuestEightPartTwo(){
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(6);
        expected.add(9);

        List<Integer> actual = divisionPartTwo(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, actual);

        expected.add(255);
        actual = divisionPartTwo(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 255);
        assertEquals(expected, actual);
    }
    public List<Integer> divisionPartTwo(int... valor){
        List<Integer> baseTwo = new ArrayList<>();
        for (int i = 0; i < valor.length; i++) {
            if (getRestoPor3(valor[i]) == 0)
                baseTwo.add(valor[i]);
        }
        return baseTwo;
    }

    public int getRestoPor3(int n) {
        int resultado_divisao = n / 3;
        int finala = resultado_divisao * 3 - n;
        System.out.printf("n: %d, final: %d%n", n, finala);
        return finala;
    }
    @Test
    public void testQuestTen(){
        float x = (int)1.9;
        System.out.print(x);
        assertEquals(2, x, 0.02);
    }
    @Test
    public void testQuestEleven(){
        double x = Math.rint(1.9);
        double x1 = Math.rint(2.5);
        System.out.println(x);
        assertEquals(2, x, 0.05);
        assertEquals(2, x1, 0.02);
    }
    @Test
    public void testQuestFourteen(){
        int x, y;

        x = 5; y = 10;
        assertEquals(42, x * 5 + y++ * 7 / 4); // 5 * 5 + 10 * 7 / 4 = 25 + 10 * 7 / 4 = 25 + 70 /4 = 42,5

        x = 5; y = 10;
        assertEquals(300, ++x * 5 * y++); // (5+1) * 5 * (10) = 300

        x = 5; y = 10;
        assertEquals(275,x++ * 5 * ++y); // 5 * 5 * (10+1) = 11 * 25 = 275

        x = 5; y = 10;
        assertEquals(51, ++x + 5 * 7 + y++); // (5 + 1) + 5 * 7 + 10 = 770

        x = 5; y = 10;
        assertEquals(true, x * 7 == 35 || y++ == 0); // 5 * 7 == verdadeiro e falso

        x = 5; y = 10;
        assertEquals(66, ++x * ++y); // (5 + 1) * (10 + 1) = 11 * 6 = 66

        x = 5; y = 10;
        assertEquals(50, x++ * y++);

        x = 5; y = 10;
        assertEquals(true, x * 2 == y || ++y == 10); // true
    }
    @Test
    public void testQuestFifteen(){
        int x = 17 << 1;
        System.out.println(x);
    }
    @Test
    public void testQuestSixteen(){
        float x = ~1;
        assertEquals(-2.0, x,0.0);
        System.out.println(x);
    }
    @Test
    public void testQuestSeventeen(){
        int x = 12 >> 2;
        int x1 = -12 >> 2;
        assertEquals(3, x);
        assertEquals(-3, x1);

        int y= 12 >>> 2;
        int y1 = -12 >>> 2;
        assertEquals(3, y);
        assertEquals(1073741821, y1);
    }
    @Test
    public void testQuestEightTen(){
        for (int i = 0; i <= 50; i++) {
            int x = random(1, 50);
            assertTrue(x <= 50);
            assertTrue(x >= 1);
        }
    }
    public int random(int inic, int finala){
        int aleat = (int) (Math.random() * finala + inic);
        return aleat;
    }
    @Test
    public void testQuestNineTeeen(){
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        int i = random(0,99);
        int j = random(0,99);
        int f = numbers.get(i);
        int g = numbers.get(j);
        assertEquals(100, numbers.size());

        troca(numbers, i, j);

        assertEquals(100, numbers.size());

        assertEquals(f, (int) numbers.get(i));
        assertEquals(g, (int) numbers.get(j));



        System.out.println(numbers);
        System.out.println(numbers.size());
        }

    @Test
    public void testQuestNineTeen() {
        int x = random(1, 100);
        int y = random(1, 100);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(x);
        numbers.add(y);

        final int i = 0;
        final int j = 1;

        troca(numbers, i, j);


        assertEquals(y, (int) numbers.get(i));
        assertEquals(x, (int) numbers.get(j));

    }


    public void troca(List<Integer> numbers, int i, int j) {

//        int a = 2;
//        int b = 3;
//
//        int valor = a;
//        a = b;
//        b = valor;

//        int w = numbers.get(i);
        int x = numbers.set(i, numbers.get(j));
        numbers.set(j, x);


    }



}
