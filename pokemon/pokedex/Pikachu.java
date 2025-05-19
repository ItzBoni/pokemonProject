package pokemon.pokedex;

import pokemon.Attack;
import pokemon.Pokemon;

public class Pikachu extends Pokemon {
    public Pikachu(){
        super("Pikachu", 5, 35, 16, 35, 15, 12, 15, 12, 20,Pokemon.tipo.ELECTRICO, Pokemon.tipo.NORMAL);

        this.listAttacks[0]  = new Attack((int)(this.ataqueEspecial * 0.5), "Chispa", 100, Pokemon.tipo.ELECTRICO, Attack.attackType.ESPECIAL);
        this.listAttacks[1]  = new Attack((int)(this.ataqueEspecial* 0.8), "Descarga", 80, Pokemon.tipo.ELECTRICO, Attack.attackType.ESPECIAL);
        this.listAttacks[2]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
        this.listAttacks[3]  = new Attack((int)(this.ataque * 0.5), "Rasguño", 100, Pokemon.tipo.NORMAL, Attack.attackType.PHYSICAL);
    }

    public void evolve(){
        System.out.println("I evolve.");
    }
}
