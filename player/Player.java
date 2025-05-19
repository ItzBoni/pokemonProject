// player/Player.java
package player;

import pokemon.Pokemon;
import potions.Potion;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> pokemons = new ArrayList<>();
    private int defeatedPokemons = 0;

    public Player(String name) {
        this.name = name;
        this.defeatedPokemons = 0;
    }

    public void addPokemon(Pokemon p) {
        pokemons.add(p);
    }

    public void takeTurn(Player other) {
        if (!pokemons.isEmpty()) {
            Pokemon attacker = pokemons.get(0);
            Pokemon target = other.pokemons.get(0);
            attacker.attack(target);
        }
        checkPokemon();
    }

    public void checkPokemon() {
        for (int i = 0; i < pokemons.size(); i++) {
            if (!pokemons.get(i).getAlive()){
                defeatedPokemons += 1;
            }
        }
    }

    public String getName() {
        return name;
    }

    // Inner class: Bag
    public class Bag {
        List<Potion> potions = new ArrayList<>();

        public void addPotion(Potion p) {
            potions.add(p);
        }

        public void usePotion(Pokemon p) {
            if (!potions.isEmpty()) {
                Potion potion = potions.remove(0);
                p.usePotion(potion.getEffectValue());
            }
        }
    }

    @Override
    public String toString() {
        return name + " owns " + pokemons.size() + " Pokémon.";
    }
}

