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
            this.num01Valid = true;
            this.num02Valid = true;
            this.num01 = this.txtNum01.getText();
            this.num02 = this.txtNum02.getText();

            for (int i = 0; i < this.num01.length(); i++) {
                if (Character.isLetter(this.num01.charAt(0))) {
                    this.num01Valid = false;
                }
            }

            for (int i = 0; i < this.num02.length(); i++) {
                if (Character.isLetter(this.num02.charAt(0))) {
                    this.num02Valid = false;
                }
            }

            if (this.num01Valid == false || this.num02Valid == false) {
                JOptionPane.showMessageDialog(null, "Por favor, digite somente números para os cálculos!", "ERRO: somente números", 0);
            } else {
                this.num01Calc = Double.parseDouble(this.num01);
                this.num02Calc = Double.parseDouble(this.num02);
                this.result = 0;

                if (this.txtOperaion.getValue() == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione a operação que deseja realizar!", "ERRO: escolha a operação", 0);
                } else {
                    if (this.txtOperaion.getValue().getName().equals("Somar")) {
                        this.result = (this.num01Calc + this.num02Calc);
                    } else if (this.txtOperaion.getValue().getName().equals("Subtrair")) {
                        this.result = (this.num01Calc - this.num02Calc);
                    } else if (this.txtOperaion.getValue().getName().equals("Multiplicar")) {
                        this.result = (this.num01Calc * this.num02Calc);
                    } else if (this.txtOperaion.getValue().getName().equals("Dividir")) {
                        this.result = (this.num01Calc / this.num02Calc);
                    }

                    this.txtResult.setText(String.valueOf(this.result));
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

}
