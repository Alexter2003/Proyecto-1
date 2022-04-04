package proyecto1;

public class Sapo extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Sapo";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Acuatico";
        this.type[1] = "Terrestre";
    }

    public Sapo(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Sapo sapo = new Sapo(3, 3, 2);
        misMascotas[this.posicion] = sapo;
        habilidad(misMascotas);

    }

    //definir habilidad
    public void habilidad(Mascota misMascotas[]) {
        this.life = vidaMaxima(misMascotas);
    }

    //buscando la vida mas alta
    public int vidaMaxima(Mascota misMascotas[]) {
        int vidaMaxima = 0;
        for (int i = 0; i < misMascotas.length; i++) {
            if(misMascotas[i] != null) {
                if (misMascotas[i].getLife() > vidaMaxima) {
                    vidaMaxima = misMascotas[i].getLife();
                }
            }

        }
        return vidaMaxima;
    }


    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        boolean fusion;
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            fusion = true;
        } else {
            fusion = false;
        }
        Sapo.super.subirXp(fusion);

    }
    //recivir danio en pelea
    public void receiveDamage(int damageCaused) {
        vidaEnPelea -= damageCaused;
    }

}
