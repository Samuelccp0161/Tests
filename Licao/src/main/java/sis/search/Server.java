package sis.search;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server extends Thread {
    private BlockingQueue<Search> queue = new LinkedBlockingQueue<Search>();
    private ResultsListener listener;
    public static final String START_MSG = "started";
    public static final String END_MSG = "finished";
    private static ThreadLocal<List<String>> threadLog = new ThreadLocal<>(){
        protected List<String> initialValue(){
            return new ArrayList<>();
        }
    };
    private List<String> completeLog = Collections.synchronizedList(new ArrayList<>());
    public Server(ResultsListener listener){
        this.listener = listener;
        start();
    }
    public void run(){
        while (true){
            try {
             execute(queue.take());
            }catch (InterruptedException e){
                break;
            }
        }
    }

    public void add(Search search) throws Exception{
        queue.put(search);
    }
    public List<String> getLog(){
        return completeLog;
    }
    private void execute(Search search){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log(START_MSG, search);
                search.execute();
                log(END_MSG, search);
                listener.executed(search);
                completeLog.addAll(threadLog.get());
            }
        });
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread th, Throwable throwable){
                System.out.println("caught");
                completeLog.add(search + " " + throwable.getMessage());
                listener.executed(search);
            }
        });
        thread.start();
    }
    private void log(String message, Search search){
        threadLog.get().add(search + " " + message + " at " + new Date());
    }
    public void shutDown() throws  Exception{
        this.interrupt();
    }

}
