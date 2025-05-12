// pokemon/Pokemon.java
package pokemon;

public abstract class Pokemon implements Attackable, Evolvable {
    protected String name;
    protected int level;
    protected int health;
    protected boolean alive;

    public Pokemon(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public boolean getAlive(){
        return this.alive;
    }

    public void setAlive(boolean x){
        this.alive = x;
    }

    public void usePotion(int amount) {
        health += amount;
        System.out.println(name + " used a potion! Health is now " + health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pokemon)) return false;
        Pokemon other = (Pokemon) obj;
        return this.name.equals(other.name) && this.level == other.level;
    }

    @Override
    public String toString() {
        return name + " [Level " + level + ", HP: " + health + "]";
    }
}
