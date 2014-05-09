package it.unimarconi.pratica4;

import it.unimarconi.Classificazione;
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

        Classificazione c = new Classificazione(64.0);

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
            System.out.println(min + " < " + v + " < " + max + "?\t\t" + c.classifica(v));
            if (v > min && v < max) {
                out[k] = true;
            } else {
                out[k] = false;
            }
        }

        int count = 0;
        for (int i = 0 ; i < out.length ; i++)
            if (out[i])
                count++;

        System.out.print("Test di Uniformita: [a: " + this.getA() + "]");
        System.out.print("[seed: " + this.getSeed() + "]");
        System.out.print("[b: " + this.getB() + "]");
        System.out.print("[d: " + this.getD() + "]\t\t");
        System.out.println(count + " successi su " + this.getProve() + " prove.\n");

        return out;

    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0)
                    System.out.print("| X ");
                else
                    System.out.print("|   ");
            }
            System.out.println("| ");
        }
    }


    public boolean[] seriale() {

        Classificazione c = new Classificazione(4095.0);

        boolean[] out = new boolean[this.getProve()];
        int[][] matrix = new int[this.getD()][this.getD()];
        for (int i = 0 ; i < matrix.length ; i++)
            for (int j = 0 ; j < matrix[i].length ; j++)
                matrix[i][j] = 0;

        List<Double> rns = Utils.generaRn(this.getA(), this.getSeed(), this.getB());

        List<Integer> zs = new ArrayList<Integer>();
        for (Double rn : rns)
            zs.add((int)Math.floor(this.getD() * rn));

        for (int k = 0 ; k < 2 ; k++) {
            for (int i = 0; i < this.getProve(); i++) {
                List<Integer> tmp = zs.subList((i) * zs.size() / this.getProve(), (1 + i) * zs.size() / this.getProve());
                out[i] = subSeriale(tmp, k);
            }
            System.out.println();
            int count = 0;
            for (int i = 0 ; i < out.length ; i++)
                if (out[i])
                    count++;

            System.out.print("Test Seriale: [a: " + this.getA() + "]");
            System.out.print("[seed: " + this.getSeed() + "]");
            System.out.print("[b: " + this.getB() + "]");
            System.out.print("[d: " + this.getD() + "]\t\t");
            System.out.println(count + " successi su " + this.getProve() + " prove.\n");
        }

        return out;

    }

    public boolean subSeriale(List<Integer> zs, int startIdx) {

        Classificazione c = new Classificazione(4095.0);

        int[][] matrix = new int[this.getD()][this.getD()];
        for (int i = 0 ; i < matrix.length ; i++)
            for (int j = 0 ; j < matrix[i].length ; j++)
                matrix[i][j] = 0;

        for (int i = startIdx ; i < zs.size() - 1; i += 2) {
            int old = matrix[zs.get(i)][zs.get(1 + i)];
            matrix[zs.get(i)][zs.get(1 + i)] = 1 + old;
        }

//        printMatrix(matrix);

        List<Double> freqs = new ArrayList<Double>();
        for (int i = 0 ; i < matrix.length ; i++)
            for (int j = 0; j < matrix[i].length; j++)
                freqs.add(new Double(matrix[i][j]));

        double v = Utils.calcolaV(freqs, (zs.size() / 2), (1.0 / (this.getD() * this.getD())));
        if (startIdx == 0)
            System.out.print("[Serie (Z0, Z1)]\t");
        else
            System.out.print("[Serie (Z1, Z2)]\t");
//        System.out.print("[a: " + this.getA() + "]");
//        System.out.print("[seed: " + this.getSeed() + "]");
//        System.out.print("[b: " + this.getB() + "]");
//        System.out.print("[d: " + this.getD() + "] ");
        System.out.println(c.CHI_25 + " < " + v + " < " + c.CHI_75 + "? " + c.classifica(v));
        return !c.classifica(v).equals("Rigetto");
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