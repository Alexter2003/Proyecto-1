package com.mycompany.proyect1.proyecto1;



public class Pescado extends Mascota {

    private String type = "Acuatico";
    protected String nombre="Pescado";

    public String getNombre() {
        return nombre;
    }


    public Pescado(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir poscion
    public void setPosicion(int posicion,  Mascota misMascotas[]) {
        this.posicion = posicion;
        Pescado pescado = new Pescado(2, 3, 1);
        misMascotas[posicion] = pescado;

    }


    //definir Habilidad
    public void habilidad(Mascota misMascotas[]) {
        for (int i = 0; i < misMascotas.length; i++) {
            if (misMascotas[i] == misMascotas[this.posicion]) {

            } else {
                giveAbility(misMascotas, i);
            }
        }

    }

    //definir lo que hara su habilidad
    public void giveAbility(Mascota misMascotas[], int i) {
        if (this.level == 2) {
            int extraDamage = 1;
            int extraLife = 1;
            misMascotas[i].earnDamage(extraDamage);
            misMascotas[i].earnLife(extraLife);
        } else if (this.level == 3) {
            int extraDamage = 2;
            int extraLife = 2;
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
        subirXp(fusion, misMascotas, animalAFusionar);

    }

    public void subirXp(boolean fusion, Mascota[] misMascotas, int animalAFusionar) {
        if (!fusion) {
            System.out.println("No se puede fusionar");
        } else {
            xp += 1;
        }
        //comprobando si subio de nivel
        if (xp == 2) {
            System.out.println("Mascota subio a nivel 2");
            level = 2;
            habilidad(misMascotas);
        } else if (xp == 5) {
            System.out.println("Mascota subio a nivel 3");
            level = 3;
            habilidad(misMascotas);
        }
    }



}
