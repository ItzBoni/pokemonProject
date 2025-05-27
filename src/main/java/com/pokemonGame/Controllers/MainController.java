package com.pokemonGame.Controllers;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


import java.util.HashMap;

import com.pokemonGame.player.Player;
import com.pokemonGame.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;

public class MainController{
    
    HashMap <Integer, Node> views = new HashMap<>();
    ObservableList<Player> players = FXCollections.observableArrayList();
    ObservableList<Player> playersForCombat = FXCollections.observableArrayList();
    ArrayList<Button> buttonNeedPlayers = new ArrayList<>();

    IntegerProperty numberOfPlayers = new SimpleIntegerProperty(0);
    ArrayList<ComboBox<Player>> comboBoxesFromSelct =  new ArrayList<>();
    ArrayList<Label> labelFromSelect =  new ArrayList<>();
    ArrayList<ComboBox<Pokemon>> comboBoxesFromCombat = new ArrayList<>();
    ArrayList<Label> labelFromCombat = new ArrayList<>();

    @FXML
    private StackPane contentArea;

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

        loader = new FXMLLoader(getClass().getResource("/GUI/Views/combatView.fxml"));
        views.put(3, loader.load());

        CombatController combat = loader.getController();
        combat.setPlayersLists(players);
        combat.setMainController(this);

        loader = new FXMLLoader(getClass().getResource("/GUI/Views/SelectPlayers.fxml"));
        views.put(4, loader.load());

        SelectPlayersController selectPlayersController = loader.getController();
        selectPlayersController.setPlayersList(players);
        selectPlayersController.setPlayersForCombat(playersForCombat);
        selectPlayersController.setMainController(this);
        selectPlayersController.updateComboBoxesSelect(comboBoxesFromSelct);
        selectPlayersController.updateLabelSelect(labelFromSelect);
        selectPlayersController.setNumPlayers(numberOfPlayers);
        

        loader = new FXMLLoader(getClass().getResource("/GUI/Views/CombatFour.fxml"));
        views.put(5, loader.load());

        CombatAllController combatAllController = loader.getController();
        combatAllController.setPlayersForCombat(playersForCombat);
        combatAllController.setMainController(this);
        combatAllController.setPokemonsForCombat(comboBoxesFromCombat);
        combatAllController.setLabelsForCombat(labelFromCombat);

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

    public void updateComboBoxesCombat(){
        this.comboBoxesFromCombat.get(0).setItems(playersForCombat.get(0).getPokemonList());
        this.comboBoxesFromCombat.get(1).setItems(playersForCombat.get(1).getPokemonList());
        this.comboBoxesFromCombat.get(2).setItems(playersForCombat.get(2).getPokemonList());
        this.comboBoxesFromCombat.get(3).setItems(playersForCombat.get(3).getPokemonList());

        this.labelFromCombat.get(0).setText("Player: "+playersForCombat.get(0).getName());
        this.labelFromCombat.get(1).setText("Player: "+playersForCombat.get(1).getName());
        this.labelFromCombat.get(2).setText("Player: "+playersForCombat.get(2).getName());
        this.labelFromCombat.get(3).setText("Player: "+playersForCombat.get(3).getName());
    }

    public void recoverPlayers(){
        for(Player p : playersForCombat){
            p.recoverBeforeBattle();
        }
    }

    public void setNumPlayers(int n){
        numberOfPlayers.set(n);

        for(int i = 0; i < comboBoxesFromSelct.size(); i++){
            if(numberOfPlayers.intValue()>i){
                comboBoxesFromSelct.get(i).setVisible(true);
                comboBoxesFromSelct.get(i).setManaged(true);
                labelFromSelect.get(i).setVisible(true);
                labelFromSelect.get(i).setManaged(true);
            } else{
                comboBoxesFromSelct.get(i).setVisible(false);
                comboBoxesFromSelct.get(i).setManaged(false);
                labelFromSelect.get(i).setVisible(false);
                labelFromSelect.get(i).setManaged(false);
            }
        }
    }
}
