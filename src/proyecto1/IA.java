package proyecto1;

public class IA {

     //
    public void generadorDeAnimales(int ronda, Mascota[] mascotasEnemigas) {
        if (ronda == 1) {
            for (int i = 0; i <= 2; i++) {
                generarAnimales1(animalesAleatorios1(), mascotasEnemigas, i);
            }

        } else if (ronda == 2 || ronda == 3) {
            for (int i = 0; i <= 4; i++) {
                int tierAleatorio;
                tierAleatorio = (int) (Math.random() * (2 - 1) + 1);
                if (tierAleatorio == 1) {
                    generarAnimales1(animalesAleatorios1(), mascotasEnemigas, i);
                } else {
                    generarAnimales2(animalesAleatorios2(), mascotasEnemigas, i);
                }
            }

        } else if (ronda >= 4 && ronda < 6) {
            for (int i = 0; i <= 4; i++) {
                int tierAleatorio;
                tierAleatorio = (int) (Math.random() * (3 - 1) + 1);
                if (tierAleatorio == 1) {
                    generarAnimales1(animalesAleatorios1(), mascotasEnemigas, i);
                } else if (tierAleatorio == 2) {
                    generarAnimales2(animalesAleatorios2(), mascotasEnemigas, i);
                } else {
                    generarAnimales3(animalesAleatorios3(), mascotasEnemigas, i);
                }
            }
        } else {
            for (int i = 0; i <= 4; i++) {
                int tierAleatorio;
                tierAleatorio = (int) (Math.random() * (4 - 1) + 1);
                if (tierAleatorio == 1) {
                    generarAnimales1(animalesAleatorios1(), mascotasEnemigas, i);
                } else if (tierAleatorio == 2) {
                    generarAnimales2(animalesAleatorios2(), mascotasEnemigas, i);
                } else if (tierAleatorio == 3) {
                    generarAnimales3(animalesAleatorios3(), mascotasEnemigas, i);
                } else{
                    generarAnimales4(animalesAleatorios4(), mascotasEnemigas, i);
                }
            }
        }

    }

    public int animalesAleatorios1() {
        int noAnimal;
        noAnimal = (int) (Math.random() * (7 - 1) + 1);
        return noAnimal;
    }

    public void generarAnimales1(int noAnimal, Mascota[] mascotasEnemigas, int posicion) {
        if (noAnimal == 1) {
            mascotasEnemigas[posicion] = new Hormiga(2, 1, 1);
        } else if (noAnimal == 2) {
            mascotasEnemigas[posicion] = new Pescado(2, 3, 1);
        } else if (noAnimal == 3) {
            mascotasEnemigas[posicion] = new Mosquito(2, 2, 1);
        } else if (noAnimal == 4) {
            mascotasEnemigas[posicion] = new Grillo(1, 2, 1);
        } else if (noAnimal == 5) {
            mascotasEnemigas[posicion] = new Castor(2, 2, 1);
        } else if (noAnimal == 6) {
            mascotasEnemigas[posicion] = new Caballo(2, 1, 1);
        } else if (noAnimal == 7) {
            mascotasEnemigas[posicion] = new Nutria(1, 2, 1);
            ((Nutria) mascotasEnemigas[posicion]).habilidad(mascotasEnemigas);
        }
    }

    public int animalesAleatorios2() {
        int noAnimal;
        noAnimal = (int) (Math.random() * (16 - 9) + 9);
        return noAnimal;
    }

    public void generarAnimales2(int noAnimal, Mascota[] mascotasEnemigas, int posicion) {
        if (noAnimal == 9) {
            mascotasEnemigas[posicion] = new Sapo(3, 3, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
            ((Sapo) mascotasEnemigas[posicion]).habilidad(mascotasEnemigas);
        } else if (noAnimal == 10) {
            mascotasEnemigas[posicion] = new Dodo(2, 3, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 11) {
            mascotasEnemigas[posicion] = new Elefante(3, 5, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 12) {
            mascotasEnemigas[posicion] = new PuercoEspin(3, 2, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 13) {
            mascotasEnemigas[posicion] = new Pavoreal(2, 5, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 14) {
            mascotasEnemigas[posicion] = new Rata(4, 5, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 15) {
            mascotasEnemigas[posicion] = new Zorro(5, 2, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 16) {
            mascotasEnemigas[posicion] = new Arania(2, 2, 2);
            mascotasEnemigas[posicion].setPosicion(posicion);
        }
    }

    public int animalesAleatorios3() {
        int noAnimal;
        noAnimal = (int) (Math.random() * (26 - 17) + 17);
        return noAnimal;
    }

    public void generarAnimales3(int noAnimal, Mascota[] mascotasEnemigas, int posicion) {
        if (noAnimal == 17) {
            mascotasEnemigas[posicion] = new Camello(2, 5, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 18) {
            mascotasEnemigas[posicion] = new Mapache(5, 4, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 19) {
            mascotasEnemigas[posicion] = new Jirafa(2, 5, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 20) {
            mascotasEnemigas[posicion] = new Tortuga(1, 2, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 21) {
            mascotasEnemigas[posicion] = new Caracol(2, 2, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
            boolean gano = false;
            ((Caracol) mascotasEnemigas[posicion]).habilidad(mascotasEnemigas, gano);
        } else if (noAnimal == 22) {
            mascotasEnemigas[posicion] = new Oveja(2, 2, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 23) {
            mascotasEnemigas[posicion] = new Conejo(3, 2, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 24) {
            mascotasEnemigas[posicion] = new Buey(1, 4, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 25) {
            mascotasEnemigas[posicion] = new Canguro(1, 2, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 26) {
            mascotasEnemigas[posicion] = new Buho(5, 3, 3);
            mascotasEnemigas[posicion].setPosicion(posicion);
        }
    }

    public int animalesAleatorios4() {
        int noAnimal;
        noAnimal = (int) (Math.random() * (31 - 27) + 27);
        return noAnimal;
    }

    public void generarAnimales4(int noAnimal, Mascota[] mascotasEnemigas, int posicion) {
        if (noAnimal == 27) {
            mascotasEnemigas[posicion] = new Venado(1, 1, 4);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 28) {
            mascotasEnemigas[posicion] = new Hipopotamo(4, 7, 4);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 29) {
            mascotasEnemigas[posicion] = new Delfin(4, 6, 4);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 30) {
            mascotasEnemigas[posicion] = new Puma(3, 7, 4);
            mascotasEnemigas[posicion].setPosicion(posicion);
        } else if (noAnimal == 31) {
            mascotasEnemigas[posicion] = new Llama(3, 6, 4);
            mascotasEnemigas[posicion].setPosicion(posicion);
            ((Llama) mascotasEnemigas[posicion]).habilidad(mascotasEnemigas);
        }
    }
}
