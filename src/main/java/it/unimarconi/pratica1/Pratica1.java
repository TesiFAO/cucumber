package it.unimarconi.pratica1;

import it.unimarconi.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
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

    public int generaInsiemeInteri() {
        List<Integer> a1 = Utils.corollarioA1(this.getB());
        List<Integer> a2 = Utils.corollarioA2(this.getB());
        List<Integer> l1 = Utils.generaCongruenteMoltiplicativo(this.getA(), this.getSeed(), this.getB());
        Collections.sort(a1);
        Collections.sort(a2);
        Collections.sort(l1);
        int count = 0;
        if (a1.equals(l1))
            count++;
        if (a2.equals(l1))
            count++;
        return count;
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