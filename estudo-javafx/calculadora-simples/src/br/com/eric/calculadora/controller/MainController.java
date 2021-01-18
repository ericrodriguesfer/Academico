package br.com.eric.calculadora.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.JOptionPane;

import br.com.eric.calculadora.model.Category;

public class MainController implements Initializable {

    private final List<Category> operations = new ArrayList<>();
    private ObservableList<Category> finalOperations;
    private boolean num01Valid;
    private boolean num02Valid;
    private String num01;
    private String num02;
    private double num01Calc;
    private double num02Calc;
    private double result;
    private SumController sum;
    private MultController mult;
    private DivController div;
    private SubtController subt;

    @FXML
    private TextField txtNum01;
    @FXML
    private TextField txtNum02;
    @FXML
    private Button btnCalc;
    @FXML
    private TextField txtResult;
    @FXML
    private ComboBox<Category> txtOperaion;
    @FXML
    private Button btnReset;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.populateCategorys();
    }

    @FXML
    private void calculator(ActionEvent event) {
        if (this.txtNum01.getText().isEmpty() || this.txtNum02.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preenchar corretamente os campos!", "ERRO: campos vázios", 0);
        } else {
            this.setNum01Valid(true);
            this.setNum02Valid(true);
            this.setNum01(this.txtNum01.getText());
            this.setNum02(this.txtNum02.getText());

            for (int i = 0; i < this.getNum01().length(); i++) {
                if (Character.isLetter(this.getNum01().charAt(0))) {
                    this.setNum01Valid(false);
                }
            }

            for (int i = 0; i < this.getNum02().length(); i++) {
                if (Character.isLetter(this.getNum02().charAt(0))) {
                    this.setNum02Valid(false);
                }
            }

            if (this.isNum01Valid() == false || this.isNum02Valid() == false) {
                JOptionPane.showMessageDialog(null, "Por favor, digite somente números para os cálculos!", "ERRO: somente números", 0);
            } else {
                this.setNum01Calc(Double.parseDouble(this.num01));
                this.setNum02Calc(Double.parseDouble(this.num02));
                this.setResult(0);

                if (this.txtOperaion.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione a operação que deseja realizar!", "ERRO: escolha a operação", 0);
                } else {
                    switch (this.txtOperaion.getValue().getName()) {
                        case "Somar":
                            this.sum = new SumController(this.getNum01Calc(), this.getNum02Calc());
                            this.setResult(this.sum.result());

                            break;

                        case "Subtrair":
                            this.subt = new SubtController(this.getNum01Calc(), this.getNum02Calc());
                            this.setResult(this.subt.result());

                            break;

                        case "Multiplicar":
                            this.mult = new MultController(this.getNum01Calc(), this.getNum02Calc());
                            this.setResult(this.mult.result());

                            break;

                        case "Dividir":
                            this.div = new DivController(this.getNum01Calc(), this.getNum02Calc());
                            this.setResult(this.div.result());

                            break;

                        default:
                            this.setResult(0);
                            break;
                    }

                    this.txtResult.setText(String.valueOf(this.getResult()));
                }
            }
        }
    }

    @FXML
    private void reset(ActionEvent event) {
        this.txtNum01.setText("");
        this.txtNum02.setText("");
        this.txtResult.setText("");
        this.txtOperaion.setValue(null);

        this.num01Valid = false;
        this.num02Valid = false;
        this.num01 = null;
        this.num02 = null;
        this.num01Calc = 0.0;
        this.num02Calc = 0.0;
        this.result = 0.0;
    }

    private void populateCategorys() {
        Category category1 = new Category(1, "Somar");
        Category category2 = new Category(2, "Subtrair");
        Category category3 = new Category(3, "Multiplicar");
        Category category4 = new Category(4, "Dividir");

        this.operations.add(category1);
        this.operations.add(category2);
        this.operations.add(category3);
        this.operations.add(category4);

        this.finalOperations = FXCollections.observableArrayList(this.operations);

        this.txtOperaion.setItems(this.finalOperations);
    }

    public boolean isNum01Valid() {
        return num01Valid;
    }

    public void setNum01Valid(boolean num01Valid) {
        this.num01Valid = num01Valid;
    }

    public boolean isNum02Valid() {
        return num02Valid;
    }

    public void setNum02Valid(boolean num02Valid) {
        this.num02Valid = num02Valid;
    }

    public String getNum01() {
        return num01;
    }

    public void setNum01(String num01) {
        this.num01 = num01;
    }

    public String getNum02() {
        return num02;
    }

    public void setNum02(String num02) {
        this.num02 = num02;
    }

    public double getNum01Calc() {
        return num01Calc;
    }

    public void setNum01Calc(double num01Calc) {
        this.num01Calc = num01Calc;
    }

    public double getNum02Calc() {
        return num02Calc;
    }

    public void setNum02Calc(double num02Calc) {
        this.num02Calc = num02Calc;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public SumController getSum() {
        return sum;
    }

    public void setSum(SumController sum) {
        this.sum = sum;
    }

    public MultController getMult() {
        return mult;
    }

    public void setMult(MultController mult) {
        this.mult = mult;
    }

    public DivController getDiv() {
        return div;
    }

    public void setDiv(DivController div) {
        this.div = div;
    }

    public SubtController getSubt() {
        return subt;
    }

    public void setSubt(SubtController subt) {
        this.subt = subt;
    }

}
