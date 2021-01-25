package br.com.eric.calculadora.execution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

import br.com.eric.calculadora.utils.ReturnPathView;

public class Main extends Application {

    private final ReturnPathView pathView = new ReturnPathView("Main.fxml");
    private final URL arquivoFXML = getClass().getResource(pathView.returnPath());

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(arquivoFXML);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
