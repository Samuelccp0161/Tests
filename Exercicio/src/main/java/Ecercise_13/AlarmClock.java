package Ecercise_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AlarmClock {
    AlarmListener listener;

    public AlarmClock(AlarmListener listener) {
        this.listener = listener;
    }
    HashMap<String, Thread> alarms = new HashMap<>();
    public void start(int millis, String message) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(millis);
                    listener.sendMessage(message);
                } catch (InterruptedException ignore) {
                }
            }
        });
        thread.start();
        alarms.put(message, thread);
//        th.interrupt();
    }

    public void cancel(String name) {
            alarms.get(name).interrupt();
    }
}

