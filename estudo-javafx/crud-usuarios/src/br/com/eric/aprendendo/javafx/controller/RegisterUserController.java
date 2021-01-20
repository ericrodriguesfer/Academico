package br.com.eric.aprendendo.javafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.eric.aprendendo.javafx.model.User;

public class RegisterUserController implements Initializable {

    private final List<User> users = new ArrayList<>();
    private ObservableList<User> usersTable;
    private boolean edit = false;
    private int id = 0;

    @FXML
    private TextField email;
    @FXML
    private TextField name;
    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User, Integer> idColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, String> emailColumn;
    @FXML
    private TextField idDelete;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    private void registerUser(ActionEvent event) {
        if (this.edit) {
            if (this.id != 0 && this.userEditConfirm(id)) {
                if (this.name.getText().isEmpty() || this.email.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha os campos para atualizar!", "ERRO: Preencha os campos", 0);
                } else {
                    int indexDelete = this.indexUser(id);
                    this.users.remove(indexDelete);
                    this.users.add(indexDelete, new User(id, this.name.getText(), this.email.getText()));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Este usuário não existe para edição!", "ERRO: Usuário inexistente", 0);
            }

            this.edit = false;
            this.id = 0;
        } else {
            if (this.name.getText().isEmpty() || this.email.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha os dados do usuário!", "ERRO: Campos vázios", 0);
            } else {
                if (!this.userNoInsert(this.email.getText())) {
                    JOptionPane.showMessageDialog(null, "Este email de usuário já foi cadastrado!", "ERRO: Usuário existente", 0);
                } else {
                    if (this.users.size() == 0) {
                        this.users.add(new User((this.users.size() + 1), this.name.getText(), this.email.getText()));
                    } else {
                        this.users.add(new User((this.users.get(this.users.size() - 1).getId() + 1), this.name.getText(), this.email.getText()));
                    }
                }
            }
        }
        
        this.clearForm(event);
        this.updateTable();
    }

    @FXML
    private void clearForm(ActionEvent event) {
        if (this.name.getText().isEmpty() && this.email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos já estáo vázios!", "ERRO: Campos vázios", 0);
        } else {
            this.name.setText("");
            this.email.setText("");
            this.idDelete.setText("");
            this.id = 0;
            this.edit = false;
        }
    }

    @FXML
    private void userEdit(MouseEvent event) {
        this.name.setText(this.tableUsers.getSelectionModel().getSelectedItem().getName());
        this.email.setText(this.tableUsers.getSelectionModel().getSelectedItem().getEmail());
        this.idDelete.setText(String.valueOf(this.tableUsers.getSelectionModel().getSelectedItem().getId()));

        this.edit = true;
        this.id = this.tableUsers.getSelectionModel().getSelectedItem().getId();
    }

    @FXML
    private void deleteUser(ActionEvent event) {
        if (this.idDelete.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para remover!", "ERRO: Usuário não existe", 0);
        } else {
            this.users.remove(this.indexUser(Integer.parseInt(this.idDelete.getText())));

            this.clearForm(event);
        }

        this.updateTable();
    }

    private boolean userNoInsert(String email) {
        for (User u : this.users) {
            if (u.getEmail().equals(email)) {
                return false;
            }
        }

        return true;
    }

    private boolean userEditConfirm(int id) {
        for (User u : this.users) {
            if (u.getId() == id) {
                return true;
            }
        }

        return false;
    }
    
    private int indexUser (int id) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getId() == id) {
                return i;
            }
        }
        
        return -1;
    }

    private void updateTable() {
        this.usersTable = FXCollections.observableArrayList(this.users);
        this.tableUsers.setItems(this.usersTable);
    }

}
