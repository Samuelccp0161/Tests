package Ecercise_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AlarmClock {
    AlarmListener listener;
    HashMap<Integer, String> alarms = new HashMap<>();
    public AlarmClock(AlarmListener listener) {
        this.listener = listener;
    }

    public void start(int millis, String message) throws InterruptedException {

        alarms.put(millis, message);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(millis);
                    listener.sendMessage(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public String getMessage(int i) {
        return alarms.get(i);
    }
    public void cancel(String name) {

    }
}

