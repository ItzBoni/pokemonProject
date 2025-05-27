package com.pokemonGame.Controllers;

import java.util.ArrayList;

import com.pokemonGame.player.Player;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SelectPlayersController {
    ObservableList<Player> playersForCombat;
    ObservableList<Player> players;
    
    private IntegerProperty numPlayers;

    MainController father;

    @FXML private ComboBox<Player> comboBoxSelectPlayer_1;
    @FXML private ComboBox<Player> comboBoxSelectPlayer_2;
    @FXML private ComboBox<Player> comboBoxSelectPlayer_3;
    @FXML private ComboBox<Player> comboBoxSelectPlayer_4;

    @FXML private Label labelSelectPlayer_1;
    @FXML private Label labelSelectPlayer_2;
    @FXML private Label labelSelectPlayer_3;
    @FXML private Label labelSelectPlayer_4;

    public void setPlayersForCombat(ObservableList<Player> list){
        this.playersForCombat = list;
    }

    public void setPlayersList(ObservableList<Player> list){
        this.players = list;
        fillComboBoxes();
    }

    public void updateComboBoxesSelect(ArrayList<ComboBox<Player>> list){
        list.add(comboBoxSelectPlayer_1);
        list.add(comboBoxSelectPlayer_2);
        list.add(comboBoxSelectPlayer_3);
        list.add(comboBoxSelectPlayer_4);
    }

    public void updateLabelSelect(ArrayList<Label> list){
        list.add(labelSelectPlayer_1);
        list.add(labelSelectPlayer_2);
        list.add(labelSelectPlayer_3);
        list.add(labelSelectPlayer_4);
    }

    public void setMainController(MainController father){
        this.father = father;
    }

    public void setNumPlayers (IntegerProperty n){
        this.numPlayers = n;
    } 

    public void fillComboBoxes(){
        comboBoxSelectPlayer_1.setItems(players);
        comboBoxSelectPlayer_2.setItems(players);
        comboBoxSelectPlayer_3.setItems(players);
        comboBoxSelectPlayer_4.setItems(players);
    }

    @FXML private void showWarningAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Seleccion invalidad");
        alert.setHeaderText("No se puede continuar al combate.");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public Player getPfromB(ComboBox<Player> combo){
        return combo.getSelectionModel().getSelectedItem();
    }

    @FXML public void goToBattle(){
        if(numPlayers.intValue() == 2){
            if(comboBoxSelectPlayer_1.getSelectionModel().isEmpty() || comboBoxSelectPlayer_2.getSelectionModel().isEmpty() ){
                showWarningAlert("No se permiten espacios vacios");
                return;
            }

            if(getPfromB(comboBoxSelectPlayer_1) == getPfromB(comboBoxSelectPlayer_2)){
                showWarningAlert("No se permite repetir jugador. Favor de seleccionar otro.");
                return;
            } else{
                playersForCombat.clear();
                playersForCombat.add(getPfromB(comboBoxSelectPlayer_1));
                playersForCombat.add(getPfromB(comboBoxSelectPlayer_2));
            }
        } else {
            
            if(comboBoxSelectPlayer_1.getSelectionModel().isEmpty() || comboBoxSelectPlayer_2.getSelectionModel().isEmpty() || comboBoxSelectPlayer_3.getSelectionModel().isEmpty() || comboBoxSelectPlayer_4.getSelectionModel().isEmpty()){
                showWarningAlert("No se permiten espacios vacios");
                return;
            }

            if(getPfromB(comboBoxSelectPlayer_1) != getPfromB(comboBoxSelectPlayer_2) && getPfromB(comboBoxSelectPlayer_1) != getPfromB(comboBoxSelectPlayer_3) && getPfromB(comboBoxSelectPlayer_1) != getPfromB(comboBoxSelectPlayer_4)
            && getPfromB(comboBoxSelectPlayer_2) != getPfromB(comboBoxSelectPlayer_3) && getPfromB(comboBoxSelectPlayer_2) != getPfromB(comboBoxSelectPlayer_4) && getPfromB(comboBoxSelectPlayer_3) != getPfromB(comboBoxSelectPlayer_4)){

                playersForCombat.clear();
                playersForCombat.add(getPfromB(comboBoxSelectPlayer_1));
                playersForCombat.add(getPfromB(comboBoxSelectPlayer_2));
                playersForCombat.add(getPfromB(comboBoxSelectPlayer_3));
                playersForCombat.add(getPfromB(comboBoxSelectPlayer_4));
        
            } else {
                showWarningAlert("No se permite repetir jugador. Favor de seleccionar otro.");
                return;
            }
        }
        
        showWarningAlert("Redireccionando al combate.");
        if(numPlayers.intValue()==2){
            father.navigateToView(3);

        }else{
            father.navigateToView(5);
        }
    }

    @FXML public void goToStart(){
        father.navigateToView(2);
    }
}
