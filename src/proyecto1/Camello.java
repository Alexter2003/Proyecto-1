package proyecto1;

public class Camello extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Camello";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Mamifero";
        this.type[1] = "Desertico";
    }

    public Camello(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Camello camello = new Camello(2, 5, 3);
        misMascotas[this.posicion] = camello;
    }

    //definiendo habilidad
    public void habilidad(Mascota[] misMascotas){
        extraDamageAndLife(misMascotas);
    }

    //definir a quien le dara su habilidad
    public void giveAbility(Mascota[] misMascotas, int extraLife, int extraDamage){
        if(this.posicion!=4){
            misMascotas[this.posicion+1].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion-1].earnLifeInBatle(extraLife);
        }
    }

    //definiendo los niveles de la habilidad
    public void extraDamageAndLife(Mascota[] misMascotas){
        if(level==1){
            int extraDamage=1;
            int extraLife=2;
            giveAbility(misMascotas,extraLife,extraDamage);
        }else if(level==2){
            int extraDamage=2;
            int extraLife=4;
            giveAbility(misMascotas,extraLife,extraDamage);
        }else if(level==3){
            int extraDamage=3;
            int extraLife=6;
            giveAbility(misMascotas,extraLife,extraDamage);
        }
    }

    public void damageCaused(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        if(vidaEnPelea>0){
            extraDamageAndLife(misMascotas);
        }
    }

}
