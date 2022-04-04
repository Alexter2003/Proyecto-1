
package proyecto1;


public class Carnero extends Mascota {
    
    
     public Carnero (int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }
    
    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Carnero carnero = new Carnero(2, 2, 3);
        misMascotas[this.posicion] = carnero;

    }
}


