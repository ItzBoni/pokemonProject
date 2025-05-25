package com.pokemonGame.Controllers;

import com.pokemonGame.pokemon.Pokemon;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;

import java.io.OutputStream;
import java.io.PrintStream;

import com.pokemonGame.player.Player;

import java.io.IOException;
import java.util.ArrayList;

public class CombatController {
    MainController father;
    ArrayList<Player> players = new ArrayList<>();
    Player player1, player2;
    private boolean turn = false; //FALSE PARA TURNO 1 TRUE PARA TURNO 2

    @FXML private Button passTurn;
    @FXML private Button attack;
    @FXML private Button useHealingPotion;
    @FXML private Button useStrengthPotion;
    @FXML private Button useDefPotion;
    @FXML private Button useSpeedPotion;
    @FXML private Button forfeit;
    @FXML private ComboBox<Pokemon> pokemonList;

    @FXML private TextArea ConsoleOutput;

    public void initialize() {
        redirectSystemOutputToConsole();
        player1 = players.get(0);
        player2 = players.get(1);

//        player1.recoverBeforeBattle();
//        player2.recoverBeforeBattle();
//
//        pokemonList.setItems(FXCollections.observableArrayList(player1.getAllPokemons()));
    }

    private void redirectSystemOutputToConsole() {
        PrintStream ps = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                // Print one character at a time
                javafx.application.Platform.runLater(() ->
                        ConsoleOutput.appendText(String.valueOf((char) b))
                );
            }

            @Override
            public void write(byte[] b, int off, int len) {
                String text = new String(b, off, len);
                javafx.application.Platform.runLater(() ->
                        ConsoleOutput.appendText(text)
                );
            }
        }, true);

        System.setOut(ps);
        System.setErr(ps);
    }


    public void setPlayersLists(ArrayList<Player> list){
        this.players = list;
    }

    public void setMainController(MainController father){
        this.father = father;
    }

    public void nextTurn(){

    }

}
