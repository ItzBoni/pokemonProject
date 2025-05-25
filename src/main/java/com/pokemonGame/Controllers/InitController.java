package com.pokemonGame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

import com.pokemonGame.player.Player;

public class InitController {
    ArrayList<Player> players = new ArrayList<>();
    MainController father;

    @FXML private Button StartGameButton;

    @FXML public void initialize(){
        if(players.size()<=1){
            StartGameButton.setDisable(true);
        }
    }

    public void setPlayersLists(ArrayList<Player> list){
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
