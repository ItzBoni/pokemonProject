package com.pokemonGame.Controllers;

import com.pokemonGame.pokemon.Attack;
import com.pokemonGame.pokemon.Pokemon;
import com.pokemonGame.player.Player;
import com.pokemonGame.pokemon.pokedex.Bulbasaur;
import com.pokemonGame.pokemon.pokedex.Charmander;
import com.pokemonGame.pokemon.pokedex.Digglet;
import com.pokemonGame.pokemon.pokedex.Pikachu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

public class CombatController {
    MainController father;
    ObservableList<Player> players;
    Player player1, player2;
    Player draw = new Player("Draw");
    Pokemon poke1 = new Bulbasaur();
    Pokemon poke2 = new Pikachu();
    Pokemon poke3 = new Charmander();
    Pokemon poke4 = new Digglet();

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
    private Pokemon activePoke1;


    @FXML private Label p2;
    @FXML private Button p2Attack;
    @FXML private Button p2useHealingPotion;
    @FXML private Button p2useStrengthPotion;
    @FXML private Button p2useDefPotion;
    @FXML private Button p2useSpeedPotion;
    @FXML private Button p2Forfeit;
    @FXML private ComboBox<Pokemon> p2PokemonList;
    private Pokemon activePoke2;

    @FXML private Button passTurn;

    @FXML private TextArea ConsoleOutput;

    public void initialize() {
        redirectSystemOutputToConsole();

        //player1 y player2 hardcodeados
        player1 = new Player("Santi");
        player1.addPokemon(poke1);
        player1.addPokemon(poke2);
        player2 = new Player("Angel");
        player2.addPokemon(poke3);
        player2.addPokemon(poke4);

        player1.recoverBeforeBattle();
        player2.recoverBeforeBattle();

        p1PokemonList.setItems(FXCollections.observableArrayList(player1.getAllPokemons()));
        p2PokemonList.setItems(FXCollections.observableArrayList(player2.getAllPokemons()));

        //Para que haya una selección por default y no pete xdlol
        p1PokemonList.getSelectionModel().selectFirst();
        p2PokemonList.getSelectionModel().selectFirst();

        System.out.flush();
        System.out.println("Bienvenidos al combate!!");
    }

    public void initCombat() {
        System.out.println(players.size());
        if (players.size() < 2) {
            System.out.println("Error: Not enough players to start combat!");
            return;
        }

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

        if (!currentPlayer.getAllPokemons().isEmpty()) {
            p1PokemonList.getSelectionModel().selectFirst();
        }

        checkWinCondition();
    }

    @FXML
    public void passTurn(){
        System.out.println("Turno pasado.");
        nextTurn();
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

        activePoke1 = p1PokemonList.getValue();
        activePoke2 = p2PokemonList.getValue();

        Pokemon attackerPokemon = turn ? activePoke2 : activePoke1;
        Pokemon defenderPokemon = turn ? activePoke1 : activePoke2;

        if (attackerPokemon == null || !attackerPokemon.getAlive()) {
            System.out.println(attackerPokemon);
            System.out.println("Tu Pokémon está debilitado. ¡Elige otro!");
            return;
        }

        if (defenderPokemon == null || !defenderPokemon.getAlive()) {
            System.out.println("El oponente no tiene un Pokémon activo.");
            return;
        }

        int dmg = attackerPokemon.getAtaque(); // Aquí podrías alternar entre ataque físico/especial según quieras
        defenderPokemon.recibirAtaque(dmg, Attack.attackType.ESPECIAL);

        System.out.println(attacker.getName() + " manda a " + attackerPokemon.getName() + " al ataque.");
        System.out.println(attackerPokemon.getName() + " usa un ataque especial contra " + defenderPokemon.getName() + "!");
        System.out.println("¡Hace " + dmg + " puntos de daño!");

        if (!defenderPokemon.getAlive()) {
            System.out.println(defenderPokemon.getName() + " se ha debilitado.");
            defender.setPokemonDefeated(defenderPokemon);

            // Auto-select next Pokémon if available
            Pokemon nextPoke = defender.getNextAlivePokemon();
            if (turn) {
                activePoke1 = nextPoke;
                p1PokemonList.getSelectionModel().select(nextPoke);
            } else {
                activePoke2 = nextPoke;
                p2PokemonList.getSelectionModel().select(nextPoke);
            }
        }

        checkWinCondition();
        nextTurn();
    }


    @FXML public void useHealingPotion(){
        if (!turn)
            player1.personalBag.usePotion(p1PokemonList.getValue(),"HEALING");
        else
            player2.personalBag.usePotion(p2PokemonList.getValue(),"HEALING");
    }

    @FXML public void useStrengthPotion(){
        if (!turn)
            player1.personalBag.usePotion(p1PokemonList.getValue(),"STRENGTH");
        else
            player2.personalBag.usePotion(p2PokemonList.getValue(),"STRENGTH");
    }

    @FXML public void useDefPotion(){
        if (!turn)
            player1.personalBag.usePotion(p1PokemonList.getValue(),"DEFENSE");
        else
            player2.personalBag.usePotion(p2PokemonList.getValue(),"DEFENSE");
    }

    @FXML public void useSpeedPotion(){
        if (!turn)
            player1.personalBag.usePotion(p1PokemonList.getValue(),"DEFENSE");
        else
            player2.personalBag.usePotion(p2PokemonList.getValue(),"DEFENSE");
    }

    @FXML public void forfeit(){
        endBattle(draw);
    }
}
