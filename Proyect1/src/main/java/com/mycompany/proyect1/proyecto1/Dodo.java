package com.mycompany.proyect1.proyecto1;

public class Dodo extends Mascota {
    private String type = "Volador";
    protected String nombre="Dodo";

    public String getNombre() {
        return nombre;
    }

    public Dodo(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Dodo Dodo = new Dodo(2, 3, 2);
        misMascotas[this.posicion] = Dodo;
    }

    //Definir Habilidad
    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);
    }

    //Definir a quien le dara la Habilidad
    public void giveAbility(Mascota[] misMascotas) {
        if(this.posicion!=0) {
            misMascotas[this.posicion - 1].earnDamage(extraDamage());
        }
    }

    //Encontrado el danio extra
    public int extraDamage() {
        if (level == 1) {
            return this.damage / 2;
        } else if (level == 2) {
            return this.damage;
        } else if (level == 3) {
            return (this.damage / 2) + this.damage;
        }else
            return 0;
    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Dodo.super.subirXp(fusion);

    }
    public void receiveDamage(int damageCaused) {
        vidaEnPelea -= damageCaused;
    }
}
