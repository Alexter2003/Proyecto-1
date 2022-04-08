package com.mycompany.proyect1.proyecto1;

public class Castor extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Castor";

    public String getNombre() {
        return nombre;
    }

    public Castor(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Acuatico";
        this.type[1] = "Terrestre";
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Castor castor = new Castor(2, 2, 1);
        misMascotas[this.posicion] = castor;

    }

    public void habilidad(Mascota misMascotas[], boolean vendido) {
        int buffAnimal1 =0;
        int buffAnimal2 =0;
        if (vendido) {
            giveAbility(definirDarHabilidad(buffAnimal1,misMascotas), definirDarHabilidad(buffAnimal2,misMascotas), misMascotas);
        }

    }

    //definir lo que hara su habilidad
    public void giveAbility(int buffAnimal1, int buffAnimal2, Mascota misMascotas[]) {
        if (this.level == 1) {
            int extraLife = 1;
            misMascotas[buffAnimal1].earnLife(extraLife);
            misMascotas[buffAnimal2].earnLife(extraLife);
        } else if (this.level == 2) {
            int extraLife = 2;
            misMascotas[buffAnimal1].earnLife(extraLife);
            misMascotas[buffAnimal2].earnLife(extraLife);
        } else if (this.level == 3) {
            int extraLife = 3;
            misMascotas[buffAnimal1].earnLife(extraLife);
            misMascotas[buffAnimal2].earnLife(extraLife);
        }
    }

    //Establecer que la habilidad le caiga a 2 animales aleatorios que no sean el
    public int definirDarHabilidad(int buffAnimal, Mascota[] misMascotas) {

        while (buffAnimal == this.posicion && misMascotas[buffAnimal]==null) {
            buffAnimal = (int) (Math.random() * (5 - 0) + 0);
        }
        return buffAnimal;
    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Castor.super.subirXp(fusion);

    }
    public void receiveDamage(int damageCaused) {
        vidaEnPelea -= damageCaused;
    }
}