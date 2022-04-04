package proyecto1;



public class Rata extends Mascota {
    private String[] type = new String[2];
    protected String nombre="Rata";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Solitario";
        this.type[1] = "Terrestre";
    }

    public Rata(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Rata rata = new Rata(4, 5, 2);
        misMascotas[this.posicion] = rata;
    }

    //definir habilidad
    public void habilidad(Mascota[] mascotasEnemigas) {
        giveAbility(mascotasEnemigas);
    }

    // definiendo lo que hara la habilidad
    public void giveAbility(Mascota[] mascotasEnemigas) {
        if (level == 1) {
            moviendoAnimales1(mascotasEnemigas);
        } else if (level == 2) {
            moviendoAnimales2(mascotasEnemigas);

        } else if (level == 3) {
            moviendoAnimales3(mascotasEnemigas);


        }
    }


    public int espacioLibre(Mascota mascotasEnemigas[]) {
        int espacioLibre = 0;
        for (int i = 0; i <= mascotasEnemigas.length; i++) {
            mascotasEnemigas[i] = null;
            espacioLibre += 1;
        }
        return espacioLibre;
    }

    //[0][1][2][3][4]
    //moviendo Animales para el nivel 1 donde solo invoca una rata
    public void moviendoAnimales1(Mascota mascotasEnemigas[]) {
        if (espacioLibre(mascotasEnemigas) >= 1) {
            for (int i = mascotasEnemigas.length; i <= 0; i--) {
                if (mascotasEnemigas[i] == null) {

                } else if (mascotasEnemigas[i] instanceof Mascota) {
                    mascotasEnemigas[i + 1] = mascotasEnemigas[i];
                }
            }
            agregarRatasAlNivel1(mascotasEnemigas);
        }

    }

    //moviendo Animales para el nivel 2 donde invoca 2 ratas
    public void moviendoAnimales2(Mascota[] mascotasEnemigas) {
        if (espacioLibre(mascotasEnemigas) >= 2) {
            for (int i = mascotasEnemigas.length; i <= 0; i--) {
                if (mascotasEnemigas[i] == null) {

                } else if (mascotasEnemigas[i] instanceof Mascota) {
                    mascotasEnemigas[i + 2] = mascotasEnemigas[i];
                }
                agregarRatasAlNivel2(mascotasEnemigas);
            }

        } else if (espacioLibre(mascotasEnemigas) >= 1) {
            moviendoAnimales1(mascotasEnemigas);

        }

    }

    //moviendo Animales para el nivel 3 donde invoca 3 ratas
    public void moviendoAnimales3(Mascota[] mascotasEnemigas) {
        if (espacioLibre(mascotasEnemigas) >= 3) {
            for (int i = mascotasEnemigas.length; i <= 0; i--) {
                if (mascotasEnemigas[i] == null) {

                } else if (mascotasEnemigas[i] instanceof Mascota) {
                    mascotasEnemigas[i + 3] = mascotasEnemigas[i];
                }
            }
            agregarRatasAlNivel3(mascotasEnemigas);

        } else {
            moviendoAnimales2(mascotasEnemigas);
        }
    }


    private void agregarRatasAlNivel3(Mascota[] mascotasEnemigas) {
        DirtyRats dirtyRats = new DirtyRats(1, 1, 1);
        mascotasEnemigas[0] = dirtyRats;
        DirtyRats dirtyRats1 = new DirtyRats(1, 1, 1);
        mascotasEnemigas[1] = dirtyRats1;
        DirtyRats dirtyRats2 = new DirtyRats(1, 1, 1);
        mascotasEnemigas[2] = dirtyRats2;
    }

    private void agregarRatasAlNivel2(Mascota[] mascotasEnemigas) {
        DirtyRats dirtyRats = new DirtyRats(1, 1, 1);
        mascotasEnemigas[0] = dirtyRats;
        DirtyRats dirtyRats1 = new DirtyRats(1, 1, 1);
        mascotasEnemigas[1] = dirtyRats1;

    }

    private void agregarRatasAlNivel1(Mascota[] mascotasEnemigas) {
        DirtyRats dirtyRats = new DirtyRats(1, 1, 2);
        mascotasEnemigas[0] = dirtyRats;
    }

    //fusionar animal
    public void fusion( Mascota[] misMascotas , int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Rata.super.subirXp(fusion);

    }

    public void damageCaused(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        if (vidaEnPelea <= 0) {
            habilidad(misMascotas);
        }
    }


}
