// potion/Potion.java
package com.pokemonGame.potions;
import com.pokemonGame.pokemon.Pokemon;

public class Potion {
    private String type;
    private int effectValue;
    private int quant;

    public Potion(String type, int effectValue) {
        this.type = type;
        this.effectValue = effectValue;
        this.quant = 5;
    }

    public void refill(){
        quant = 5;
    }

    public String getType() {
        return type;
    }

    public int remainingUse(){
        return quant;
    }

    public void getEffectValue(Pokemon poke) {
        switch (this.type) {
            case "STRENGTH":
                poke.setAtaque(poke.getAtaque()+effectValue);
                break;
            case "HEALING":
                poke.curar(effectValue);
                break;
            case "DEFENSE":
                poke.setDefense(poke.getDefense()+ effectValue);
                break;
            case "SPEED":
                poke.setVelocidad(poke.getVelocidad()+effectValue);
                break;
            default:
                break;
        }

        quant--;
    }

    @Override
    public String toString() {
        return type + " Potion (Effect: " + effectValue + ")";
    }
}