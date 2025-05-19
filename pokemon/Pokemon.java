// pokemon/Pokemon.java
package pokemon;

import java.util.Objects;

public abstract class Pokemon implements Attackable, Evolvable {
    protected String name;
    protected int level;
    protected int health;
    protected boolean alive;
    protected int evolution;
    private tipo tipoPrimario;
    private tipo tipoSecundario; // Puede ser null si solo tiene un tipo
    private int hpActual, hpMax;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private Pokemon evolucionaA;

    //Falta agregar metodos get and set xdlol

    public static enum tipo {
        AGUA, FUEGO, PLANTA, ELECTRICO, TIERRA
    }


    protected tipo Type1;


    
    public Pokemon(String name, int level, int health, int evolution, int hpMax, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, tipo tipoPrimario, tipo tipoSecundario) { //Constructor donde faltaria agregar algunas cosas
        this.name = name;
        this.level = level;
        this.health = health;
        this.evolution = evolution;
        this.hpMax = hpMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.tipoPrimario = Objects.requireNonNull(tipoPrimario, "El tipo primario no puede ser null.");
        this.tipoSecundario = tipoSecundario;
    }
        public Pokemon(String name, int level, int health, int evolution, int hpMax, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, tipo tipoPrimario) { //Constructor donde faltaria agregar algunas cosas
        this.name = name;
        this.level = level;
        this.health = health;
        this.evolution = evolution;
        this.hpMax = hpMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.tipoPrimario = tipoPrimario;
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
     
    public void recibirAtaque(double daño) {
        int dañoRecibido = (int) Math.round(daño); // Convertimos el daño a entero
        this.hpActual -= dañoRecibido;
        if (this.hpActual < 0) {
            this.hpActual = 0;
        }
        System.out.println(name + " recibe " + dañoRecibido + " de daño. HP restante: " + this.hpActual + "/" + this.hpMax);
        if (this.hpActual == 0) {
            System.out.println(name + " se ha debilitado.");
        }
    }
     public void curar(int puntos) { //puntos vendria desde la clase pociones
        this.hpActual += puntos;
        if (this.hpActual > this.hpMax) {
            this.hpActual = this.hpMax;
        }
        System.out.println(name + " se cura " + puntos + " puntos de salud. HP actual: " + this.hpActual + "/" + this.hpMax);
    }


}
