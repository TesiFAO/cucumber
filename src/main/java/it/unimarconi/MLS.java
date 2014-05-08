package it.unimarconi;

import it.unimarconi.Pratica3.Pratica3;
import it.unimarconi.pratica1.Pratica1;
import it.unimarconi.pratica2.Pratica2;

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

        System.out.println("****************************************************");
        System.out.println("*                     PRATICA 1                    *");
        System.out.println("****************************************************");
        System.out.println();

        int a = 5;
        int seed = 1;
        int b = 9;
        Pratica1 p = new Pratica1(a, seed, b);
        p.generaInsiemeInteri();

        a = 13;
        seed = 3;
        p = new Pratica1(a, seed, b);
        p.generaInsiemeInteri();

        a = 21;
        seed = 5;
        p = new Pratica1(a, seed, b);
        p.generaInsiemeInteri();

        a = 29;
        seed = 7;
        p = new Pratica1(a, seed, b);
        p.generaInsiemeInteri();

    }

    private static void pratica2() {

        System.out.println("****************************************************");
        System.out.println("*                     PRATICA 2                    *");
        System.out.println("****************************************************");
        System.out.println();

        int a = 5;
        int seed = 1;
        int b = 12;
        Pratica2 p2 = new Pratica2(a, seed, b);
        p2.printRn();

        int min = 30;
        int max = 50;
        p2 = new Pratica2(a, seed, b, min, max);
        p2.printRange();

        int avg = 20;
        p2 = new Pratica2(a, seed, b, avg);
        p2.printExponential();

        a = 5;
        int seedA = 1;
        int seedB = 15;
        double p = 0.38;
        p2 = new Pratica2(a, seedA, seedB, b, avg, p);
        p2.printHyperExponential();

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