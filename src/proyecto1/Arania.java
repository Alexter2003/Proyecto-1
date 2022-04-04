package proyecto1;

public class Arania extends Mascota {
    private String type = "Insecto";
    protected String nombre = "Araña";

    public String getNombre() {
        return nombre;
    }

    public Arania(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;

    }


    //definir Habilidad
    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);
    }

    //definiendo lo que hara la habilidad
    public void giveAbility(Mascota[] misMascotas) {
        if (level == 1) {
            animalInvocado1(misMascotas);
        } else if (level == 2) {
            animalInvocado2(misMascotas);
        } else if (level == 3) {
            animalInvocado3(misMascotas);
        }
    }

    //generar numero aleatorio
    public int noAnimalInvocado() {
        int noAnimal = (int) (Math.random() * (11 - 0) + 0);
        return noAnimal;
    }


    //generando Animal
    public void animalInvocado1(Mascota[] misMascotas) {
        if (noAnimalInvocado() == 0) {
            misMascotas[this.posicion] = new Camello(2, 2, 3);
        } else if (noAnimalInvocado() == 1) {
            misMascotas[this.posicion] = new Mapache(2, 2, 3);
        } else if (noAnimalInvocado() == 2) {
            misMascotas[this.posicion] = new Tortuga(2, 2, 3);
        } else if (noAnimalInvocado() == 3) {
            misMascotas[this.posicion] = new Caracol(2, 2, 3);
        } else if (noAnimalInvocado() == 4) {
            misMascotas[this.posicion] = new Oveja(2, 2, 3);
        } else if (noAnimalInvocado() == 5) {
            misMascotas[this.posicion] = new Conejo(2, 2, 3);
        } else if (noAnimalInvocado() == 7) {
            misMascotas[this.posicion] = new Buey(2, 2, 3);
        } else if (noAnimalInvocado() == 8) {
            misMascotas[this.posicion] = new Canguro(2, 2, 3);
        } else if (noAnimalInvocado() == 9) {
            misMascotas[this.posicion] = new Buho(2, 2, 3);
        }
    }

    public void animalInvocado2(Mascota[] misMascotas) {
        if (noAnimalInvocado() == 0) {
            misMascotas[this.posicion] = new Camello(4, 4, 3);
        } else if (noAnimalInvocado() == 1) {
            misMascotas[this.posicion] = new Mapache(4, 4, 3);
        } else if (noAnimalInvocado() == 2) {
            misMascotas[this.posicion] = new Jirafa(4, 4, 3);
        } else if (noAnimalInvocado() == 3) {
            misMascotas[this.posicion] = new Tortuga(4, 4, 3);
        } else if (noAnimalInvocado() == 4) {
            misMascotas[this.posicion] = new Caracol(4, 4, 3);
        } else if (noAnimalInvocado() == 5) {
            misMascotas[this.posicion] = new Oveja(4, 4, 3);
        } else if (noAnimalInvocado() == 6) {
            misMascotas[this.posicion] = new Conejo(4, 4, 3);
        } else if (noAnimalInvocado() == 7) {
            misMascotas[this.posicion] = new Buey(4, 4, 3);
        } else if (noAnimalInvocado() == 8) {
            misMascotas[this.posicion] = new Canguro(4, 4, 3);
        } else if (noAnimalInvocado() == 9) {
            misMascotas[this.posicion] = new Buho(4, 4, 3);
        }
    }

    public void animalInvocado3(Mascota[] misMascotas) {
        if (noAnimalInvocado() == 0) {
            misMascotas[this.posicion] = new Camello(2, 2, 3);
        } else if (noAnimalInvocado() == 1) {
            misMascotas[this.posicion] = new Mapache(2, 2, 3);
        } else if (noAnimalInvocado() == 2) {
            misMascotas[this.posicion] = new Jirafa(2, 2, 3);
        } else if (noAnimalInvocado() == 3) {
            misMascotas[this.posicion] = new Tortuga(2, 2, 3);
        } else if (noAnimalInvocado() == 4) {
            misMascotas[this.posicion] = new Caracol(2, 2, 3);
        } else if (noAnimalInvocado() == 5) {
            misMascotas[this.posicion] = new Oveja(2, 2, 3);
        } else if (noAnimalInvocado() == 6) {
            misMascotas[this.posicion] = new Conejo(2, 2, 3);
        } else if (noAnimalInvocado() == 8) {
            misMascotas[this.posicion] = new Buey(2, 2, 3);
        } else if (noAnimalInvocado() == 9) {
            misMascotas[this.posicion] = new Canguro(2, 2, 3);
        } else if (noAnimalInvocado() == 10) {
            misMascotas[this.posicion] = new Buho(2, 2, 3);
        }
    }

    public void receiveDamage(int damageCaused, Mascota misMascotas[]) {
        vidaEnPelea -= damageCaused;
        if (vidaEnPelea <= 0) {
            habilidad(misMascotas);

        }
    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Arania.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Arania.super.subirXp(fusion);
        }

    }
}
