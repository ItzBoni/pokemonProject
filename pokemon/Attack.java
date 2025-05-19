package pokemon;

public class Attack implements Attackable{
    private int attackStrength = 0;
    private String name;
    private Pokemon.tipo ATTACKTYPE;
    private boolean check;

    public Attack(int x, String y, Pokemon.tipo TYPE){
        this.attackStrength = x;
        this.name = y;
        this.ATTACKTYPE = TYPE;
    }

    public void setAttack(String n){
        this.name = n;
    }
    
    public String getAttack(){
        return this.name;
    }

    protected boolean precision(int strength){
        boolean xd = false;
        int randomNum = (int)(Math.random() * 101);
        if(randomNum < (strength+5) && randomNum > (strength-5)){
            System.out.println("Tu ataque fue preciso");
            xd = true;
        } else {
            System.out.println("El ataque no fue efectivo");
        }
        return xd;
    }

    @Override
    public void attack(Pokemon t){
        switch (ATTACKTYPE) {
            case AGUA:
                check = precision(attackStrength);
                if (check) {
                    
                }
                break;
            case FUEGO:
                check = precision(attackStrength);
                break;
            case PLANTA:
                check = precision(attackStrength);
                break;
            default:
                break;
        }
    }

    //Creo distintos ataques dependiendo del tipo de pokemon
    //Métodos get para regresar el tipo del ataque y el daño hecho
    //Algún método para la presición del ataque, un random que regrese un boolean si acerta o no
    //Que el de la presición funcione como un check en dnd
}
