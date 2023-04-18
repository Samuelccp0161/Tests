package Exercise_13;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class AlarmClockTest {
    private final List<String> finishedAlarms = Collections.synchronizedList(new ArrayList<>());
    private final Object monitor = new Object();
    private int count = 0;
    private AlarmListener alarmListener;

    @Before
    public void setUp() throws Exception {
        alarmListener = new AlarmListener() {
            @Override
            public void sendMessage(String message) {
                finishedAlarms.add(message);
                synchronized (monitor){
                    monitor.notifyAll();
                }
            }
        };
    }

    @Test
    public void alarmTest() throws InterruptedException {
        AlarmListener listener = new AlarmListener() {
            @Override
            public void sendMessage(String message) {
                finishedAlarms.add(message);
                synchronized (monitor){
                    monitor.notifyAll();
                }
            }
        };
        final String alarmMessage = "Alarm 1";
        final var alarmDuration = 500;
        AlarmClock alarmClock = new AlarmClock(listener);

        assertTrue("The alarm should not have finished already", finishedAlarms.isEmpty());
        alarmClock.start(alarmDuration, alarmMessage);

        long start = System.currentTimeMillis();

        synchronized (monitor){
            monitor.wait(alarmDuration * 2);
        }

        long finish = System.currentTimeMillis();

        assertEquals(alarmMessage, finishedAlarms.get(0));
        long timeElapsed = finish - start;
        assertEquals(alarmDuration, timeElapsed, 50);
    }
    @Test
    public void alarmsTest() throws InterruptedException {
        AlarmListener listener = new AlarmListener() {
            @Override
            public void sendMessage(String message) {
                finishedAlarms.add(message);
                synchronized (monitor){
                    monitor.notifyAll();
                }
            }
        };
        final String alarmMessage = "Alarm 1";
        final String alarmMessage2 = "Alarm 2";

        final var alarmDuration = 500;
        final var alarmDuration2 = 200;

        AlarmClock alarmClock = new AlarmClock(listener);

        alarmClock.start(alarmDuration, alarmMessage);
        alarmClock.start( alarmDuration2, alarmMessage2);

        Thread.sleep(alarmDuration2 + 30);
        assertEquals(alarmMessage2, finishedAlarms.get(0));
        Thread.sleep(alarmDuration - alarmDuration2);
        assertEquals(alarmMessage, finishedAlarms.get(1));


    }

    @Test
    public void cancelOneAlarmTest() throws InterruptedException {
        final String alarmMessage = "Alarm 1";
        final var alarmDuration = 500;
        AlarmClock alarmClock = new AlarmClock(alarmListener);

        alarmClock.start(alarmDuration, alarmMessage);

        alarmClock.cancel(alarmMessage);

        Thread.sleep(alarmDuration + 30);

        assertTrue(finishedAlarms.isEmpty());
    }

    @Test
    public void cancelAlarmTest() throws InterruptedException {
        final String alarm1 = "Alarm 1";
        final String alarm2 = "Alarm 2";

        final var alarmDuration = 500;
        AlarmClock alarmClock = new AlarmClock(alarmListener);

        alarmClock.start(alarmDuration, alarm1);
        alarmClock.start(alarmDuration, alarm2);

        alarmClock.cancel(alarm1);

        Thread.sleep(alarmDuration + 30);

        assertEquals(alarm2, finishedAlarms.get(0));
    }


}
