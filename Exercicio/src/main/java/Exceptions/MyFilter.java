package Exceptions;

import java.util.logging.*;

public class MyFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        if (record.getLevel() == Level.INFO) return true;
        return false;
    }
}
