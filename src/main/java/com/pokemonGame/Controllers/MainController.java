package com.pokemonGame.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.HashMap;

import com.pokemonGame.player.Player;

import java.io.IOException;
import java.util.ArrayList;

public class MainController{
    
    HashMap <Integer, Node> views = new HashMap<>();
    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Button> buttonNeedPlayers = new ArrayList<>();

    @FXML
    private StackPane contentArea;

    // @FXML private Node view2;

    @FXML public void initialize() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Views/InitView.fxml"));
        views.put(0, loader.load());
        
        InitController startPageController = loader.getController();
        startPageController.setPlayersLists(players);
        startPageController.setMainController(this);

        loader = new FXMLLoader(getClass().getResource("/GUI/Views/PlayersRegister.fxml"));
        views.put(1, loader.load());
        
        PlayersRegController playerPageController = loader.getController();
        playerPageController.setPlayersLists(players);
        playerPageController.setMainController(this);

        loader = new FXMLLoader(getClass().getResource("/GUI/Views/MainMenu.fxml"));
        views.put(2, loader.load());
        
        MainMenuController mainMenuController = loader.getController();
        mainMenuController.setMainController(this);

        addAllNodesToRoot();
        navigateToView(0);
    }
    
    @FXML void addAllNodesToRoot(){
        for(Node n: views.values()){
            contentArea.getChildren().add(n);
        }
    }

    @FXML public void navigateToView(Integer view){
        for(Integer i : this.views.keySet()){
            if (i != view){
                this.views.get(i).setVisible(false);
                this.views.get(i).setManaged(false);
                continue;
            }

            
            this.views.get(i).setVisible(true);
            this.views.get(i).setManaged(true);
        }
    }

    public void addButtonToObserve(Button b){
        buttonNeedPlayers.add(b);
        b.setDisable(true);
    }

    public void enableButtonsOfPlayers(){
        for (Button b: buttonNeedPlayers){
            b.setDisable(false);
        }
    }
}
