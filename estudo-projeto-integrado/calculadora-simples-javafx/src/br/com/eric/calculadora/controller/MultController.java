package br.com.eric.calculadora.controller;

import br.com.eric.calculadora.model.Mult;

public class MultController {

    private Mult mult;

    public MultController(double num01, double num02) {
        this.mult = new Mult(num01, num02);
    }

    public Mult getMult() {
        return mult;
    }

    public void setMult(Mult mult) {
        this.mult = mult;
    }

    public double result() {
        return this.mult.mult();
    }

}
