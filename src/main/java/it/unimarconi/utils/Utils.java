package it.unimarconi.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Guido Barbaglia
 */
public class Utils {

    public static double Z25 = -0.674;

    public static double Z75 = 0.674;

    public static double Z99 = 2.326;

    public static double Z10 = -1.282;

    public static double Z90 = 1.282;

    public static List<Integer> generaClassi(List<Double> l, int numeroGruppi) {
        double max = max(l);
        double min = min(l);
        List<Integer> classi = new ArrayList<Integer>();
        for (int i = 0 ; i < numeroGruppi ; i++)
            classi.add(0);
        double step = (max - min) / numeroGruppi;
        for (int i = 0 ; i < l.size() ; i++) {
            Double d = l.get(i);
            int classe = (int) ((d / step) - (min / 2.0));
            if (classe >= numeroGruppi)
                classe = numeroGruppi - 1;
            classi.set(classe, 1 + classi.get(classe));
        }
        return classi;
    }

    public static List<Double> generaSoglie(List<Double> l, int numeroGruppi) {
        List<Double> soglie = new ArrayList<Double>();
        double max = max(l);
        double min = min(l);
        double step = (max - min) / numeroGruppi;
        for (int i = 0 ; i < numeroGruppi ; i++)
            soglie.add(min + i * step);
        return soglie;
    }

    public static List<Double> calcolaFrequenzeRelative(List<Integer> ll, double lunghezzaPeriodo) {
        List<Double> out = new ArrayList<Double>();
        for (Integer l : ll)
            out.add((double)l / lunghezzaPeriodo);
        return out;
    }

    public static List<Double> calcolaDensita(List<Double> l, List<Double> freqs) {
        List<Double> out = new ArrayList<Double>();
        double max = max(l);
        double min = min(l);
        double step = (max - min) / freqs.size();
        for (int i = 0 ; i < freqs.size() ; i++)
            out.add(freqs.get(i) / step);
        return out;
    }

    public static List<Double> calcolaCumulata(List<Double> freqs, List<Integer> ranges) {
        List<Double> out = new ArrayList<Double>();
        for (int i = 0 ; i < freqs.size() ; i++) {
            double sum = 0.0;
            for (int j = 0 ; j <= i ; j++)
                sum += freqs.get(j);
            out.add(sum);
        }
        return out;
    }

    public static List<Double> generaClassi(List<Double> l, List<Double> soglie) {
        List<Double> classi = new ArrayList<Double>();
        return classi;
    }

    public static double max(List<Double> l) {
        double max = 0.0;
        for (Double d : l)
            if (d > max)
                max = d;
        return max;
    }

    public static double min(List<Double> l) {
        double min = Double.MAX_VALUE;
        for (Double d : l)
            if (d < min)
                min = d;
        return min;
    }

    /**
     * @param a  a
     * @param x0 Seed
     * @param b  m = 2 ^ b
     * @return Sequenza pseudo-casuale
     * <p/>
     * Genera una sequenza di valori pseudo-casuali
     * tramite generatore congruente moltiplicativo
     */
    public static List<Integer> generaCongruenteMoltiplicativo(Integer a, Integer x0, Integer b) {
        List<Integer> l = new ArrayList<Integer>();
        Integer next = x0;
        int m = (int)Math.pow(2, b);
        while (!l.contains(next)) {
            l.add(next);
            next = (a * next) % m;
        }
        return l;
    }

