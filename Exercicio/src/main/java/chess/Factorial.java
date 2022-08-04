package chess;


import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Factorial {
    public static int factorial1(int fator) {
        int result = 1;
        int valor = fator;

        while (valor > 1) {
            result *= valor;
            valor--;
            System.out.println(result);
        }
        return result;
    }

    public static int factorial2(int fator) {
        int result = 1;
        int valor = fator;

        for (int i = 0; i <= valor; i++) {
            result *= valor;
            valor--;
            System.out.println(result);
        }
        return result;
    }

    public static int factorial3(int fator) {
        int result = 1;
        int valor = fator;

        do {
            result *= valor;
            valor--;
        }
        while (valor > 1);
        return result;
    }

    public static int factorial4(int fator) {
        int result = 1;
        int valor = fator;

        while (true) {
            result *= valor;
            valor--;
            System.out.println(result);

            if (valor < 1) {
                break;
            }
        }
        return result;
    }

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
    public static Vector<String> stringVersion(String sequence){
        Vector<String> string = new Vector<String>();
        for (String n : sequence.split(" "))
            string.add(n);
        return string;
    }
    public static String sequence1(Vector<String> n) {

        Vector<String> listSequence = new Vector<String>();
        for (Enumeration<String> it = listSequence.elements();
        it.hasMoreElements();) {

            String string = it.nextElement();
        }
//        if()
    return null;
    }
}


//4*3*2*1.
