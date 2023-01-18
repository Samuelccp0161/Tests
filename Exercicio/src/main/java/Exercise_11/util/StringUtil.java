package Exercise_11.util;

public class StringUtil {
    private StringUtil(){}
    private final static String NEWLINE = System.getProperty("line.separator");
    public static String appendNewLine(String line){
        return line + NEWLINE;
    }
}
