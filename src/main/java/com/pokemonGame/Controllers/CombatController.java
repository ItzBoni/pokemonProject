package com.pokemonGame.Controllers;

import com.pokemonGame.pokemon.Attack;
import com.pokemonGame.pokemon.Pokemon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

import com.pokemonGame.player.Player;

public class CombatController {
    MainController father;
    ObservableList<Player> players;
    Player player1, player2;
    Pokemon lastUsed;
    private boolean turn = false; //FALSE PARA TURNO 1 TRUE PARA TURNO 2

    @FXML private Label p1;
    @FXML private Button p1Attack;
    @FXML private Button p1useHealingPotion;
    @FXML private Button p1useStrengthPotion;
    @FXML private Button p1useDefPotion;
    @FXML private Button p1useSpeedPotion;
    @FXML private Button p1Forfeit;
    @FXML private ComboBox<Pokemon> p1PokemonList;


    @FXML private Label p2;
    @FXML private Button p2Attack;
    @FXML private Button p2useHealingPotion;
    @FXML private Button p2useStrengthPotion;
    @FXML private Button p2useDefPotion;
    @FXML private Button p2useSpeedPotion;
    @FXML private Button p2Forfeit;
    @FXML private ComboBox<Pokemon> p2PokemonList;

    @FXML private Button passTurn;

    @FXML private TextArea ConsoleOutput;

//    public void setMainController(MainController father){
//        this.father = father;
//    }

    public void initialize() {
        redirectSystemOutputToConsole();
    }

    public void initCombat() {
        System.out.println(players.size());
        if (players.size() < 2) {
            System.out.println("Error: Not enough players to start combat!");
            return;
        }

        player1 = players.get(0);
        player2 = players.get(1);

        p1PokemonList.setItems(FXCollections.observableArrayList(player1.getAllPokemons()));

        player1.recoverBeforeBattle();
        player2.recoverBeforeBattle();
        nextTurn();
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


    public void setPlayersLists(ObservableList<Player> list){
        this.players = list;
    }

    public void setMainController(MainController father){
        this.father = father;
    }

    public void nextTurn() {
        turn = !turn;

        String currentPlayerName = turn ? player2.getName() : player1.getName();
        System.out.println("Es el turno de " + currentPlayerName);

        Player currentPlayer = turn ? player2 : player1;
        p1PokemonList.setItems(FXCollections.observableArrayList(currentPlayer.getAllPokemons()));
        lastUsed = p1PokemonList.getValue();

        if (!currentPlayer.getAllPokemons().isEmpty()) {
            p1PokemonList.getSelectionModel().selectFirst();
        }

        checkWinCondition();
    }

    private void checkWinCondition() {
        if (player1.getDefeatedPokemons() >= 6) {
            System.out.println(player2.getName() + " ha ganado la batalla");
            endBattle(player2);
        } else if (player2.getDefeatedPokemons() >= 6) {
            System.out.println(player1.getName() + " ha ganado la batalla");
            endBattle(player1);
        }
    }

    private void endBattle(Player winner) {
        passTurn.setDisable(true);
        p1Attack.setDisable(true);
        p1useHealingPotion.setDisable(true);
        p1useStrengthPotion.setDisable(true);
        p1useDefPotion.setDisable(true);
        p1useSpeedPotion.setDisable(true);
        p1Forfeit.setDisable(true);

        System.out.println("¡" + winner.getName() + " es el ganador del combate!");

        javafx.animation.PauseTransition pause = new javafx.animation.PauseTransition(javafx.util.Duration.seconds(3));
        pause.setOnFinished(e -> {
            father.navigateToView(2);
        });
        pause.play();
    }

    @FXML
    public void useAttack(){
        Player attacker = turn ? player2 : player1;
        Player defender = turn ? player1 : player2;

        Pokemon attackerPokemon = p1PokemonList.getValue();

        if (attackerPokemon == null) {
            System.out.println("Selecciona un Pokémon para atacar.");
            return;
        }

        Pokemon defenderPokemon = lastUsed;

        if (defenderPokemon == null) {
            System.out.println("El oponente no tiene un Pokémon activo.");
            return;
        }

        int dmg = attackerPokemon.getAtaque();
        defenderPokemon.recibirAtaque(dmg, Attack.attackType.ESPECIAL); //Acá la vdd no supe como cambiarle el tipo de ataque dinamicamente -SB
        System.out.println(attackerPokemon.getName() + " atacó a " + defenderPokemon.getName() + " e hizo " + dmg + " de daño.");

        if (!defenderPokemon.getAlive()) {
            System.out.println(defenderPokemon.getName() + " se ha debilitado.");
            defender.setPokemonDefeated(defenderPokemon);
        }

        nextTurn();
    }

    @FXML public void useHealingPotion(){
        player1.personalBag.usePotion(p1PokemonList.getValue(),"HEALING");
    }

    @FXML public void useStrengthPotion(){
        player1.personalBag.usePotion(p1PokemonList.getValue(),"STRENGTH");
    }

    @FXML public void useDefPotion(){
        player1.personalBag.usePotion(p1PokemonList.getValue(), "DEFENSE");
    }

    @FXML public void useSpeedPotion(){
        player1.personalBag.usePotion(p1PokemonList.getValue(), "SPEED");
    }
}
