package com.pokemonGame.pokemon;

public class Attack implements Attackable{
    private int attackStrength = 0;
    private int attackAccurancy = 0;
    private String name;
    private Pokemon.tipo ATTACKTYPE;
    
    public static enum attackType {
        ESPECIAL,
        PHYSICAL
    };

    private attackType aType;

    public Attack(int x, String y, int acc, Pokemon.tipo TYPE, Attack.attackType t){
        this.attackStrength = x;
        this.attackAccurancy = acc;
        this.name = y;
        this.ATTACKTYPE = TYPE;
        this.aType = t;
    }

    public void setAttackName(String n){
        this.name = n;
    }
    
    public String getAttackName(){
        return this.name;
    }

    public int getAttackStrength(){
        return this.attackStrength;
    }

    protected boolean precision(){
        boolean xd = false;
        int randomNum = (int)(Math.random() * 101);
        
        if(randomNum <= this.attackAccurancy){
            xd = true;
        }

        return xd;
    }

    @Override
    public void attack(Pokemon p){
        if (precision()){
            double daño = this.attackStrength * TablaTipos.getMultiplicador(this.ATTACKTYPE, p.getPrimaryType()) * TablaTipos.getMultiplicador(this.ATTACKTYPE, p.getSecondaryType());
            p.recibirAtaque(daño, this.aType);
        }
    }
}
