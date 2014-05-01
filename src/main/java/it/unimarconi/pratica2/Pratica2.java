package it.unimarconi.pratica2;

import it.unimarconi.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Pratica2 {

    private int a;

    private int seed;

    private int b;

    private int min;

    private int max;

    public Pratica2(int a, int seed, int b, int min, int max) {
        this.setA(a);
        this.setSeed(seed);
        this.setB(b);
        this.setMin(min);
        this.setMax(max);
    }

    public List<Double> generaIntervallo() {
        return Utils.generaIntervallo(this.getA(), this.getSeed(), this.getB(), this.getMin(), this.getMax());
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