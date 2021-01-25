package br.com.eric.calculadora.utils;

public class ReturnPathView {

    private String nameView;

    public ReturnPathView(String nameView) {
        this.nameView = nameView;
    }

    public void setNameView(String nameView) {
        this.nameView = nameView;
    }

    public String getNameView() {
        return this.nameView;
    }

    public String returnPath() {
        return "/br/com/eric/calculadora/view/" + this.getNameView();
    }

}
