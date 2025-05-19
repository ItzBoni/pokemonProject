package pokemon.pokedex;

import pokemon.Attack;
import pokemon.Pokemon;

public class Squirtle extends Pokemon {
    public Squirtle(){
        super("Squirtle", 5, 44, 16, 44, 14, 5, 24, 10, 10,Pokemon.tipo.AGUA, Pokemon.tipo.NORMAL);

        this.listAttacks[0]  = new Attack((int)(this.ataqueEspecial * 0.5), "Burbuja", 100, Pokemon.tipo.AGUA, Attack.attackType.ESPECIAL);
        this.listAttacks[1]  = new Attack((int)(this.ataqueEspecial * 0.75), "Rayo burbuja", 90, Pokemon.tipo.AGUA, Attack.attackType.ESPECIAL);
        this.listAttacks[2]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
        this.listAttacks[3]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
    }

    public void evolve(){
        System.out.println("I evolve.");
    }
}
