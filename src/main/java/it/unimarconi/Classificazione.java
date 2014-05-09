package it.unimarconi;

import java.util.List;

public class Classificazione {

    public static int freedomDegrees;

    public static double Z01 = -2.326;

    public static double CHI_01;

    public static double Z05 = -1.645;

    public static double CHI_05;

    public static double Z10 = -1.282;

    public static double CHI_10;

    public static double Z25 = -0.674;

    public static double CHI_25;

    public static double Z75 = 0.674;

    public static double CHI_75;

    public static double Z90 = 1.282;

    public static double CHI_90;

    public static double Z95 = 1.645;

    public static double CHI_95;

    public static double Z99 = 2.326;

    public static double CHI_99;

    public static double R1;

    public static double R2;

    public static double[] S1;

    public static double[] S2;

    public static double[] Q1;

    public static double[] Q2;

    public static double[] OK;

    public Classificazione(double freedomDegrees) {
        CHI_01 = calcolaChiQuadro(freedomDegrees, Z01);
        CHI_05 = calcolaChiQuadro(freedomDegrees, Z05);
        CHI_10 = calcolaChiQuadro(freedomDegrees, Z10);
        CHI_25 = calcolaChiQuadro(freedomDegrees, Z25);
        CHI_75 = calcolaChiQuadro(freedomDegrees, Z75);
        CHI_90 = calcolaChiQuadro(freedomDegrees, Z90);
        CHI_95 = calcolaChiQuadro(freedomDegrees, Z95);
        CHI_99 = calcolaChiQuadro(freedomDegrees, Z99);
        R1 = CHI_01;
        R2 = CHI_99;
        S1 = new double []{CHI_01, CHI_05};
        S2 = new double []{CHI_95, CHI_99};
        Q1 = new double []{CHI_05, CHI_10};
        Q2 = new double []{CHI_90, CHI_95};
        OK = new double []{CHI_25, CHI_75};
//        System.out.println(R1);
//        System.out.println(R2);
//        System.out.println(S1[0] + " to " + S1[1]);
//        System.out.println(S2[0] + " to " + S2[1]);
//        System.out.println(Q1[0] + " to " + Q1[1]);
//        System.out.println(OK[0] + " to " + OK[1]);
    }

    public String classifica(double v) {
        if (v <= R1 || v >= R2)
            return "Rigetto";
        else if (v >= OK[0] && v <= OK[1])
            return "Accettabile";
        else if (v < OK[0] || v > OK[1])
            return "Rigetto";
        else if (v >= Q1[0] && v <= Q1[1])
            return "Quasi Sospetto";
        else if (v >= Q2[0] && v <= Q2[1])
            return "Quasi Sospetto";
        else if (v >= S1[0] && v <= S1[1])
            return "Sospetto";
        else if (v >= S2[0] && v <= S2[1])
            return "Sospetto";
        return "Non si sa";
    }

    public static double calcolaV(List<Double> yss, double n, double ps) {
        double v = 0.0;
        double nps = n * ps;
        for (int i = 0 ; i < yss.size() ; i++)
            v += (Math.pow(yss.get(i) - nps, 2) / nps);
        return v;
    }

    public static double calcolaChiQuadro(double df, double za) {
        double a = 1.0;
        double b = 2.0 / (9.0 * df);
        double c = za * Math.sqrt(2.0 / (9.0 * df));
        double abc = a - b + c;
        double cube = Math.pow(abc, 3);
        return (df * cube);
    }

    public static int getFreedomDegrees() {
        return freedomDegrees;
    }

    public static void setFreedomDegrees(int freedomDegrees) {
        Classificazione.freedomDegrees = freedomDegrees;
    }

}