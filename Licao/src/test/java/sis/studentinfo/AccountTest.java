package sis.studentinfo;

import com.jimbob.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class AccountTest {
    static final String ABA = "102000012";
    static final String ACCOUNT_NUMBER = "194431518811";
    private Account account;
    @Before
    public void setUp(){
        account = new Account();
        account.setBankAba(ABA);
        account.setBankAccountNumber(ACCOUNT_NUMBER);
        account.setBankAccountType(Account.BankAccountType.CHECKING);
    }
    @Test
    public void testTransferFromBank(){
        Ach mockAch = new MockAch() {
            @Override
            public AchResponse issueDebit(AchCredentials credentials, AchTransactionData data) {
//                Assert.assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
//                Assert.assertTrue(data.aba.equals(AccountTest.ABA));
//
//                AchResponse response = new AchResponse();
//                response.timestamp = new Date();
//                response.traceCode = "1";
//                response.status = AchStatus.SUCCESS;
//                return response;
                return null;
            }
            @Override
            public AchResponse markTransactionAsNSF(AchCredentials credentials, AchTransactionData data, String traceCode) {
                return null;
            }
            @Override
            public AchResponse voidSameDayTransaction(AchCredentials credentials, AchTransactionData data, String traceCode) {
                return null;
            }
            @Override
            public AchResponse queryTransactionStatus(AchCredentials credentials, AchTransactionData data, String traceCode) {
                return null;
            }
        };
//        account.setAch(new com.jimbob.ach.JimbobAch());
        account.setAch(new MockAch());

        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);

        assertEquals(amount, account.getBalance());
    }
    @Test
    public void testWithdraw() throws Exception {
        account.credit(new BigDecimal("100.00"));
        account.withdraw(new BigDecimal("40.00"));
        assertEquals(new BigDecimal("60.00"), account.getBalance());
    }
    @Test
    public void testWithdrawInsufficientFounds(){
        account.credit(new BigDecimal("100.00"));
        account.withdraw(new BigDecimal("40.00"));
        assertEquals(new BigDecimal("60.00"), account.getBalance());
    }
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
    public void testFailedTransferFromBank(){
        account.setAch(createMockAch(AchStatus.FAILURE));
        final BigDecimal amount = new BigDecimal("50.00");
        account.transferFromBank(amount);
        assertEquals(new BigDecimal("0.00"), account.getBalance());
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
    private Ach createMockAch(final AchStatus status) {
        return new MockAch() {
            public AchResponse issueDebit(
                    AchCredentials credentials, AchTransactionData data) {
                Assert.assertTrue(data.account.equals(AccountTest.ACCOUNT_NUMBER));
                Assert.assertTrue(data.aba.equals(AccountTest.ABA));
                AchResponse response = new AchResponse();
                response.timestamp = new Date();
                response.traceCode = "1";
                response.status = status;
                return response;
            }
        };
    }
}
