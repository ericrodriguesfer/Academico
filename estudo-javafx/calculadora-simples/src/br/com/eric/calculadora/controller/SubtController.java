package br.com.eric.calculadora.controller;

import br.com.eric.calculadora.model.Subt;

public class SubtController {

    private Subt subt;

    public SubtController(double num01, double num02) {
        this.subt = new Subt(num01, num02);
    }

    public Subt getSubt() {
        return subt;
    }

    public void setSubt(Subt subt) {
        this.subt = subt;
    }

    public double result() {
        return this.subt.subt();
    }

}
