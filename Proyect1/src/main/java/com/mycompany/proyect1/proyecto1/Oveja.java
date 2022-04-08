
package com.mycompany.proyect1.proyecto1;

public class Oveja extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Oveja";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Doméstico";
        this.type[1] = "Terrestre";
    }

    public Oveja(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Oveja oveja = new Oveja(2, 2, 3);
        misMascotas[this.posicion] = oveja;
    }


    //[][2][1][c][c]

    //definir habilidad
    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);
    }

    // definiendo lo que hara la habilidad
    public void giveAbility(Mascota[] misMascotas) {
        if (level == 1) {
            moviendoAnimales1(misMascotas);
        } else if (level == 2) {
            moviendoAnimales2(misMascotas);
        }
    }


    public int espacioLibre(Mascota misMascotas[]) {
        int espacioLibre = 0;
        for (int i = 0; i <= misMascotas.length; i++) {
            misMascotas[i] = null;
            espacioLibre += 1;
        }
        return espacioLibre;
    }

    //[0][1][2][3][4]
    //moviendo Animales para el nivel 1 donde solo invoca una rata
    public void moviendoAnimales1(Mascota misMascotas[]) {
        if (espacioLibre(misMascotas) >= 1) {
            for (int i = misMascotas.length; i <= 0; i--) {
                if (misMascotas[i] == null) {

                } else if (misMascotas[i] instanceof Mascota) {
                    misMascotas[i + 1] = misMascotas[i];
                }
            }
            agregarCarnero(misMascotas);
        }

    }

    //moviendo Animales para el nivel 2 donde invoca 2 ratas
    public void moviendoAnimales2(Mascota[] misMascotas) {
        if (espacioLibre(misMascotas) >= 2) {
            for (int i = misMascotas.length; i <= 0; i--) {
                if (misMascotas[i] == null) {

                } else if (misMascotas[i] instanceof Mascota) {
                    misMascotas[i + 2] = misMascotas[i];
                }
                agregar2Carneros(misMascotas);
            }

        } else if (espacioLibre(misMascotas) >= 1) {
            moviendoAnimales1(misMascotas);

        }

    }

    private void agregarCarnero(Mascota[] misMascotas) {
        if (level == 1) {
            misMascotas[0] = new Carnero(2,2,3);
        } else if (level == 2) {
            misMascotas[0] = new Carnero(4,4,3);
        } else if (level == 3) {
            misMascotas[0] = new Carnero(6,6,3);
        }
    }

    private void agregar2Carneros(Mascota[] misMascotas) {
        if (level == 1) {
            misMascotas[0] = new Carnero(2,2,3);
            misMascotas[1] = new Carnero(2,2,3);
        } else if (level == 2) {
            misMascotas[0] = new Carnero(4,4,3);
            misMascotas[1] = new Carnero(4,4,3);
        } else if (level == 3) {
            misMascotas[0] = new Carnero(6,6,3);
            misMascotas[1] = new Carnero(6,6,3);
        }

    }


    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Oveja.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Oveja.super.subirXp(fusion);
        }
    }

    public void damageCaused(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        if (vidaEnPelea < 0) {
            habilidad(misMascotas);
        }
    }
}