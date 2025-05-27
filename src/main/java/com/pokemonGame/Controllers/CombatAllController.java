package com.pokemonGame.Controllers;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.pokemonGame.player.Player;
import com.pokemonGame.pokemon.Pokemon;
import com.pokemonGame.pokemon.TablaTipos;

public class CombatAllController {
    
    ObservableList<Player> playersForCombat;
    PriorityQueue<Turn> turnQueue =  new PriorityQueue<>();
    int attack_pokemon_1 = 0;
    int attack_pokemon_2 = 0;
    int attack_pokemon_3 = 0;
    int attack_pokemon_4 = 0;

    MainController father;

    @FXML ComboBox<Player> SelectObjective_P_1;
    @FXML ComboBox<Player> SelectObjective_P_2;
    @FXML ComboBox<Player> SelectObjective_P_3;
    @FXML ComboBox<Player> SelectObjective_P_4;

    @FXML ComboBox<Pokemon> selectPokemon_P_1;
    @FXML ComboBox<Pokemon> selectPokemon_P_2;
    @FXML ComboBox<Pokemon> selectPokemon_P_3;
    @FXML ComboBox<Pokemon> selectPokemon_P_4;

    @FXML Label CombatAll_Player_1;
    @FXML Label CombatAll_Player_2;
    @FXML Label CombatAll_Player_3;
    @FXML Label CombatAll_Player_4;

    @FXML Label CombatAll_Pokemon_1;
    @FXML Label CombatAll_Pokemon_2;
    @FXML Label CombatAll_Pokemon_3;
    @FXML Label CombatAll_Pokemon_4;

    @FXML Button CombatAll_Attack_1_P_1;
    @FXML Button CombatAll_Attack_2_P_1;
    @FXML Button CombatAll_Attack_3_P_1;
    @FXML Button CombatAll_Attack_4_P_1;

    @FXML Button CombatAll_Attack_1_P_2;
    @FXML Button CombatAll_Attack_2_P_2;
    @FXML Button CombatAll_Attack_3_P_2;
    @FXML Button CombatAll_Attack_4_P_2;

    @FXML Button CombatAll_Attack_1_P_3;
    @FXML Button CombatAll_Attack_2_P_3;
    @FXML Button CombatAll_Attack_3_P_3;
    @FXML Button CombatAll_Attack_4_P_3;

    @FXML Button CombatAll_Attack_1_P_4;
    @FXML Button CombatAll_Attack_2_P_4;
    @FXML Button CombatAll_Attack_3_P_4;
    @FXML Button CombatAll_Attack_4_P_4;

    public static class Turn implements Comparable<Turn>{
        Pokemon objective;
        Pokemon attacker;
        int Priority;
        int nthAttack;

        public Turn(Pokemon ob, Pokemon att, int nthAttack){
            this.objective = ob;
            this.attacker =att;
            this.Priority = att.getSpeed();
            this.nthAttack = nthAttack;
        }

        public void takeTurn(){
            if(attacker.getAlive()) attacker.listAttacks[nthAttack].attack(objective);
        }

        @Override
        public int compareTo(Turn other){
            return Integer.compare(other.Priority, this.Priority);
        }
    }

