package com.mycompany.proyect1.proyecto1;

public class Nutria extends Mascota {

    private String type = "Mamifero";

    protected String nombre="Nutria";

    public String getNombre() {
        return nombre;
    }

    public Nutria(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Nutria nutria = new Nutria(1, 2, 1);
        misMascotas[this.posicion] = nutria;
        habilidad(misMascotas);

    }

    //defini habilidad

    public void habilidad(Mascota misMascotas[]) {
        int buffAnimal =0;
        giveAbility(misMascotas, definirDarHabilidad(buffAnimal, misMascotas));
    }

    //definir lo que hara la habilidad
    public void giveAbility(Mascota misMascotas[], int buffAnimal) {
        if (this.level == 1) {
            int extraDamage = 1;
            int extraLife = 1;
            misMascotas[buffAnimal].earnDamage(extraDamage);
            misMascotas[buffAnimal].earnLife(extraLife);
        } else if (this.level == 2) {
            int extraDamage = 2;
            int extraLife = 2;
            misMascotas[buffAnimal].earnDamage(extraDamage);
            misMascotas[buffAnimal].earnLife(extraLife);
        } else if (this.level == 3) {
            int extraDamage = 3;
            int extraLife = 3;
            misMascotas[buffAnimal].earnDamage(extraDamage);
            misMascotas[buffAnimal].earnLife(extraLife);
        }
    }

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
        Nutria.super.subirXp(fusion);

    }

}