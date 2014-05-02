package it.unimarconi.Pratica3;

import it.unimarconi.utils.Utils;

import java.util.List;

public class Pratica3 {

    private int a;

    private int seed;

    private int b;

    private int min;

    private int max;

    private int avg;

    private double p;

    public Pratica3(int a, int seed, int b, int min, int max) {
        this.setA(a);
        this.setSeed(seed);
        this.setB(b);
        this.setMin(min);
        this.setMax(max);
    }

    public Pratica3(int a, int seed, int b, int avg) {
        this.setA(a);
        this.setSeed(seed);
        this.setB(b);
        this.setAvg(avg);
    }

    public Pratica3(int a, int seed, int b, int avg, double p) {
        this.setA(a);
        this.setSeed(seed);
        this.setB(b);
        this.setAvg(avg);
        this.setP(p);
    }

    public List<Double> generaIntervallo() {
        return Utils.generaIntervallo(this.getA(), this.getSeed(), this.getB(), this.getMin(), this.getMax());
    }

    public List<Double> generaEsponenziale() {
        return Utils.generaEsponenziale(this.getA(), this.getSeed(), this.getB(), this.getAvg());
    }

    public List<Double> generaIperesponenziale() {
        return Utils.generaIpersponenziale(this.getA(), this.getSeed(), this.getB(), this.getAvg(), this.getP());
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

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
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