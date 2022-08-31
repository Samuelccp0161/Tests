package Exceptions;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Format extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getLevel().getName() + record.getMessage();
    }
}