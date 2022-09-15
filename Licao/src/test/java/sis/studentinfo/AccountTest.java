package sis.studentinfo;

import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testTransactions() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        assertEquals(new BigDecimal("11.10"), account.getBalance());
    }
    @Test
    public void testTransactionAverage() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));
        assertEquals(new BigDecimal("4.70"), account.transactionAverage());
    }
    @Test
    public void testAverageForNoScores() {
        Performance performance = new Performance();
        assertEquals(0.0, performance.average(),0.00);
        assertFalse(Double.isNaN(performance.average()));
    }
    @Test
    public void testFlags() {
        Student student = new Student("a");
        student.set(
                Student.Flag.ON_CAMPUS,
                Student.Flag.TAX_EXEMPT,
                Student.Flag.MINOR);
        assertTrue(student.isOn(Student.Flag.ON_CAMPUS));
        assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
        assertTrue(student.isOn(Student.Flag.MINOR));
        assertFalse(student.isOff(Student.Flag.ON_CAMPUS));
        assertTrue(student.isOff(Student.Flag.TROUBLEMAKER));
        student.unset(Student.Flag.ON_CAMPUS);
        assertTrue(student.isOff(Student.Flag.ON_CAMPUS));
        assertTrue(student.isOn(Student.Flag.TAX_EXEMPT));
        assertTrue(student.isOn(Student.Flag.MINOR));
    }
    @Test
    public void testParity() {
        assertEquals(0, xorAll(0, 1, 0, 1));
        assertEquals(1, xorAll(0, 1, 1, 1));
    }
    private int xorAll(int first, int... rest) {
        int parity = first;
        for (int num: rest)
            parity ^= num;
        return parity;
    }
}
