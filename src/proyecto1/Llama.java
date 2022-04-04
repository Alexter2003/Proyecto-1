package proyecto1;

public class Llama extends Mascota {
    private String type = "Terrestre";
    protected String nombre="Llama";

    public String getNombre() {
        return nombre;
    }

    public Llama(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota[] misMascotas) {
        this.posicion = posicion;
        Llama llama = new Llama(4, 6, 3);
        misMascotas[this.posicion] = llama;

    }

    //Habilidad
    public void habilidad(Mascota[] misMascotas) {
        extraDamageAndLife(misMascotas);
    }

    //definiendo la vida y el danio extra
    public void extraDamageAndLife(Mascota[] misMascotas) {
        if (cantidadAnimales(misMascotas)) {
            if (level == 1) {
                misMascotas[this.posicion].earnDamage(2);
                misMascotas[this.posicion].earnLife(2);
            } else if (level == 2) {
                misMascotas[this.posicion].earnDamage(4);
                misMascotas[this.posicion].earnLife(4);
            } else if (level == 3) {
                misMascotas[this.posicion].earnDamage(6);
                misMascotas[this.posicion].earnLife(6);

            }
        }
    }

    //Definiendo la cantidad de animales que hay
    public boolean cantidadAnimales(Mascota[] misMascotas) {
        int cantidad = 0;
        for (int i = 0; i < misMascotas.length; i++) {
            if (misMascotas[i] != null) {
                cantidad += 1;
            }
        }
        if (cantidad <= 4) {
            return true;
        } else {
            return false;
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
        Llama.super.subirXp(fusion);

    }

}
