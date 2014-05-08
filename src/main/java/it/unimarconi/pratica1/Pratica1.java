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
        String sa1 = "Corollario A.1 = [";
        String sa2 = "Corollario A.2 = [";
        String sl1 = "Sequenza = [";
        for (int i = 0 ; i < 50 ; i++) {
            sa1 += a1.get(i);
            sa2 += a2.get(i);
            sl1 += l1.get(i);
            if (i < l1.size() - 1) {
                sa1 += ", ";
                sa2 += ", ";
                sl1 += ", ";
            }
        }
        sa1 += " ...]";
        sa2 += " ...]";
        sl1 += " ...]";
        System.out.println("a: " + this.getA());
        System.out.println("seed: " + this.getSeed());
        System.out.println("b: " + this.getB());
        System.out.println();
        System.out.println(sa1 + "\n");
        System.out.println(sa2 + "\n");
        System.out.println(sl1 + "\n");
        System.out.println("La sequenza generata e' identica a quella prevista dal Corollario A.1? " + a1.equals(l1));
        System.out.println("La sequenza generata e' identica a quella prevista dal Corollario A.2? " + a2.equals(l1));
        System.out.println();
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