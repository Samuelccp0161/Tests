package Ecercise_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlarmClock {
    AlarmListener listener;
    AlarmClock alarmClock;

    public AlarmClock(AlarmListener listener) {
        this.listener = listener;
    }

    public void start(int millis, String message) throws InterruptedException {

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
}
