package Ecercise_13;

public class AlarmClock {
//    public ListenerEvent event;
    public int millis;
    private boolean alarmHasFinished = false;
    public AlarmClock(int millis){
        this.millis = millis;
    }

    public void start() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(millis);
                    alarmHasFinished = true;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }

    public boolean hasFinished() throws InterruptedException {
        return alarmHasFinished;
    }
}
