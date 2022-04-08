package com.mycompany.proyect1.proyecto1;

public class PuercoEspin extends Mascota {

    private String[] type = new String[2];
    protected String nombre="Puerco Espin";

    public String getNombre() {
        return nombre;
    }
    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Solitario";
        this.type[1] = "Terrestre";
    }

    public PuercoEspin(int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;
    }

    //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        PuercoEspin puerdoEspin = new PuercoEspin(3, 2, 2);
        misMascotas[this.posicion] = puerdoEspin;
    }

    //definir habilidad
    public void habilidad(Mascota[] misMascotas){
        giveAbility(misMascotas);
    }

    //definiendo lo que hara su habilidad
    public int damageCaused(){
        if(level==1){
            return 2;
        }else if(level==2){
            return 4;
        }else {
            return 6;
        }
    }

    //definiendo a quien le dara su habilidad
    public void giveAbility(Mascota[] misMascotas){
        for(int i=this.posicion+1;i<=5;i++){
            misMascotas[i].damageCaused(damageCaused());
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
        PuercoEspin.super.subirXp(fusion);

    }
    public void receiveDamage(int damageCaused, Mascota misMascotas[]) {
        vidaEnPelea -= damageCaused;
        if(vidaEnPelea<=0){
            habilidad(misMascotas);
        }
    }
}
