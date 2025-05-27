package com.pokemonGame.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

import com.pokemonGame.player.Player;

public class InitController {
    ObservableList<Player> players = FXCollections.observableArrayList();
    MainController father;

    @FXML private Button StartGameButton;
    @FXML private Button CombatGameButton;

    @FXML public void initialize(){
        if(players.size()<=1){
            StartGameButton.setDisable(true);
        }
    }

    public void setPlayersLists(ObservableList<Player> list){
        this.players = list;
    }

    public void setMainController(MainController father){
        this.father = father;
        
        father.addButtonToObserve(StartGameButton);
    }

    @FXML public void goToPlayerRegister(){
        father.navigateToView(1);
    }
    @FXML public void goToGame(){
        father.navigateToView(2);
    }
}
