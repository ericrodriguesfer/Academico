package br.com.eric.calculadora.model;

public class Mult {

    private double num01;
    private double num02;

    public Mult(double num01, double num02) {
        this.num01 = num01;
        this.num02 = num02;
    }

    public double getNum01() {
        return num01;
    }

    public void setNum01(double num01) {
        this.num01 = num01;
    }

    public double getNum02() {
        return num02;
    }

    public void setNum02(double num02) {
        this.num02 = num02;
    }

    public double mult() {
        return (this.getNum01() * this.getNum02());
    }
    
}
