package com.mycompany.proyect1.proyecto1;

public class Jirafa extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Jirafa";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Doméstico";
        this.type[1] = "Terrestre";
    }

    public Jirafa(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }


    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Jirafa jirafa = new Jirafa(2, 5, 2);
        misMascotas[this.posicion] = jirafa;
    }

    //Definir Habilidad
    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);
    }

    //Definir a quien le dara la Habilidad
    public void giveAbility(Mascota[] misMascotas) {
        if(this.posicion!=0) {
            extraDamageAndLife(misMascotas);
        }
    }

    //definiendo la vida extra y el danio
    public void extraDamageAndLife(Mascota[] misMascotas) {
        if(this.level==1){
            misMascotas[this.posicion-1].earnDamage(1);
            misMascotas[this.posicion-1].earnLife(1);
        }else if(this.level==2){
            misMascotas[this.posicion-1].earnDamage(1);
            misMascotas[this.posicion-1].earnLife(1);
            misMascotas[this.posicion-2].earnDamage(1);
            misMascotas[this.posicion-2].earnLife(1);
        }else if(this.level==3){

        }

    }

    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Jirafa.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Jirafa.super.subirXp(fusion);
        }

    }
}
