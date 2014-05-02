package it.unimarconi.pratica4;

import it.unimarconi.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Pratica4 {

    private int a;

    private int seed;

    private int b;

    private int d;

    private int prove;

    public Pratica4(int a, int seed, int b, int d, int prove) {
        this.setA(a);
        this.setSeed(seed);
        this.setB(b);
        this.setD(d);
        this.setProve(prove);
    }

    public boolean[] uniformita() {

        boolean[] out = new boolean[this.getProve()];

        List<Double> rns = Utils.generaRn(this.getA(), this.getSeed(), this.getB());

        double min = Utils.calcolaChiQuadro(64.0, Utils.Z25);
        double max = Utils.calcolaChiQuadro(64.0, Utils.Z75);

        List<Double> ds = new ArrayList<Double>();
        for (Double rn : rns)
            ds.add(Math.floor(this.getD() * rn));

        int chunks = this.getProve();
        List<List<Double>> testSet = new ArrayList<List<Double>>();
        double size = ds.size() / this.getProve();
        for (int i = 0 ; i < chunks ; i++) {
            List<Double> chunk = new ArrayList<Double>();
            for (int j = i * (int)size ; j < (i + 1) * (int)size ; j++) {
                chunk.add(ds.get(j));
            }
            testSet.add(chunk);
        }

        for (int k = 0 ; k < chunks ; k++) {
            Collections.sort(testSet.get(k));
            LinkedHashMap<Double, Double> freqs = new LinkedHashMap<Double, Double>();
            for (Double tmp : testSet.get(k)) {
                try {
                    freqs.put(tmp, 1.0 + freqs.get(tmp));
                } catch (Exception e) {
                    if (tmp <= this.getD())
                        freqs.put(tmp, 1.0);
                }
            }
            List<Double> yss = new ArrayList<Double>();
            for (Double pippo : freqs.values())
                yss.add(pippo);
            double v = Utils.calcolaV(yss, size, 0.015625);
            if (v > min && v < max) {
                out[k] = true;
//                System.out.println("TEST SUCCEED | " + min + " < " + v + " < " + max + " [a = " + this.getA() + "][seed = " + this.getSeed() + "]");
            } else {
                out[k] = false;
//                System.out.println("TEST FAILED | " + min + " < " + v + " < " + max + " [a = " + this.getA() + "][seed = " + this.getSeed() + "]");
            }
        }

        return out;

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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getProve() {
        return prove;
    }

    public void setProve(int prove) {
        this.prove = prove;
    }

}