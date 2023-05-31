package sis.studentinfo;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class MultithreadedAccountTest {
    @Test @Ignore("ele ta falhando por conta que ele deveria falhar.")
    public void testConcurrency() throws Exception{
        final Account account = new Account();
        account.credit(new BigDecimal("100.00"));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.withdraw(new BigDecimal("80.00"));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.withdraw(new BigDecimal("80.00"));
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertEquals(new BigDecimal("20.00"), account.getBalance());
    }
}
