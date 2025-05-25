package com.pokemonGame.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Objects;

import com.pokemonGame.player.Player;
import com.pokemonGame.pokemon.Pokemon;
import com.pokemonGame.pokemon.pokedex.Bulbasaur;
import com.pokemonGame.pokemon.pokedex.Charmander;
import com.pokemonGame.pokemon.pokedex.Digglet;
import com.pokemonGame.pokemon.pokedex.Pikachu;
import com.pokemonGame.pokemon.pokedex.Squirtle;

public class PlayersRegController {
    ArrayList<Player> players = new ArrayList<>();
    MainController father;

    @FXML private ComboBox<String> selectPokemon_1;
    @FXML private ComboBox<String> selectPokemon_2;
    @FXML private ComboBox<String> selectPokemon_3;
    @FXML private ComboBox<String> selectPokemon_4;
    @FXML private ComboBox<String> selectPokemon_5;
    @FXML private ComboBox<String> selectPokemon_6;

    @FXML private TextArea Register__Player__Field;
    
    @FXML private Button registerPlayerButton;
    @FXML private Button returnButton;

    @FXML public void initialize(){
        ArrayList<String> pokemonsNames = new ArrayList<>();
        pokemonsNames.add("Bulbasaur");
        pokemonsNames.add("Pikachu");
        pokemonsNames.add("Digglet");
        pokemonsNames.add("Squirtle");
        pokemonsNames.add("Charmander");

        fillComboBox(pokemonsNames, selectPokemon_1);
        fillComboBox(pokemonsNames, selectPokemon_2);
        fillComboBox(pokemonsNames, selectPokemon_3);
        fillComboBox(pokemonsNames, selectPokemon_4);
        fillComboBox(pokemonsNames, selectPokemon_5);
        fillComboBox(pokemonsNames, selectPokemon_6);

        if(players.size()<=1){
            returnButton.setDisable(true);
        }
    }

    public void setPlayersLists(ArrayList<Player> list){
        this.players = list;
    }

    public void setMainController(MainController father){
        this.father = father;
        
        father.addButtonToObserve(returnButton);
    }

    public void fillComboBox(ArrayList<String> dataList, ComboBox<String> combo) {
        ObservableList<String> observableList = FXCollections.observableArrayList(dataList);
        combo.setItems(observableList); // .getSelectionModel().isEmpty() // .getText()
    }

    public String getSelectedItem(ComboBox<String> combo) {
        return combo.getSelectionModel().getSelectedItem();
    }

    @FXML private void showWarningAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Registro invalido");
        alert.setHeaderText("No se puede continuar con el registro.");
        alert.setContentText(message);

        alert.showAndWait();
    }

    private boolean verifyIfNameExists(String n){
        for(Player p: players){
            if (p.getName().equals(n)){
                return true;
            }
        }

        return false;
    }

    private Pokemon returnPokemon(String p){
        Pokemon poke;
        switch (p) {
            case "Pikachu":
                poke = new Pikachu();
                break;
        
            case "Bulbasaur":
                poke = new Bulbasaur();
                break;
        
            case "Digglet":
                poke = new Digglet();
                break;
        
            case "Squirtle":
                poke = new Squirtle();
                break;
        
            case "Charmander":
                poke = new Charmander();
                break;
        
            default:
                poke = new Charmander();
                break;
        }

        return poke;
    }

    @FXML public void goToMainMenu(){
        father.navigateToView(0);
    }

    @FXML public void registerPlayer(){
        if(selectPokemon_1.getSelectionModel().isEmpty() ||selectPokemon_2.getSelectionModel().isEmpty() ||selectPokemon_3.getSelectionModel().isEmpty() ||selectPokemon_4.getSelectionModel().isEmpty() ||selectPokemon_5.getSelectionModel().isEmpty() || selectPokemon_6.getSelectionModel().isEmpty()){
            
            showWarningAlert("Alguno de los campos de pokemon esta vacio.");
            
        }else{
            if( Register__Player__Field.getText().trim().isEmpty()){
                showWarningAlert("No se aceptan espacios en blanco.");
            }else if (verifyIfNameExists(Register__Player__Field.getText().trim())){
                showWarningAlert("El nombre ya existe.");
            }else{
                Player p =  new Player(Register__Player__Field.getText().trim());
                p.addPokemon(returnPokemon(selectPokemon_1.getSelectionModel().getSelectedItem()));
                p.addPokemon(returnPokemon(selectPokemon_2.getSelectionModel().getSelectedItem()));
                p.addPokemon(returnPokemon(selectPokemon_3.getSelectionModel().getSelectedItem()));
                p.addPokemon(returnPokemon(selectPokemon_4.getSelectionModel().getSelectedItem()));
                p.addPokemon(returnPokemon(selectPokemon_5.getSelectionModel().getSelectedItem()));
                p.addPokemon(returnPokemon(selectPokemon_6.getSelectionModel().getSelectedItem()));
                players.add(p);

                System.out.println(p + " \t " + p.getName());
            }
        }

        if(players.size()>1){
            father.enableButtonsOfPlayers();
        }
    }
}