    public static List<Integer> corollarioA1(Integer b) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0 ; i <= ((int)Math.pow(2, b-2) - 1) ; i++)
            l.add(1 + 4 * i);
        return l;
    }

    public static List<Integer> corollarioA2(Integer b) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0 ; i <= ((int)Math.pow(2, b-2) - 1) ; i++)
            l.add(3 + 4 * i);
        return l;
    }

    /**
     * @param a  a
     * @param x0 Seed
     * @param b  Potenza di 2
     * @return Sequenza pseudo-casuale di valori compresi tra 0 ed 1
     * <p/>
     * Genera una sequenza di valori pseudo-casuali
     * compresi tra 0 ed 1
     * tramite generatore congruente moltiplicativo
     */
    public static List<Double> generaRn(int a, int x0, int b) {
        double m = Math.pow(2.0, b);
        List<Double> l1 = new ArrayList<Double>();
        List<Double> l2 = new ArrayList<Double>();
        double next = x0;
        while (!l1.contains(next)) {
            l1.add(next);
            next = (a * next) % m;
        }
        for (Double d : l1)
            l2.add(d / m);
//        System.out.println(l2.size() + " rns");
        return l2;
    }

    public static List<Double> generaIntervallo(int a, int x0, int b, int min, int max) {
        List<Double> rns = generaRn(a, x0, b);
        List<Double> l = new ArrayList<Double>();
        for(Double rn : rns)
            l.add(min + rn * (max - min));
        return l;
    }

    public static List<Double> generaEsponenziale(int a, int seed, int b, int avg) {
        List<Double> l = new ArrayList<Double>();
        List<Double> rns = generaRn(a, seed, b);
        for(Double rn : rns)
            l.add(-avg * Math.log(rn));
        return l;
    }

    public static List<Double> generaIpersponenziale(int a, int seed1, int seed2, int b, int avg, double p) {
        List<Double> zs = new ArrayList<Double>();
        List<Double> rns = generaRn(a, seed1, b);
        List<Double> Xs = generaEsponenziale(a, seed2, b, 1);
        for (int i = 0 ; i < rns.size() ; i++) {
            if (rns.get(i) <= p) {
                zs.add(Xs.get(i) * (avg / (2.0 * p)));
            } else {
                zs.add(Xs.get(i) * (avg / (2.0 * (1.0 - p))));
            }
        }
        return zs;
    }

    public static double calcolaMedia(List<Double> l) {
        double s = 0.0;
        for (Double d : l)
            s += d;
        return s / l.size();
    }

    public static double calcolaVarianza(List<Double> l) {
        double s = 0.0;
        double media = calcolaMedia(l);
        for (Double d : l)
            s += Math.pow((d - media), 2);
        return s / l.size();
    }

    /**
     * @param m Pendenza retta
     * @param q Intercetta retta
     * @return Lista di valori interi
     * <p/>
     * Genera una sequenza valutando a = q mod m che equivale ad a = m * t + q
     * @values Numero di valori da generare per la sequenza
     */
    public static List<Integer> generaA(Integer m, Integer q, Integer values) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < values; i++)
            l.add(i * m + q);
        return l;
    }

    /**
     * @param b m = 2 ^b
     * @return Lista di valori dispari minori del modulo <code>m</code> dato
     * <p/>
     * Generazione di sequenza di numeri dispari minori del modulo dato
     */
    public static List<Integer> generaX(Integer b) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i < Math.pow(2, b); i += 2)
            l.add(i);
        return l;
    }

    public static void print_int(List<Integer> l) {
        for (int i = 0 ; i < l.size() ; i++) {
            System.out.print(l.get(i));
            if (i < l.size() - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public static void print_double(List<Double> l) {
        for (int i = 0 ; i < l.size() ; i++) {
            System.out.print(l.get(i));
            if (i < l.size() - 1)
                System.out.print(", ");
        }
        System.out.println();
    }

    public static double calcolaV(List<Double> yss, double n, double ps) {
        double v = 0.0;
        double nps = n * ps;
//        nps = 164;
        for (int i = 0 ; i < yss.size() ; i++) {
//            System.out.println("categoria " + i + " contiene " + yss.get(i) + " -> " + (Math.pow(yss.get(i) - nps, 2) / nps));
            v += Math.pow(yss.get(i) - nps, 2) / nps;
        }
//        System.out.println("nps: " + nps);
//        System.out.println("v: " + v);
//        System.out.println();
        return v;
    }

    public static double calcolaVseriale(List<Double> yss, double n, double ps) {
        double v = 0.0;
        double nps = (n / 4096.0) / 2;
        nps = (43000.0 / 2.0) / 4096.0;
//        nps = 164;
        double v1 = 0;
        for (int i = 0 ; i < yss.size() ; i++) {
            System.out.println("categoria " + i + " contiene " + yss.get(i) + " -> " + (Math.pow(yss.get(i) - nps, 2) / nps));
            v += Math.pow(yss.get(i) - nps, 2) / nps;
            if  ( yss.get(i) <= 0)
                v1 += Math.pow(yss.get(i) - nps, 2) / nps;
        }
        System.out.println("nps: " + nps);
        System.out.println("v: " + v);
        System.out.println("v1: " + v1);
        System.out.println();
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

}