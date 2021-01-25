package br.com.eric.calculadora.controller;

import br.com.eric.calculadora.model.Sum;

public class SumController {

    private Sum sum;

    public SumController(double num01, double num02) {
        this.sum = new Sum(num01, num02);
    }

    public Sum getSum() {
        return sum;
    }

    public void setSum(Sum sum) {
        this.sum = sum;
    }

    public double result() {
        return this.sum.sum();
    }

}
