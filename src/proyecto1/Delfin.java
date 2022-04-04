package proyecto1;

public class Delfin extends Mascota {
    private String type = "Acuatico";
    protected String nombre="Delfin";

    public String getNombre() {
        return nombre;
    }

    public Delfin(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota[] misMascotas) {
        this.posicion = posicion;
        Delfin delfin = new Delfin(4, 6, 3);
        misMascotas[this.posicion] = delfin;

    }

    //definir habilidad
    public void habilidad(Mascota[] mascotasEnemigas) {
        giveAbility(mascotasEnemigas);
    }

    //buscando quien tiene la vida mas baja
    public int vidaMinima(Mascota[] mascotasEnemigas) {
        int vidaMinima = 100;
        int noAnimal = 0;
        for (int i = 0; i < mascotasEnemigas.length; i++) {
            if (mascotasEnemigas[i] != null) {
                if (mascotasEnemigas[i].getLife() < vidaMinima) {
                    noAnimal = i;
                }
            }

        }
        return noAnimal;
    }

    //definir lo que hara su habilidad
    public void giveAbility(Mascota[] mascotasEnemigas) {
        if (this.level == 1) {
            int Damage = 5;
            mascotasEnemigas[vidaMinima(mascotasEnemigas)].damageCaused(Damage);
        } else if (this.level == 2) {
            int Damage = 10;
            mascotasEnemigas[vidaMinima(mascotasEnemigas)].damageCaused(Damage);
        } else if (this.level == 3) {
            int Damage = 15;
            mascotasEnemigas[vidaMinima(mascotasEnemigas)].damageCaused(Damage);
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
        Delfin.super.subirXp(fusion);

    }
}
