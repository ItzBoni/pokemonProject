package com.pokemonGame.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.ArrayList;

import com.pokemonGame.player.Player;

public class MainMenuController {
    MainController father;
    CombatController combat;
    
    @FXML public void initialize(){
        
    }

    public void setCombat(CombatController x){
        this.combat = x;
    }

    public void setMainController(MainController father){
        this.father = father;
    }

    @FXML public void goToPlayerRegister(){
        father.navigateToView(1);
    }
    @FXML public void goToStart(){
        father.navigateToView(0);
    }
    @FXML public void goToBattle(){

        father.navigateToView(3);
        combat.initCombat();
    }
}
