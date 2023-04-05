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
    private final List<String> finishedAlarms = Collections.synchronizedList(new ArrayList<>());
    private final Object monitor = new Object();
    private int count = 0;

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
        AlarmClock alarmClock = new AlarmClock(alarmDuration, listener, alarmMessage);

        assertTrue("The alarm should not have finished already", finishedAlarms.isEmpty());
        alarmClock.start();

        long start = System.currentTimeMillis();

        synchronized (monitor){
            monitor.wait(alarmDuration * 2);
        }

        long finish = System.currentTimeMillis();

        assertEquals(alarmMessage, finishedAlarms.get(0));
        long timeElapsed = finish - start;
        assertEquals(alarmDuration, timeElapsed, 50);
    }

//    @Test
//    public void alarmTest() throws InterruptedException {
//        AlarmListener listener = new AlarmListener() {
//            @Override
//            public void sendMessage(String message) {
//                finishedAlarms.add(message);
//            }
//        };
//        final String alarmMessage = "Alarm 1";
//        final var alarmDuration = 500;
//        AlarmClock alarmClock = new AlarmClock(alarmDuration, listener, alarmMessage);
//        Object b = new Object();
//
//        assertTrue("The alarm should not have finished already", finishedAlarms.isEmpty());
//        alarmClock.start();
//
//        long start = System.currentTimeMillis();
//        long finish = start;
//
//
//        while (finishedAlarms.isEmpty() && finish - start < 2 * alarmDuration) {
//            Thread.sleep(25);
//            finish = System.currentTimeMillis();
//        }
//        assertEquals(alarmMessage, finishedAlarms.get(0));
//        long timeElapsed = finish - start;
//        assertEquals(alarmDuration, timeElapsed, 50);
//    }
}
