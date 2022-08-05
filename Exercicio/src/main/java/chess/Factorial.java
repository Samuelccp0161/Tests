package chess;


import java.util.Enumeration;
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

}
