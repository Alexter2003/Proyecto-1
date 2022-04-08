package com.mycompany.proyect1.proyecto1;

public class Caracol extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Caracol";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Insecto";
        this.type[1] = "Solitario";
    }

    public Caracol(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }




    //definiendo Habilidad
    public void habilidad(Mascota[] misMascotas, boolean batalla) {
        if (batalla) {
            giveAbility(misMascotas);
        }

    }

    //definiendo a quien le dara su habilidad
    public void giveAbility(Mascota[] misMascotas) {
        for (int i = 0; i < misMascotas.length; i++) {
            if (misMascotas[i] == misMascotas[this.posicion]) {

            } else {
                extraDamageAndLife(misMascotas, i);
            }
        }

    }

    public void extraDamageAndLife(Mascota[] misMascotas, int i) {
        if (this.level == 1) {
            int extraDamage = 1;
            int extraLife = 1;
            misMascotas[i].earnDamage(extraDamage);
            misMascotas[i].earnLife(extraLife);
        } else if (this.level == 2) {
            int extraDamage = 2;
            int extraLife = 2;
            misMascotas[i].earnDamage(extraDamage);
            misMascotas[i].earnLife(extraLife);
        } else if (this.level == 3) {
            int extraDamage = 3;
            int extraLife = 3;
            misMascotas[i].earnDamage(extraDamage);
            misMascotas[i].earnLife(extraLife);

        }
    }


    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Caracol.super.subirXp(fusion);

    }

}
