package chess;



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
//        int valor = n
        StringBuilder sequence = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            sequence.append(i);
            sequence.append(" ");

            System.out.println(n);
        }
        return sequence.toString();
    }
}


//4*3*2*1.
