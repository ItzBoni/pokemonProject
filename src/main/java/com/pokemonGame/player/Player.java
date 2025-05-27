// player/Player.java
package com.pokemonGame.player;

import  com.pokemonGame.pokemon.Pokemon;
import com.pokemonGame.pokemon.pokedex.Bulbasaur;
import com.pokemonGame.pokemon.pokedex.Charmander;
import com.pokemonGame.pokemon.pokedex.Digglet;
import com.pokemonGame.pokemon.pokedex.Pikachu;
import com.pokemonGame.pokemon.pokedex.Squirtle;
import  com.pokemonGame.potions.Potion;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> pokemons = new ArrayList<>();
    private List<Pokemon> defeatedPokemons = new ArrayList<>();
    public Bag personalBag = new Bag();

    public Player(String name) {
        this.name = name;
    }

    public int getDefeatedPokemons(){
        return defeatedPokemons.size();
    }

    public List<Pokemon> getAllPokemons(){
        return this.pokemons;
    }

    public void addPokemon(Pokemon p) {
        pokemons.add(p);
    }

    public void revivePoke(){
        for(Pokemon p: pokemons){
            p.setHealth(p.getHpMax());
        }
    }

    public void setPokemonDefeated(Pokemon poke){
        this.defeatedPokemons.add(poke);
        this.pokemons.remove(poke);
    }

//    private void setDefeatedPokemons(int n){
//        this.defeatedPokemons = n;
//    }

    public String getName() {
        return name;
    }

    // Inner class: Bag
    public class Bag {
        List<Potion> potions = new ArrayList<>();

        public Bag(){
            this.addPotion(new Potion("HEALING", 14));
            this.addPotion(new Potion("STRENGTH", 8));
            this.addPotion(new Potion("DEFENSE", 6));
            this.addPotion(new Potion("SPEED", 10));
        }

        public void addPotion(Potion p) {
            potions.add(p);
        }

        public void usePotion(Pokemon p, String type) {
            for (Potion potion : potions){
                if (potion.getType()== type) {

                    if(potion.remainingUse()==0) continue;

                    potion.getEffectValue(p);
                    break;
                }
            }
        }
    }

    private static Pokemon returnPokemon(String p){
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

    public void recoverBeforeBattle() {
        // Restore health and reset status/stats of all Pokémon
        for (Pokemon p : pokemons) {
            p.setHealth(p.getHpMax());
        }

        defeatedPokemons.clear();
    }

    @Override
    public String toString() {
        return name;
    }
}

