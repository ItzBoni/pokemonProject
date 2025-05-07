// potion/Potion.java
package potions;

public class Potion {
    private PotionType type;
    private int effectValue;

    public Potion(PotionType type, int effectValue) {
        this.type = type;
        this.effectValue = effectValue;
    }

    public PotionType getType() {
        return type;
    }

    public int getEffectValue() {
        return effectValue;
    }

    @Override
    public String toString() {
        return type + " Potion (Effect: " + effectValue + ")";
    }
}