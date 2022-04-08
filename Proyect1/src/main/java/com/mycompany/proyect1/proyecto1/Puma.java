
package com.mycompany.proyect1.proyecto1;

public class Puma extends Mascota {    
    

    private String[] type = new String[2];
    protected String nombre="Puma";

    public String getNombre() {
        return nombre;
    }

    //definir el tipo de la mascota
    public void definirType() {
        this.type[0] = "Mamifero";
        this.type[1] = "Terrestre";
    }
    
    public Puma (int damage, int life, int tier) {
        this.life = life;
        this.damage = damage;
        this.tier = tier;    
}   
    public void habilidad(Mascota[] misMascotas){        
        giveAbility(misMascotas);
        
    }
    
      //definir posicion
    public void setPosicion(int posicion, Mascota misMascotas[]) {
        this.posicion = posicion;
        Puma puma = new Puma(3, 7, 4);
        misMascotas[this.posicion] = puma;
    }
    
    public int espacioLibre(Mascota [] misMascotas) {
        int espacioLibre = 0;
        for (int i = 0; i <= misMascotas.length; i++) {
            misMascotas[i] = null;
            espacioLibre += 1;
        }
        return espacioLibre;
    }
    
    public void moviendoAnimales1(Mascota misMascotas[]) {
        if (espacioLibre(misMascotas) >= 1) {
            for (int i = misMascotas.length; i <= 0; i--) {
                if (misMascotas[i] == null) {

                } else if (misMascotas[i] instanceof Mascota) {
                    misMascotas[i + 1] = misMascotas[i];
                }
            }
            giveAbility(misMascotas);
        }

    }
    
    public void giveAbility (Mascota misMascotas[]){
        if (this.level == 1){
            if (this.posicion < 4){
                if (this.vecesAtacar == 3){
                    Puma puma1 = new Puma(1,1,4);                    
                }
            }
        }else if (this.level == 2){
            if (this.posicion < 4){
                if (this.vecesAtacar == 2){
                    Puma puma1 = new Puma(1,1,4);
                   
                }
            }
        }else if (this.level == 3){
            if (this.posicion < 4){
                if (this.vecesAtacar == 1){
                    Puma puma1 = new Puma(1,1,4);
                    
                }
            }
    }
}
    //fusionar animal
    public void fusionar(Mascota misMascotas[], int animalAFusionar) {
        if (misMascotas[this.posicion] == misMascotas[animalAFusionar]) {
            boolean fusion = true;
            Puma.super.subirXp(fusion);
        } else {
            boolean fusion = false;
            Puma.super.subirXp(fusion);
        }
 }
}
