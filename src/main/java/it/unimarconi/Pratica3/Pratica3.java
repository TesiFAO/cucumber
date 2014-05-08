package it.unimarconi.Pratica3;

import it.unimarconi.utils.Utils;

import java.text.DecimalFormat;
import java.util.List;

public class Pratica3 {

    private int a;

    private int seed1;

    private int seed2;

    private int b;

    private int min;

    private int max;

    private int avg;

    private double p;

    private DecimalFormat df = new DecimalFormat("#0.0000");

    public Pratica3(int a, int seed, int b, int min, int max) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
        this.setMin(min);
        this.setMax(max);
    }

    public Pratica3(int a, int seed, int b, int avg) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
        this.setAvg(avg);
    }

    public Pratica3(int a, int seed, int b) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
        this.setAvg(avg);
    }

    public Pratica3(int a, int seed1, int seed2, int b, int avg, double p) {
        this.setA(a);
        this.setSeed1(seed1);
        this.setSeed2(seed2);
        this.setB(b);
        this.setAvg(avg);
        this.setP(p);
    }

    public List<Double> generaRn() {
        return Utils.generaRn(this.getA(), this.getSeed1(), this.getB());
    }

    public List<Double> generaIntervallo() {
        return Utils.generaIntervallo(this.getA(), this.getSeed1(), this.getB(), this.getMin(), this.getMax());
    }

    public List<Double> generaEsponenziale() {
        return Utils.generaEsponenziale(this.getA(), this.getSeed1(), this.getB(), this.getAvg());
    }

    public List<Double> generaIperesponenziale() {
        return Utils.generaIpersponenziale(this.getA(), this.getSeed1(), this.getSeed2(), this.getB(), this.getAvg(), this.getP());
    }

    public void print() {
        printRn();
        printRange();
        printExp();
        printHyperExp();
    }

    public void printRn() {
        List<Double> l = generaRn();
        int numeroClassi = 10;
        System.out.println("*********************************");
        System.out.println("*          SEQUENZA RN          *");
        System.out.println("*********************************");
        System.out.println();
        System.out.println("a: " + this.getA());
        System.out.println("seed: " + this.getSeed1());
        System.out.println("b: " + this.getB());
        System.out.println();
        printOut(l);
    }

    public void printRange() {
        List<Double> l = generaIntervallo();
        int numeroClassi = 10;
        System.out.println("********************************************************************");
        System.out.println("*          SEQUENZA UNIFORMEMENTE DISTRIBUITA IN (30, 50)          *");
        System.out.println("********************************************************************");
        System.out.println();
        System.out.println("a: " + this.getA());
        System.out.println("seed: " + this.getSeed1());
        System.out.println("b: " + this.getB());
        System.out.println("min: " + this.getMin());
        System.out.println("max: " + this.getMax());
        System.out.println();
        printOut(l);
    }

    public void printExp() {
        List<Double> l = generaEsponenziale();
        int numeroClassi = 10;
        System.out.println("*******************************************************");
        System.out.println("*          SEQUENZA ESPONENZIALE DI MEDIA 20          *");
        System.out.println("*******************************************************");
        System.out.println();
        System.out.println("a: " + this.getA());
        System.out.println("seed: " + this.getSeed1());
        System.out.println("b: " + this.getB());
        System.out.println("avg: " + this.getAvg());
        System.out.println();
        printOut(l);
    }

    public void printHyperExp() {
        List<Double> l = generaIperesponenziale();
        int numeroClassi = 10;
        System.out.println("*******************************************************************************");
        System.out.println("*          SEQUENZA IPERESPONENZIALE DI MEDIA 20 E PARAMETRO p = 0.38         *");
        System.out.println("*******************************************************************************");
        System.out.println();
        System.out.println("a: " + this.getA());
        System.out.println("seed 1: " + this.getSeed1());
        System.out.println("seed 2: " + this.getSeed2());
        System.out.println("avg: " + this.getAvg());
        System.out.println("p: " + this.getP());
        System.out.println();
        printOut(l);
    }

    public void printOut(List<Double> l) {
        int numeroClassi = 10;
        List<Double> soglie = Utils.generaSoglie(l, numeroClassi);
        List<Integer> classi = Utils.generaClassi(l, numeroClassi);
        List<Double> freqRelative = Utils.calcolaFrequenzeRelative(classi, l.size());
        List<Double> densita = Utils.calcolaDensita(l, freqRelative);
        List<Double> cumulata = Utils.calcolaCumulata(freqRelative, classi);
        String seq = "Sequenza:\ndata: [";
        String occorrenze = "Occorrenze:\ndata: [";
        String f = "Frequenze Relative:\ndata: [";
        String d = "Densita:\ndata: [";
        String c = "Cumulata:\ndata: [";
        String cat = "categories: [";
        for (int z = 0 ; z < soglie.size() - 1; z++) {
            cat += "'" + soglie.get(z) + " to " + soglie.get(1 + z) + "'";
            if (z < soglie.size() - 1)
                cat += ", ";
        }
        cat += "'" + soglie.get(soglie.size() - 1) + " to " + Utils.max(l) + "'";
        for (int i = 0 ; i < freqRelative.size() ; i++) {
            seq += l.get(i);
            f += df.format(freqRelative.get(i));
            d += df.format(densita.get(i));
            c += df.format(cumulata.get(i));
            occorrenze += classi.get(i);
            if (i < freqRelative.size() - 1) {
                f += ", ";
                d += ", ";
                c += ", ";
                seq += ", ";
                occorrenze += ", ";
            }
        }
        f += "]";
        d += "]";
        c += "]";
        seq += " ...]";
        cat += "]";
        occorrenze += "]";
        System.out.println(seq + "\n");
        System.out.println(cat + "\n");
        System.out.println(occorrenze + "\n");
        System.out.println(f + "\n");
        System.out.println(d + "\n");
        System.out.println(c + "\n");
        System.out.println("Media: " + Utils.calcolaMedia(l));
        System.out.println("Varianza: " + Utils.calcolaVarianza(l));
        System.out.println();
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getSeed1() {
        return seed1;
    }

    public void setSeed1(int seed1) {
        this.seed1 = seed1;
    }

    public int getSeed2() {
        return seed2;
    }

    public void setSeed2(int seed2) {
        this.seed2 = seed2;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}