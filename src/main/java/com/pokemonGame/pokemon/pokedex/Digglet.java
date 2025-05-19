package src.main.java.com.pokemonGame.pokemon.pokedex;

import  src.main.java.com.pokemonGame.pokemon.Attack;
import  src.main.java.com.pokemonGame.pokemon.Pokemon;

public class Digglet extends Pokemon {
    public Digglet(){
        super("Digglet", 5, 20, 16, 20, 30, 6, 6, 10, 25,Pokemon.tipo.TIERRA, Pokemon.tipo.NORMAL);

        this.listAttacks[0]  = new Attack((int)(this.ataque * 0.5), "Bofetazo de lodo", 100, Pokemon.tipo.TIERRA, Attack.attackType.ESPECIAL);
        this.listAttacks[1]  = new Attack((int)(this.ataqueEspecial* 0.9), "Pequeño temblor", 70, Pokemon.tipo.TIERRA, Attack.attackType.ESPECIAL);
        this.listAttacks[2]  = new Attack((int)(this.ataque * 0.3), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
        this.listAttacks[3]  = new Attack((int)(this.ataque * 0.3), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
    }

    public void evolve(){
        System.out.println("I evolve.");
    }
}
