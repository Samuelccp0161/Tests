package Exercise_13;

import Ecercise_13.AlarmClock;
import org.junit.Test;

import java.net.http.WebSocket;

import static org.junit.Assert.*;

public class AlarmClockTest {
//    @Test
//    public void alarmTest() throws InterruptedException {
//        final var millis = 5000;
//        AlarmClock alarmClock = new AlarmClock(millis);
//        long start = System.currentTimeMillis();
//        alarmClock.start();
//        long finish = System.currentTimeMillis();
//        long timeElapsed = finish - start;
//        assertEquals(millis, timeElapsed, 25);
//    }
    @Test
    public void alarmTest() throws InterruptedException {
        final var alarmDuration = 500;
        AlarmClock alarmClock = new AlarmClock(alarmDuration);

        assertFalse("The alarm should not have finished already", alarmClock.hasFinished());
        alarmClock.start();

        long start = System.currentTimeMillis();
        long finish = start;

        while (!alarmClock.hasFinished() /*&& finish - start < 2 * alarmDuration*/) {
            Thread.sleep(25);
            finish = System.currentTimeMillis();
        }


        assertTrue("The alarm did not finish", alarmClock.hasFinished());
        long timeElapsed = finish - start;
        assertEquals(alarmDuration, timeElapsed, 50);
    }
}
