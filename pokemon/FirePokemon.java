// pokemon/FirePokemon.java
package pokemon;

public class FirePokemon extends Pokemon {

    public FirePokemon(String name, int level, int health) {
        super(name, level, health);
    }

    @Override
    public void attack(Pokemon target) {
        System.out.println(name + " attacks " + target.getName() + " with fire!");
        target.health -= 20;
    }

    @Override
    public void evolve() {
        level++;
        System.out.println(name + " evolved! Now at level " + level);
    }
}