package proyecto1;

public class DirtyRats extends Mascota{

    public DirtyRats (int life, int damage, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        misMascotas[this.posicion] = new DirtyRats(1, 1, 1);

    }
    public void receiveDamage(int damageCaused) {
        vidaEnPelea -= damageCaused;
    }
}
