package sis.studentinfo;

import java.util.logging.*;

class HandlerTest extends Handler {
    private LogRecord record;

    @Override
    public void flush() {}

    @Override
    public void close() {}

    public void publish(LogRecord record){
        this.record = record;
    }
    String getMessage(){
        return record.getMessage();
    }
}
