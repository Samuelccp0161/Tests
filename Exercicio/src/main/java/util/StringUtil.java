package util;

public class StringUtil {

    private StringUtil(){};
    private static String NEWLINE = System.getProperty("line.separator");
    public static String appendNewLine(String line){
        return line + NEWLINE;
    }
}
