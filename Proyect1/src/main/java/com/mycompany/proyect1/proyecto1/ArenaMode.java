package com.mycompany.proyect1.proyecto1;

public class ArenaMode {

    protected int victorias = 0;
    protected int vidas = 10;

    public void perderVidas(int cantidadVidas){
        this.vidas-=cantidadVidas;
    }

    public void ganarVictorias(int cantidadVictorias){
        this.victorias+=cantidadVictorias;
    }


    public void juego() {
        boolean gano = true;
        int rondas = 1;
        IA ia = new IA();
        Mascota[] misMascotas = new Mascota[5];
        Mascota[] mascotasEnemigas = new Mascota[5];
        EntreBatallas entreBatallas = new EntreBatallas();
        EspacioDeBatalla espacioDeBatallas = new EspacioDeBatalla();
        Mascota[] copia = new Mascota[5];
        while (victorias <= 10 && vidas > 0) {
            ia.generadorDeAnimales(rondas, mascotasEnemigas);
            entreBatallas.menuDeCompra(misMascotas,rondas,gano,this.vidas, this.victorias);
            cloner(copia,misMascotas);
            espacioDeBatallas.pelea(copia,mascotasEnemigas,rondas);
            if(copia[0]==null) {
                perderVidas(espacioDeBatallas.vidasPerdidas(copia, rondas,gano,mascotasEnemigas));
            }else {
                ganarVictorias(espacioDeBatallas.victoriasGanadas(mascotasEnemigas, gano, copia));
            }
            rondas+=1;
        }
        if(victorias>=10){
            System.out.println("Felicidades haz ganado");
        }else if(vidas<=0){
            System.out.println("Ha perdido, mejor suerte para la proxima");
        }
    }

    public void cloner(Mascota[] misMascotasCopia,  Mascota[] misMascotas) {
        for (int i = 0; i <= 4; i++) {
            if(misMascotas[i]!=null) {
                misMascotasCopia[i] = misMascotas[i].clone();
            }
        }
    }


}
