package it.unimarconi.due;

public class Prodotto {

    private int a;

    private int b;

    public Prodotto(int a, int b) {
        this.setA(a);
        this.setB(b);
    }

    public int prodotto() {
        return this.getA() * this.getB();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}