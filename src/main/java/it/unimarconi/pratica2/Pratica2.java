package it.unimarconi.pratica2;

import it.unimarconi.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Pratica2 {

    private int a;

    private int seed1;

    private int seed2;

    private int b;

    private int min;

    private int max;

    private int avg;

    private double p;

    public Pratica2(int a, int seed, int b, int min, int max) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
        this.setMin(min);
        this.setMax(max);
    }

    public Pratica2(int a, int seed, int b, int avg) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
        this.setAvg(avg);
    }

    public Pratica2(int a, int seed, int b, int avg, double p) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
        this.setAvg(avg);
        this.setP(p);
    }

    public Pratica2(int a, int seed1, int seed2, int b, int avg, double p) {
        this.setA(a);
        this.setSeed1(seed1);
        this.setSeed2(seed2);
        this.setB(b);
        this.setAvg(avg);
        this.setP(p);
    }

    public Pratica2(int a, int seed, int b) {
        this.setA(a);
        this.setSeed1(seed);
        this.setB(b);
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