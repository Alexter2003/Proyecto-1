package proyecto1;

public class EspacioDeBatalla extends ArenaMode {


    public int espacioLibre1(Mascota[] copia) {
        int espacioLibre1 = 0;
        for (int i = 0; i <= 4; i++) {
            if (copia[i] == null) {
                espacioLibre1 += 1;
            }
        }
        return espacioLibre1;
    }

    //[null][null][mascota][mascota][mascota]
    public void ordenarMascotas(Mascota[] copia) {
        if (espacioLibre1(copia) >= 1) {
            int espaciosNulos = 0;
            for (int i = 0; i <= 4; i++) {
                if (copia[i] == null) {
                    espaciosNulos += 1;
                } else {
                    copia[i - espaciosNulos] = copia[i];
                    if (espaciosNulos != 0) {
                        copia[i] = null;
                    }
                }
            }

        }

    }


    public void animalConHabilidad(Mascota[] copia, Mascota[] mascotasEnemigas) {
        for (int i = 0; i <= 4; i++) {
            if (copia[i] instanceof Mosquito) {
                ((Mosquito) copia[i]).habilidad(mascotasEnemigas);
            } else if (copia[i] instanceof Sapo) {
                ((Sapo) copia[i]).habilidad(copia);
            } else if (copia[i] instanceof Dodo) {
                ((Dodo) copia[i]).habilidad(copia);
            } else if (copia[i] instanceof Delfin) {
                ((Delfin) copia[i]).habilidad(mascotasEnemigas);
            }
        }

    }

    //[Sapo][M][M][M][M]     [null][Sapo][M][M][M]        [null][null][Sapo][M][M]
    public void pelea(Mascota[] copia, Mascota[] mascotasEnemigas, int rondas) {
        ordenarMascotas(copia);
        ordenarMascotas(mascotasEnemigas);
        animalConHabilidad(copia, mascotasEnemigas);
        animalConHabilidad(mascotasEnemigas, copia);
        while (copia[0] != null && mascotasEnemigas[0] != null) {
            if (copia[0] != null) {
                copia[0].atacar(mascotasEnemigas);
                if (copia[0] instanceof Grillo) {
                    if (copia[0].getLife() <= 0) {
                        ((Grillo) mascotasEnemigas[0]).habilidad(copia);
                    }
                }
            }
            if (mascotasEnemigas[0] != null) {
                mascotasEnemigas[0].atacar(copia);
                if (copia[0] instanceof Grillo) {
                    if (copia[0].getLife() <= 0) {
                        ((Grillo) copia[0]).habilidad(copia);
                    }
                }
            }
            if (copia[0].getMuerto()) {
                copia[0] = null;
                for (int i = 1; i <= 4; i++) {
                    copia[i - 1] = copia[i];
                    if (copia[i] == null) {
                        copia[i - 1] = null;
                    }
                    if (copia[4] != null) {
                        copia[4] = null;
                    }
                }
            }
            if (mascotasEnemigas[0].getMuerto()) {
                mascotasEnemigas[0] = null;
                for (int i = 1; i <= 4; i++) {
                    mascotasEnemigas[i - 1] = mascotasEnemigas[i];
                    if (mascotasEnemigas[i] == null) {
                        mascotasEnemigas[i - 1] = null;
                    }
                    if (mascotasEnemigas[4] != null) {
                        mascotasEnemigas[4] = null;
                    }
                }
            }
        }
        reporteBatalla(copia, mascotasEnemigas);

    }

    public int vidasPerdidas(Mascota[] copia, int rondas, boolean gano, Mascota[] mascotasEnemigas) {
        if (copia[0] == null && mascotasEnemigas[0] != null){
            if (rondas <= 3) {
                gano = false;
                return 1;
            } else if (rondas > 3 && rondas <= 6) {
                gano = false;
                return 2;

            } else {
                gano = false;
                return 3;

            }
        }else {
            return 0;
        }
    }

    public int victoriasGanadas(Mascota[] mascotasEnemigas, boolean gano, Mascota[] copia) {
        if (mascotasEnemigas[0] == null && copia[0]!= null) {
            return 1;
        } else {
            return 0;
        }
    }


    public void reporteBatalla(Mascota[] copia, Mascota[] mascotasEnemigas) {
        if (copia[0] == null && mascotasEnemigas[0] != null) {
            System.out.println("Perdiste");
            for (int i = 0; i <= 4; i++) {
                if (mascotasEnemigas[i] != null) {
                    System.out.println("Mascota viva: " + mascotasEnemigas[i].getNombre());
                    System.out.println("Con " + mascotasEnemigas[i].getLife() + " de vida");
                }
            }
        } else if (mascotasEnemigas[0] == null && copia[0]!=null) {
            System.out.println("Ganaste");
            for (int i = 0; i <= 4; i++) {
                if (copia[i] != null) {
                    System.out.println("Mascota viva: " + copia[i].getNombre());
                    System.out.println("Con " + copia[i].getLife() + " de vida");

                }
            }
        }
        if (copia[0] == null && mascotasEnemigas[0] == null) {
            System.out.println("Empate");

        }

    }

}