    @FXML public void initialize(){
        TablaTipos t =  new TablaTipos();

        selectPokemon_P_1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            CombatAll_Pokemon_1.setText( "Pokemon health: "+ newValue.getHealth() +  " / " + newValue.getHpMax());
            CombatAll_Attack_1_P_1.setText(newValue.listAttacks[0].getAttackName());
            CombatAll_Attack_2_P_1.setText(newValue.listAttacks[1].getAttackName());
            CombatAll_Attack_3_P_1.setText(newValue.listAttacks[2].getAttackName());
            CombatAll_Attack_4_P_1.setText(newValue.listAttacks[3].getAttackName());
        });

        selectPokemon_P_2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            CombatAll_Pokemon_2.setText( "Pokemon health: "+newValue.getHealth() +  " / " + newValue.getHpMax());
            CombatAll_Attack_1_P_2.setText(newValue.listAttacks[0].getAttackName());
            CombatAll_Attack_2_P_2.setText(newValue.listAttacks[1].getAttackName());
            CombatAll_Attack_3_P_2.setText(newValue.listAttacks[2].getAttackName());
            CombatAll_Attack_4_P_2.setText(newValue.listAttacks[3].getAttackName());
        });

        selectPokemon_P_3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            CombatAll_Pokemon_3.setText( "Pokemon health: "+newValue.getHealth() +  " / " + newValue.getHpMax());
            CombatAll_Attack_1_P_3.setText(newValue.listAttacks[0].getAttackName());
            CombatAll_Attack_2_P_3.setText(newValue.listAttacks[1].getAttackName());
            CombatAll_Attack_3_P_3.setText(newValue.listAttacks[2].getAttackName());
            CombatAll_Attack_4_P_3.setText(newValue.listAttacks[3].getAttackName());
        });

        selectPokemon_P_4.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            CombatAll_Pokemon_4.setText( "Pokemon health: "+newValue.getHealth() +  " / " + newValue.getHpMax());
            CombatAll_Attack_1_P_4.setText(newValue.listAttacks[0].getAttackName());
            CombatAll_Attack_2_P_4.setText(newValue.listAttacks[1].getAttackName());
            CombatAll_Attack_3_P_4.setText(newValue.listAttacks[2].getAttackName());
            CombatAll_Attack_4_P_4.setText(newValue.listAttacks[3].getAttackName());
        });

        CombatAll_Attack_1_P_1.setOnAction(event -> {attack_pokemon_1 = 0;});
        CombatAll_Attack_2_P_1.setOnAction(event -> {attack_pokemon_1 = 1;});
        CombatAll_Attack_3_P_1.setOnAction(event -> {attack_pokemon_1 = 2;});
        CombatAll_Attack_4_P_1.setOnAction(event -> {attack_pokemon_1 = 3;});

        CombatAll_Attack_1_P_2.setOnAction(event -> {attack_pokemon_2 = 0;});
        CombatAll_Attack_2_P_2.setOnAction(event -> {attack_pokemon_2 = 1;});
        CombatAll_Attack_3_P_2.setOnAction(event -> {attack_pokemon_2 = 2;});
        CombatAll_Attack_4_P_2.setOnAction(event -> {attack_pokemon_2 = 3;});

        CombatAll_Attack_1_P_3.setOnAction(event -> {attack_pokemon_3 = 0;});
        CombatAll_Attack_2_P_3.setOnAction(event -> {attack_pokemon_3 = 1;});
        CombatAll_Attack_3_P_3.setOnAction(event -> {attack_pokemon_3 = 2;});
        CombatAll_Attack_4_P_3.setOnAction(event -> {attack_pokemon_3 = 3;});

        CombatAll_Attack_1_P_4.setOnAction(event -> {attack_pokemon_4 = 0;});
        CombatAll_Attack_2_P_4.setOnAction(event -> {attack_pokemon_4 = 1;});
        CombatAll_Attack_3_P_4.setOnAction(event -> {attack_pokemon_4 = 2;});
        CombatAll_Attack_4_P_4.setOnAction(event -> {attack_pokemon_4 = 3;});
    }

    public void setPlayersForCombat(ObservableList<Player> list){
        this.playersForCombat = list;

        SelectObjective_P_1.setItems(playersForCombat);
        SelectObjective_P_2.setItems(playersForCombat);
        SelectObjective_P_3.setItems(playersForCombat);
        SelectObjective_P_4.setItems(playersForCombat);
    }

    public void setPokemonsForCombat(ArrayList<ComboBox<Pokemon>> list){
        list.add(selectPokemon_P_1);
        list.add(selectPokemon_P_2);
        list.add(selectPokemon_P_3);
        list.add(selectPokemon_P_4);
    }

    public void setLabelsForCombat(ArrayList<Label> list){
        list.add(CombatAll_Player_1);
        list.add(CombatAll_Player_2);
        list.add(CombatAll_Player_3);
        list.add(CombatAll_Player_4);
    }

    public void setMainController(MainController father){
        this.father = father;
    }

    
    @FXML private void showWarningAlert(String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Imposible ejecutar turno");
        alert.setHeaderText("No se puede continuar al combate.");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public boolean verifyPokemonSelectionEmpty(){
        return  selectPokemon_P_1.getSelectionModel().isEmpty() || selectPokemon_P_2.getSelectionModel().isEmpty() || 
                selectPokemon_P_3.getSelectionModel().isEmpty() || selectPokemon_P_4.getSelectionModel().isEmpty();
    }

    public boolean verifyObjectiveSelectionEmpty(){
        return  SelectObjective_P_1.getSelectionModel().isEmpty() || SelectObjective_P_2.getSelectionModel().isEmpty() || 
                SelectObjective_P_3.getSelectionModel().isEmpty() || SelectObjective_P_4.getSelectionModel().isEmpty();
    }

    public boolean verifyAnyDefeatedPokemon(){
            return  (selectPokemon_P_1.getSelectionModel().getSelectedItem().getAlive() || playersForCombat.get(0).getPokemonDefeated() == 6 )&& 
                (selectPokemon_P_2.getSelectionModel().getSelectedItem().getAlive() || playersForCombat.get(1).getPokemonDefeated() == 6 )&&
                (selectPokemon_P_3.getSelectionModel().getSelectedItem().getAlive() || playersForCombat.get(2).getPokemonDefeated() == 6 )&& 
                (selectPokemon_P_4.getSelectionModel().getSelectedItem().getAlive() || playersForCombat.get(3).getPokemonDefeated() == 6 );
    }

  public boolean verifyValidObjective(){
    return !(SelectObjective_P_1.getSelectionModel().getSelectedItem().getPokemonDefeated() == 6 && playersForCombat.get(0).getPokemonDefeated() != 6) &&
           !(SelectObjective_P_2.getSelectionModel().getSelectedItem().getPokemonDefeated() == 6 && playersForCombat.get(1).getPokemonDefeated() != 6) &&
           !(SelectObjective_P_3.getSelectionModel().getSelectedItem().getPokemonDefeated() == 6 && playersForCombat.get(2).getPokemonDefeated() != 6) &&
           !(SelectObjective_P_4.getSelectionModel().getSelectedItem().getPokemonDefeated() == 6 && playersForCombat.get(3).getPokemonDefeated() != 6);
    }

    public Pokemon returnPokemon(Player p){
        if (playersForCombat.get(0) == p) return selectPokemon_P_1.getSelectionModel().getSelectedItem();
        else if (playersForCombat.get(1) == p) return selectPokemon_P_2.getSelectionModel().getSelectedItem();
        else if (playersForCombat.get(2) == p) return selectPokemon_P_3.getSelectionModel().getSelectedItem();
        else return selectPokemon_P_4.getSelectionModel().getSelectedItem();
    }

    @FXML public void takeTurn(){
        if(verifyObjectiveSelectionEmpty() || verifyPokemonSelectionEmpty()){
            showWarningAlert("Jugadores no dejen ningun espacio vacio.");
            return;
        }
        
        if(!verifyAnyDefeatedPokemon()){
            showWarningAlert("Todos los jugadores que tengan algun pokemon con vida deben seleccionar alguno.");
            return;
        }

        if(!verifyValidObjective()){
            showWarningAlert("Todos los jugadores que puedan deben seleccionar un objetivo valido para atacar.");
            return;
        }
        
        turnQueue.clear();

        if(playersForCombat.get(0).getPokemonDefeated()!=6){
            Turn turn = new Turn(returnPokemon(SelectObjective_P_1.getSelectionModel().getSelectedItem()), selectPokemon_P_1.getSelectionModel().getSelectedItem(), attack_pokemon_1);
            turnQueue.add(turn);
        }
        if(playersForCombat.get(1).getPokemonDefeated()!=6){
            Turn turn = new Turn(returnPokemon(SelectObjective_P_2.getSelectionModel().getSelectedItem()), selectPokemon_P_2.getSelectionModel().getSelectedItem(), attack_pokemon_2);
            turnQueue.add(turn);
        }
        if(playersForCombat.get(2).getPokemonDefeated()!=6){
            Turn turn = new Turn(returnPokemon(SelectObjective_P_3.getSelectionModel().getSelectedItem()), selectPokemon_P_3.getSelectionModel().getSelectedItem(), attack_pokemon_3);
            turnQueue.add(turn);
        }

        if(playersForCombat.get(3).getPokemonDefeated()!=6){
            Turn turn = new Turn(returnPokemon(SelectObjective_P_4.getSelectionModel().getSelectedItem()), selectPokemon_P_4.getSelectionModel().getSelectedItem(), attack_pokemon_4);
            turnQueue.add(turn);
        }

        while (!turnQueue.isEmpty()) {
            Turn turn = turnQueue.poll();
            try {
                if (turn != null) {
                    turn.takeTurn();


                }
            } catch (Exception e) {
                e.printStackTrace();
                showWarningAlert(e.getMessage());
            }
        }

        CombatAll_Pokemon_1.setText("Pokemon health: " + selectPokemon_P_1.getSelectionModel().getSelectedItem().getHealth() + " / " + selectPokemon_P_1.getSelectionModel().getSelectedItem().getHpMax());
        CombatAll_Pokemon_2.setText("Pokemon health: " + selectPokemon_P_2.getSelectionModel().getSelectedItem().getHealth() + " / " + selectPokemon_P_2.getSelectionModel().getSelectedItem().getHpMax());
        CombatAll_Pokemon_3.setText("Pokemon health: " + selectPokemon_P_3.getSelectionModel().getSelectedItem().getHealth() + " / " + selectPokemon_P_3.getSelectionModel().getSelectedItem().getHpMax());
        CombatAll_Pokemon_4.setText("Pokemon health: " + selectPokemon_P_4.getSelectionModel().getSelectedItem().getHealth() + " / " + selectPokemon_P_4.getSelectionModel().getSelectedItem().getHpMax());


        int count = 0;
        for(Player p: playersForCombat){
            p.checkPokemon();

            if(p.getPokemonDefeated() == 6){
                count++;
            }
        }

        if(count == 3){
            for(Player p: playersForCombat){
                if(p.getPokemonDefeated() != 6){
                    showWarningAlert("El jugador " +  p.getName() + " es el ganador.");
                    exitCombat();
                }
            }
        }
    }

    @FXML public void exitCombat(){
        father.navigateToView(2);
    }

     
}


