package br.com.eric.calculadora.controller;

import br.com.eric.calculadora.model.Div;

public class DivController {

    private Div div;

    public DivController(double num01, double num02) {
        this.div = new Div(num01, num02);
    }

    public Div getDiv() {
        return div;
    }

    public void setDiv(Div div) {
        this.div = div;
    }

    public double result() {
        return this.div.div();
    }

}
