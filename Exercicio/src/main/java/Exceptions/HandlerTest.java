package Exceptions;

import util.StringUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class HandlerTest extends Handler {
    private final Map<String, Integer> mapTest = new HashMap<>();
    StringBuilder builder = new StringBuilder();
    private LogRecord record;
    @Override
    public void flush() {}
    @Override
    public void close() {}
    public String printLevels(){
        return builder.toString();
    }
    public void publish(LogRecord record){
        this.record = record;
        getFormatter().format(record);
        int count = 1 + getCount(record.getLevel().getName());
        mapTest.put(record.getLevel().getName(), count);
        builder.append(getFormatter().format(record));
        builder.append(StringUtil.appendNewLine(""));
    }
    public int getCount(String level){
        if (mapTest.get(level) == null) {
            return 0;
        }
        return mapTest.get(level);
    }
}
