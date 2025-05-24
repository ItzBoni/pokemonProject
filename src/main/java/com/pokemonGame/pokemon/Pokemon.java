// pokemon/Pokemon.java
package com.pokemonGame.pokemon;

import java.util.Objects;

public abstract class Pokemon implements Evolvable {
    protected String name;
    protected int level;
    protected int health;
    protected boolean alive;
    protected int evolution;
    protected tipo tipoPrimario;
    protected tipo tipoSecundario; // Puede ser normal si solo tiene un tipo
    protected int hpActual, hpMax;
    
    protected int ataque;
    protected int defensa;
    protected int ataqueEspecial;
    protected int defensaEspecial;
    protected int velocidad;

    public Attack[] listAttacks  = new Attack[4];
    
    protected Pokemon evolucionaA;


    public static enum tipo {
        AGUA, FUEGO, PLANTA, ELECTRICO, TIERRA, NORMAL
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
    public int getHpMax(){
        return hpMax;
    }

    public boolean getAlive(){
        return this.alive;
    }

    public void setAlive(boolean x){
        this.alive = x;
    }

    public void setAtaque(int atk){
        ataque = atk;
    }

    public int getAtaque(){
        return ataque;
    }

    public void setDefense(int def){
        defensa = def;
    }

    public int getDefense(){
        return defensa;
    }

    public void setVelocidad(int i){
        velocidad = i;
    }

    public int getVelocidad(){
        return velocidad;
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

    public void setHealth(int newHealth){
        if (newHealth < 0){
            this.health = 0;
            this.setAlive(false);
            return;
        }

        this.health = newHealth;
    }

    public int getSpeed(){
        return this.velocidad;
    }
    
    public tipo getPrimaryType() {
        return this.tipoPrimario;
    }
    public tipo getSecondaryType() {
        return this.tipoSecundario;
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
        return name + " [Max HP " + hpMax + ", HP: " + health +", Velocity" + velocidad +"]";
    }
     
    public void recibirAtaque(double daño, Attack.attackType t) {
        int dañoRecibido = (int) Math.round(daño); // Convertimos el daño a entero
        
        if(t == Attack.attackType.ESPECIAL){
            dañoRecibido -= this.defensaEspecial;
        } else {
            dañoRecibido -= this.defensa;
        }

        if (dañoRecibido < 0) dañoRecibido = 1;

        this.hpActual -= dañoRecibido;

        if (this.hpActual < 0) this.hpActual = 0;

        System.out.println(name + " recibe " + dañoRecibido + " de daño. HP restante: " + this.hpActual + "/" + this.hpMax);
        if (this.hpActual == 0) {
            System.out.println(name + " se ha debilitado.");
            this.setAlive(false);
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
