package chess;

import java.util.Enumeration;
import java.util.Vector;

public class Sequential {
    public static String sequence(int n) {
        StringBuilder sequence = new StringBuilder();
        sequence.append(1);
        for (int i = 2; i <= n ; i++) {
            sequence.append(" ");
            sequence.append(i);
            if (i % 5 == 0) {
            }
            else continue;
            sequence.append("*");
        }

        return sequence.toString();
    }
    public static Vector subStringVector(String sequence){
        Vector stringVector = new Vector<>();
        for (String n : sequence.split(" "))
            stringVector.add(n);
        return stringVector;
    }
    public static String vectorToString(Vector n) {

        StringBuilder builder = new StringBuilder();
        for (Enumeration it = n.elements(); it.hasMoreElements(); ) {
            String string = (String) it.nextElement();
            builder.append(string);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() -1);
        return builder.toString();
    }
}
