
package com.mycompany.proyect1.proyecto1;

public class Venado extends Mascota {

    private String type = "Mamifero";
    protected String nombre="Venado";

    public String getNombre() {
        return nombre;
    }

    public Venado(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Venado venado = new Venado(1, 1, 4);
        misMascotas[this.posicion] = venado;
    }

    public void habilidad(Mascota[] misMascotas, Mascota mascotasEnemigas[]) {
        if (this.level == 1) {
            misMascotas[this.posicion] = new Camion(5,5,4);

        } else if (this.level == 2) {
            misMascotas[this.posicion] = new Camion(10,10,4);

        } else if (this.level == 2) {
            misMascotas[this.posicion] = new Camion(15,15,4);
        }

    }

    public void damageCaused(int damageCaused, Mascota[] misMascotas, Mascota mascotasEnemigas[]) {
        vidaEnPelea -= damageCaused;
        if (vidaEnPelea <= 0) {
            habilidad(misMascotas, mascotasEnemigas);
        }

    }

    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Venado.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Venado.super.subirXp(fusion);
        }
    }
}