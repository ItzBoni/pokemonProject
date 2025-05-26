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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/MainView.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 1200, 800); // Tamaño de la ventana
        scene.getStylesheets().add(getClass().getResource("/Stylesheets/InitialView.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/Stylesheets/PlayerRegister.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/Stylesheets/CombatView.css").toExternalForm());        
        scene.getStylesheets().add(getClass().getResource("/Stylesheets/MainMenu.css").toExternalForm());      
        scene.getStylesheets().add(getClass().getResource("/Stylesheets/SelectPlayers.css").toExternalForm());
        scene.getStylesheets().add(getClass().getResource("/Stylesheets/CombatFour.css").toExternalForm());
        primaryStage.setTitle("Pokemon Game by ADS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}