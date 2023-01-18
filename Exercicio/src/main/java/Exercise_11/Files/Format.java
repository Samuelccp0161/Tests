package Exercise_11.Files;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Format extends Formatter {
    private HandlerTest handler ;
    public Format() {}
    public Format(HandlerTest handler) {
        this.handler = handler;
    }
    @Override
    public String format(LogRecord record) {
        if (handler == null) {
            return record.getLevel().getName() + record.getMessage();
        }
        return record.getLevel().getName() + record.getMessage() +
                "("+ record.getLevel() + " total = " +  handler.getCount(record.getLevel().getName()) +")";
    }
 }
