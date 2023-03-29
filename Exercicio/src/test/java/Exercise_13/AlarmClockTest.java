package Exercise_13;

import Ecercise_13.AlarmClock;
import Ecercise_13.AlarmListener;
import org.junit.Test;

import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AlarmClockTest {

//    @Test
//    public void alarmTest() throws InterruptedException {
//        final var alarmDuration = 500;
//        AlarmClock alarmClock = new AlarmClock(alarmDuration);
//
//        assertFalse("The alarm should not have finished already", alarmClock.hasFinished());
//        alarmClock.start();
//
//        long start = System.currentTimeMillis();
//        long finish = start;
//
//        while (!alarmClock.hasFinished() && finish - start < 2 * alarmDuration) {
//            Thread.sleep(25);
//            finish = System.currentTimeMillis();
//        }
//        assertTrue("The alarm did not finish", alarmClock.hasFinished());
//        long timeElapsed = finish - start;
//        assertEquals(alarmDuration, timeElapsed, 50);
//    }

    private final List<String> finishedAlarms = Collections.synchronizedList(new ArrayList<>());
    @Test
    public void alarmTest() throws InterruptedException {
        AlarmListener listener = new AlarmListener() {
            @Override
            public void sendMessage(String message) {
                finishedAlarms.add(message);
            }
        };

        final String alarmMessage = "Alarm 1";
        final var alarmDuration = 500;
        AlarmClock alarmClock = new AlarmClock(alarmDuration, listener, alarmMessage);

        assertTrue("The alarm should not have finished already", finishedAlarms.isEmpty());
        alarmClock.start();

        long start = System.currentTimeMillis();
        long finish = start;

        while (finishedAlarms.isEmpty() && finish - start < 2 * alarmDuration) {
            Thread.sleep(25);
            finish = System.currentTimeMillis();
        }
        assertEquals(alarmMessage, finishedAlarms.get(0));
        long timeElapsed = finish - start;
        assertEquals(alarmDuration, timeElapsed, 50);
    }
}
