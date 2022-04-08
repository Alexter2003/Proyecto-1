package com.mycompany.proyect1.proyecto1;



public class Elefante extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Elefante";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Mamifero";
        this.type[1] = "Terrestre";
    }

    public Elefante(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion,  Mascota misMascotas[]) {
        this.posicion = posicion;
        Elefante elefante = new Elefante(2, 5, 2);
        misMascotas[this.posicion] = elefante;
    }


    //Habilidad
    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);
    }

    //definiendo a quien le dara su habilidad
    public void giveAbility(Mascota  [] misMascotas) {
        misMascotas[this.posicion + 1].damageCaused(damageCaused());
    }

    //definiendo el danio que causara
    public int damageCaused() {
        if (this.level == 1) {
            return 1;
        } else if (this.level == 2) {
            return 2;
        } else {
            return 3;
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
        Elefante.super.subirXp(fusion);

    }
    public void receiveDamage(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        habilidad(misMascotas);
    }
}
