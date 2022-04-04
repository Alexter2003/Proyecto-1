
package proyecto1;

public class Hipopotamo extends Mascota {


    private String[] type = new String[2];
    protected String nombre="Hipopotamo";

    public String getNombre() {
        return nombre;
    }
    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Acuatico";
        this.type[1] = "Terrestre";
    }

    public Hipopotamo(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Hipopotamo hipopotamo = new Hipopotamo(4, 7, 4);
        misMascotas[this.posicion] = hipopotamo;
    }

    public void habilidad(Mascota[] misMascotas) {
        giveAbility(misMascotas);

    }

    public void giveAbility(Mascota[] misMascotas) {
        if (level == 1) {
            int extraDamage = 2;
            int extraLife = 2;
            misMascotas[this.posicion].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion].earnLifeInBatle(extraLife);
        } else if (level == 2) {
            int extraDamage = 4;
            int extraLife = 4;
            misMascotas[this.posicion].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion].earnLifeInBatle(extraLife);
        } else if (level == 3) {
            int extraDamage = 6;
            int extraLife = 6;
            misMascotas[this.posicion].earnDamageInBatle(extraDamage);
            misMascotas[this.posicion].earnLifeInBatle(extraLife);
        }
    }

    public void atacar(Mascota[] mascotasEnemigas, Mascota[] misMascotas) {
        if (mascotasEnemigas[0].getEfectoActivo().equals("Cebolla")) {
            this.damage = this.damage - 2;
            mascotasEnemigas[0].damageCaused(this.damage);
            vecesAtacar += 1;
        } else if (mascotasEnemigas[0].getEfectoActivo().equals("Melon")) {
            this.damage = 0;
            mascotasEnemigas[0].damageCaused(this.damage);
            vecesAtacar += 1;
            mascotasEnemigas[0].setEfectoActivo("Ninguno");
        } else if (mascotasEnemigas[0].getEfectoActivo().equals("Ninguno")) {
            mascotasEnemigas[0].damageCaused(this.damage);
            vecesAtacar += 1;
        }
        habilidad(misMascotas);

    }

    //fusionar animal
    public void fusionar(Mascota[] misMascotas, int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Hipopotamo.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Hipopotamo.super.subirXp(fusion);
        }
    }
}
