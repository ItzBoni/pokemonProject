package com.pokemonGame.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

import java.util.ArrayList;

import com.pokemonGame.player.Player;

public class CombatAllController {
    
    ObservableList<Player> playersForCombat;
    MainController father;

    public void setPlayersForCombat(ObservableList<Player> list){
        this.playersForCombat = list;
    }

    public void setMainController(MainController father){
        this.father = father;
    }


     
}


