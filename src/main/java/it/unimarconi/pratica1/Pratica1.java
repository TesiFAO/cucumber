package it.unimarconi.pratica1;

import it.unimarconi.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Pratica1 {

    private int a;

    private int seed;

    private int b;

    public Pratica1(int a, int seed, int b) {
        this.setA(a);
        this.setSeed(seed);
        this.setB(b);
    }

    public List<List<Integer>> generaInsiemeInteri() {
        List<Integer> xos = Utils.generaX(this.getB());
        List<Integer> memory = new ArrayList<Integer>();
        List<List<Integer>> domain = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < xos.size() ; i++) {
            List<Integer> xs = Utils.generaCongruenteMoltiplicativo(this.getA(), xos.get(i), this.getB());
            if (!xs.equals(memory)) {
                domain.add(xs);
                memory = xs;
            }
        }
        return domain;
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

}