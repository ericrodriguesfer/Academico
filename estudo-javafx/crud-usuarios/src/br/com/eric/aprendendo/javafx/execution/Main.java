package br.com.eric.aprendendo.javafx.execution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.net.URL;
import javafx.scene.Scene;

public class Main extends Application{
    
    private final URL path = getClass().getResource("/br/com/eric/aprendendo/javafx/view/RegisterUser.fxml");

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(path);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Register User");
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
