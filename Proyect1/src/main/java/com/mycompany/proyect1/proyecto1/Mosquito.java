package com.mycompany.proyect1.proyecto1;

public class Mosquito extends Mascota{
    private String type="Volador";
    protected String nombre="Mosquito";

    public String getNombre() {
        return nombre;
    }

    public Mosquito (int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Mosquito mosquito = new Mosquito(2, 2, 1);
        misMascotas[posicion] = mosquito;

    }

    //definir Habilidad
    public void habilidad(Mascota mascotasEnemigas[]){
        int nerfAnimal = 0;
        int nerfAnimal2 = 0;
        int nerfAnimal3 = 0;
        giveAbility(mascotasEnemigas,definirDarHabilidad(nerfAnimal,mascotasEnemigas), definirDarHabilidad(nerfAnimal2,mascotasEnemigas),definirDarHabilidad(nerfAnimal3,mascotasEnemigas));
    }

    //definir lo que hara su habilidad
    public void giveAbility(Mascota[] mascotasEnemigas,int nerfAnimal, int nerfAnimal2, int nerfAnimal3){
        if (this.level == 1) {
            int Damage = 1;
            mascotasEnemigas[nerfAnimal].damageCaused(Damage);
        } else if (this.level == 2) {
            int Damage = 1;
            mascotasEnemigas[nerfAnimal].damageCaused(Damage);
            mascotasEnemigas[nerfAnimal2].damageCaused(Damage);
        } else if (this.level == 3) {
            int Damage = 1;
            mascotasEnemigas[nerfAnimal].damageCaused(Damage);
            mascotasEnemigas[nerfAnimal2].damageCaused(Damage);
            mascotasEnemigas[nerfAnimal3].damageCaused(Damage);
        }
    }

    public int definirDarHabilidad(int nerfAnimal, Mascota[] mascotasEnemigas) {

        while (nerfAnimal == this.posicion && mascotasEnemigas[nerfAnimal]==null) {
            nerfAnimal = (int) (Math.random() * (5 - 0) + 0);
        }
        return nerfAnimal;
    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Mosquito.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Mosquito.super.subirXp(fusion);
        }

    }

}
