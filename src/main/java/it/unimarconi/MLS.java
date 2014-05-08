package it.unimarconi;

import it.unimarconi.Pratica3.Pratica3;

public class MLS {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.equals("1"))
                pratica1();
            else if (arg.equals("2"))
                pratica2();
            else if (arg.equals("3"))
                pratica3();
            else if (arg.equals("4"))
                pratica4();
        }
    }

    private static void pratica1() {

    }

    private static void pratica2() {

    }

    private static void pratica3() {

        System.out.println("****************************************************");
        System.out.println("*                     PRATICA 3                    *");
        System.out.println("****************************************************");
        System.out.println();

        Pratica3 p3;
        int a = 5;
        int seed = 1;
        int b = 12;
        p3 = new Pratica3(a, seed, b);
        p3.printRn();

        int min = 30;
        int max = 50;
        p3 = new Pratica3(a, seed, b, min, max);
        p3.printRange();

        int avg = 20;
        p3 = new Pratica3(a, seed, b, avg);
        p3.printExp();

        a = 61;
        int seedA = 1;
        int seedB = 15;
        double p = 0.38;
        p3 = new Pratica3(a, seedA, seedB, b, avg, p);
        p3.printHyperExp();

    }

    private static void pratica4() {

    }

}