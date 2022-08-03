package chess;


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
//    public static Vector<String> sequence1(String n) {
//
//        List<String> sequence1 = new Vector<String>();
//        sequence1.add("1");
//        for (int i = 2; i <=   ; i++) {
//            sequence1.add(" ");
//            sequence1.add("i");
//            if (i % 5 == 0) {
//            }
//            else continue;
//            sequence1.add("*");
//        }
//
//        return ;
//    }
}


//4*3*2*1.
