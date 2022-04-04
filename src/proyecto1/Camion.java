
package proyecto1;

/**
 * @author macbookpro
 */
public class Camion extends Mascota {
    public Camion(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Camion camion = new Camion(5, 5, 4);
        misMascotas[this.posicion] = camion;
    }

    public void atacar(Mascota[] mascotasEnemigas) {
        if (mascotasEnemigas[0].getEfectoActivo().equals("Cebolla")) {
            this.damage = this.damage - 2;
            mascotasEnemigas[0].damageCaused(this.damage);
            mascotasEnemigas[1].damageCaused(this.damage);
            vecesAtacar += 1;
        } else if (mascotasEnemigas[0].getEfectoActivo().equals("Melon")) {
            this.damage = 0;
            mascotasEnemigas[0].damageCaused(this.damage);
            mascotasEnemigas[1].damageCaused(this.damage);
            vecesAtacar += 1;
            mascotasEnemigas[0].setEfectoActivo("Ninguno");
        } else if (mascotasEnemigas[0].getEfectoActivo().equals("Ninguno")) {
            mascotasEnemigas[0].damageCaused(this.damage);
            mascotasEnemigas[1].damageCaused(this.damage);
            vecesAtacar += 1;
        }

    }

}
