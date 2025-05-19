package pokemon.pokedex;

import pokemon.Attack;
import pokemon.Pokemon;

public class Charmander extends Pokemon {
    public Charmander(){
        super("Charmander", 5, 39, 16, 39, 20, 8, 23, 10, 12,Pokemon.tipo.FUEGO, Pokemon.tipo.NORMAL);

        this.listAttacks[0]  = new Attack((int)(this.ataqueEspecial * 0.5), "Ascuas", 100, Pokemon.tipo.FUEGO, Attack.attackType.ESPECIAL);
        this.listAttacks[1]  = new Attack((int)(this.ataqueEspecial), "Llamarada", 70, Pokemon.tipo.FUEGO, Attack.attackType.ESPECIAL);
        this.listAttacks[2]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
        this.listAttacks[3]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
    }

    public void evolve(){
        System.out.println("I evolve.");
    }
}
