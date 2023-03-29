package Ecercise_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlarmClock {
    public int millis;
    AlarmListener listener;
    String message;

    public AlarmClock(int millis, AlarmListener listener, String message) {
        this.millis = millis;
        this.listener = listener;
        this.message = message;
    }

    public void start() throws InterruptedException {

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
