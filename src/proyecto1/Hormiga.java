package proyecto1;

public class Hormiga extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Hormiga";

    public String getNombre() {
        return nombre;
    }

    public Hormiga(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Insecto";
        this.type[1] = "Terrestre";
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Hormiga hormiga = new Hormiga(2, 1, 1);
        misMascotas[posicion] = hormiga;

    }


    //definiendo a quien le dara su habilidad
    public void habilidad(Mascota misMascotas[]) {

        int animalesAtras = 4 - this.posicion;

        if (animalesAtras == 4) {
            int noAnimal = (int) (Math.random() * (4 - 1) + 1);
            giveAbility(noAnimal, misMascotas);
        } else if (animalesAtras == 3) {
            int noAnimal = (int) (Math.random() * (4 - 2) + 2);
            giveAbility(noAnimal, misMascotas);
        } else if (animalesAtras == 2) {
            int noAnimal = (int) (Math.random() * (4 - 3) + 3);
            giveAbility(noAnimal, misMascotas);
        } else if (animalesAtras == 1) {
            int noAnimal = 4;
            giveAbility(noAnimal, misMascotas);
        }

    }

    //definir lo que hara su habilidad
    public void giveAbility(int noAnimal, Mascota misMascotas[]) {
        if (this.level == 1) {
            int extraDamage = 2;
            int extraLife = 1;
            misMascotas[noAnimal].earnDamage(extraDamage);
            misMascotas[noAnimal].earnLife(extraLife);
        } else if (this.level == 2) {
            int extraDamage = 4;
            int extraLife = 2;
            misMascotas[noAnimal].earnDamage(extraDamage);
            misMascotas[noAnimal].earnLife(extraLife);
        } else if (this.level == 3) {
            int extraDamage = 6;
            int extraLife = 3;
            misMascotas[noAnimal].earnDamage(extraDamage);
            misMascotas[noAnimal].earnLife(extraLife);
        }
    }

    //fusionar animal
    public void fusion(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Hormiga.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Hormiga.super.subirXp(fusion);
        }

    }

    public void receiveDamage(int damageCaused, Mascota[] misMascotas) {
        vidaEnPelea -= damageCaused;
        if (vidaEnPelea <= 0) {
            habilidad(misMascotas);
        }
    }

}