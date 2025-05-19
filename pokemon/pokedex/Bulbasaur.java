package pokemon.pokedex;

import pokemon.Attack;
import pokemon.Pokemon;

public class Bulbasaur extends Pokemon {
    public Bulbasaur(){
        super("Bulbasaur", 5, 45, 16, 45, 11, 5, 26, 12, 8,Pokemon.tipo.PLANTA, Pokemon.tipo.NORMAL);

        this.listAttacks[0]  = new Attack((int)(this.ataqueEspecial * 0.5), "Latigo cepa", 100, Pokemon.tipo.PLANTA, Attack.attackType.ESPECIAL);
        this.listAttacks[1]  = new Attack((int)(this.ataqueEspecial), "Hoja afilada", 60, Pokemon.tipo.PLANTA, Attack.attackType.ESPECIAL);
        this.listAttacks[2]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
        this.listAttacks[3]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
    }

    public void evolve(){
        System.out.println("I evolve.");
    }
}
