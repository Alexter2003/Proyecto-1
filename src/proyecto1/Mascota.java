package proyecto1;

public abstract class Mascota implements Cloneable {

    protected int life;
    protected int damage;
    protected int xp = 0;
    protected int level = 1;
    protected int posicion;
    protected int tier;
    protected int vidaEnPelea = life;
    protected int danioEnPelea = damage;
    protected int vecesAtacar = 0;
    protected boolean muerto = false;
    protected boolean vendido = false;
    protected String efectoActivo = "Ninguno";
    protected String nombre;

    protected Mascota() {
    }


    public String getNombre() {
        return nombre;
    }

    public int getXP() {
        return this.xp;
    }

    public boolean getMuerto() {
        return this.muerto;
    }

    public int getVecesAtacar() {
        return this.vecesAtacar;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public void setEfectoActivo(String efectoActivo) {
        this.efectoActivo = efectoActivo;
    }

    public String getEfectoActivo() {
        return efectoActivo;
    }

    public int getPosicion() {

        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getLife() {

        return life;
    }

    public int getVidaEnPelea() {
        return this.vidaEnPelea;
    }

    public int getTier() {

        return tier;
    }

    public void efectoActivo(String fruta) {
        if (fruta.equals("Cebolla")) {
            this.efectoActivo = "Cebolla";
        } else if (fruta.equals("Melon")) {
            this.efectoActivo = "Melon";
        } else if (fruta.equals("Miel")) {
            this.efectoActivo = "Miel";
        } else if (fruta.equals("Hueso de carne")) {
            this.efectoActivo = "Hueso de carne";
        } else if (fruta.equals("Chile")) {
            this.efectoActivo = "Chile";
        }
    }


    public Mascota(int life, int damage) {
        this.life = life;
        this.damage = damage;
    }

    public void fusion() {

    }

    public void subirXp(boolean fusion) {
        if (!fusion) {
            System.out.println("No se puede fusionar");
        } else {
            xp += 1;
            this.life += 1;
            this.damage += 1;
        }
        //comprobando si subio de nivel
        if (xp == 2) {
            System.out.println("Mascota subio a nivel 2");
            level = 2;
        } else if (xp == 5) {
            System.out.println("Mascota subio a nivel 3");
            level = 3;
        }
    }

    public void subirXpPorChocolate(int extraXp) {
        this.xp += extraXp;
    }


    public void damageCaused(int damageCaused) {
        life -= damageCaused;
        if (life <= 0) {
            this.muerto = true;
        }


    }

    public void atacar(Mascota[] mascotasEnemigas) {
        if (mascotasEnemigas[0].getEfectoActivo().equals("Ajo")) {
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
        } else if (mascotasEnemigas[0].getEfectoActivo().equals("Miel")) {
            mascotasEnemigas[0].damageCaused(this.damage);
            if (mascotasEnemigas[0].getMuerto()) {
                mascotasEnemigas[0] = new Abeja(1, 1, 1);
            }
        }

    }

    public void earnDamage(int extraDamage) {
        this.damage += extraDamage;
    }

    public void earnDamageInBatle(int extraDamage) {
        danioEnPelea = +extraDamage;
    }

    public void earnLifeInBatle(int extraLife) {
        vidaEnPelea += extraLife;
    }

    public void earnLife(int extraLife) {
        this.life += extraLife;
    }

    @Override
    public Mascota clone() {
        try {
            return (Mascota) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
