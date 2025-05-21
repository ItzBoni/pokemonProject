package com.pokemonGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("@GUI/MainView.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400); // Tamaño de la ventana
        primaryStage.setTitle("App con Vistas Discretas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}