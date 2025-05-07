// Main.java
import pokemon.*;
import player.Player;
import potions.*;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[4];

        players[0] = new Player("Ash");
        players[1] = new Player("Misty");
        players[2] = new Player("Brock");
        players[3] = new Player("Gary");

        players[0].addPokemon(new FirePokemon("Charmander", 5, 100));

         players[1].addPokemon(new FirePokemon("Squirtle", 5, 100));
         players[2].addPokemon(new FirePokemon("Bulbasaur", 5, 100));

        // players[1].addPokemon(new WaterPokemon("Squirtle", 5, 100));
       // players[2].addPokemon(new GrassPokemon("Bulbasaur", 5, 100));
        players[3].addPokemon(new FirePokemon("Vulpix", 4, 90));

        for (int i = 0; i < 4; i++) {
            Player current = players[i];
            Player next = players[(i + 1) % 4];
            current.takeTurn(next);
        }
    }
}
