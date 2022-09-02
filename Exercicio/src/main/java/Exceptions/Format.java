package Exceptions;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Format extends Formatter {
    private Handler handler ;
    HandlerTest handlerTest = new HandlerTest();
    public Format() {}
    public Format(Handler handler) {
        this.handler = handler;
    }
    @Override
    public String format(LogRecord record) {
        if (handler == null)
            return record.getLevel().getName() + record.getMessage();
        return record.getLevel().getName() + record.getMessage() + handlerTest.getCount(record.getLevel().getName());
    }
 }
