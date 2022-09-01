package Exceptions;

import util.StringUtil;

import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class HandlerTest extends Handler {
    private final Map<String, Integer> mapTest = new HashMap<>();
    private LogRecord record;
    @Override
    public void flush() {}
    @Override
    public void close() {}
    StringBuilder builder = new StringBuilder();
    public void publish(LogRecord record){
        this.record = record;
        Format format = new Format();
        int tendeu = 1 + getCount(record.getLevel().getName());
        mapTest.put(record.getLevel().getName(), tendeu);
        builder.append(format.format(record));
        builder.append(StringUtil.appendNewLine(""));
    }
    public String guardianStrelar(){
        return builder.toString();
    }
    String getMessage(){
        return record.getMessage();
    }
    public int getCount(String level){
        if (mapTest.get(level) == null) {
            return 0;
        }
        return mapTest.get(level);
    }
    public LogRecord logRecord(){
        return record;

    }
}
