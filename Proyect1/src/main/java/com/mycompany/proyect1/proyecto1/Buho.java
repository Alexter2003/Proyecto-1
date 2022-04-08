package com.mycompany.proyect1.proyecto1;

public class Buho extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Buho";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Volador";
        this.type[1] = "Solitario";
    }

    public Buho(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota[] misMascotas, boolean ganoBatalla) {
        this.posicion = posicion;
        Caracol caracol = new Caracol(2, 5, 3);
        misMascotas[this.posicion] = caracol;

    }

    //definiendo la habilidad
    public void habilidad(Mascota[] misMascotas) {
        int buffAnimal = 0;
        extraDamageAndLife(misMascotas, buffAnimal);
    }

    //Definiendo la vida y el danio extra
    public void extraDamageAndLife(Mascota[] misMascotas, int buffAnimal) {
        if (level == 1) {
            misMascotas[giveAbility(misMascotas, buffAnimal)].earnDamage(2);
            misMascotas[giveAbility(misMascotas, buffAnimal)].earnLife(2);
        } else if (level == 2) {
            misMascotas[giveAbility(misMascotas, buffAnimal)].earnDamage(4);
            misMascotas[giveAbility(misMascotas, buffAnimal)].earnLife(4);
        } else if (level == 3) {
            misMascotas[giveAbility(misMascotas, buffAnimal)].earnDamage(6);
            misMascotas[giveAbility(misMascotas, buffAnimal)].earnLife(6);
        }
    }

    //definiendo a quien le dara su habilidad
    public int giveAbility(Mascota[] misMascotas, int buffAnimal) {
        while (this.posicion == buffAnimal && misMascotas[buffAnimal] == null) {
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
        Buho.super.subirXp(fusion);

    }

}
