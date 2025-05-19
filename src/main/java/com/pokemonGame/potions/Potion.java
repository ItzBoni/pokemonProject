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
    }

    public void refill(){
        quant = 5;
    }

    public String getType() {
        return type;
    }

    public String remainingUse(){
        return "You have "+quant+" uses left";
    }

    public void getEffectValue(Pokemon poke) {
        switch (this.type) {
            case "STRENGTH":
                poke.setAtaque(effectValue);
                break;
            case "HEALING":
                poke.curar(effectValue);
                break;
            case "DEFENSE":
                poke.setDefense(effectValue);
                break;
            case "SPEED":
                poke.setVelocidad(effectValue);
                break;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        return type + " Potion (Effect: " + effectValue + ")";
    }
}