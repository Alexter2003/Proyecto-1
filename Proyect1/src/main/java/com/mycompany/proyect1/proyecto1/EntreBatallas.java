package com.mycompany.proyect1.proyecto1;

import java.util.Scanner;

public class EntreBatallas extends ArenaMode {
    protected int tier;
    protected int oro;
    int vecesMostrado = 0;
    int vecesMostradoComida = 0;

    public void menuDeCompra(Mascota[] misMascotas, int rondas, boolean gano, int vidas, int victorias) {
        int opcion = 0;
        oro = 10;
        vecesMostrado = 0;
        vecesMostradoComida = 0;
        while (opcion != 5) {
            System.out.println("\nBienvenido\n");
            System.out.println("Tienes " + oro + " de oro");
            System.out.println("Tienes " + vidas + " vidas");
            System.out.println("Tienes " + victorias + " victorias\n");
            System.out.println("Que deseas hacer?");
            System.out.println("0. Ver a mis mascotas");
            System.out.println("1. Comprar Mascotas");
            System.out.println("2. Comprar Comida");
            System.out.println("3. Ordenar Mascotas");
            System.out.println("4. Vender Mascotas");
            System.out.println("5. Finalizar Compra y entrar en batalla");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.nextInt();
            if (opcion == 5) {
                break;
            }
            selecAction(opcion, misMascotas, rondas, gano);
        }
    }

    // encargado de ver que eleccion se eligio y llamarlas
    public void selecAction(int opcion, Mascota[] misMascotas, int rondas, boolean gano) {

        if (opcion == 0) {
            verMascotas(misMascotas);
        } else if (opcion == 1) {
            comprarMascotas(misMascotas, rondas, gano);
        } else if (opcion == 2) {
            compraComida(misMascotas, rondas);
        } else if (opcion == 3) {
            ordenarMascotas(misMascotas);
        } else if (opcion == 4) {
            venderMascotas(misMascotas);
        }

    }

    //este sera el encargado de comprar las mascotas
    //En el generara cierta cantidad de mascotas dependiendo la ronda
    //Y te dara la opcion de comprar o salir del menu de compra
    public void comprarMascotas(Mascota[] misMascotas, int rondas, boolean gano) {
        if (rondas == 1) {
            if (this.vecesMostrado == 0) {
                for (int i = 0; i <= 2; i++) {
                    mostrandoAnimalesTier1(generarOpcionAnimalesTier1());
                }
                this.vecesMostrado = this.vecesMostrado + 1;
            } else {
                System.out.println("Ya se mostradon los 3 animales que puedes comprar");
            }
            comprarAnimal(misMascotas);

        } else if (rondas >= 2 && rondas <= 3) {
            if (this.vecesMostrado == 0) {
                for (int i = 0; i <= 2; i++) {
                    int tierAleatorio = (int) (Math.random() * (2 - 1) + 1);
                    if (tierAleatorio == 1) {
                        mostrandoAnimalesTier1(generarOpcionAnimalesTier1());
                    } else if (tierAleatorio == 2) {
                        mostrandoAnimalesTier2(generarOpcionAnimalesTier2());
                    }
                }
                this.vecesMostrado = this.vecesMostrado + 1;
            } else {
                System.out.println("Ya se mostradon los 3 animales que puedes comprar");
            }
            comprarAnimal(misMascotas);
        } else if (rondas >= 4 && rondas < 6) {
            if (this.vecesMostrado == 0) {
                for (int i = 0; i <= 3; i++) {
                    int tierAleatorio = (int) (Math.random() * (3 - 1) + 1);
                    if (tierAleatorio == 1) {
                        mostrandoAnimalesTier1(generarOpcionAnimalesTier1());
                    } else if (tierAleatorio == 2) {
                        mostrandoAnimalesTier2(generarOpcionAnimalesTier2());
                    } else if (tierAleatorio == 3) {
                        mostrandoAnimalestIer3(generarOpcionAnimalesTier3());
                    }
                }
                this.vecesMostrado = this.vecesMostrado + 1;
            } else {
                System.out.println("Ya se mostradon los 3 animales que puedes comprar");
            }
            comprarAnimal(misMascotas);
        } else if (rondas >= 6) {
            if (this.vecesMostrado == 0) {
                for (int i = 0; i <= 3; i++) {
                    int tierAleatorio = (int) (Math.random() * (4 - 1) + 1);
                    if (tierAleatorio == 1) {
                        mostrandoAnimalesTier1(generarOpcionAnimalesTier1());
                    } else if (tierAleatorio == 2) {
                        mostrandoAnimalesTier2(generarOpcionAnimalesTier2());
                    } else if (tierAleatorio == 3) {
                        mostrandoAnimalestIer3(generarOpcionAnimalesTier3());
                    } else if (tierAleatorio == 4) {
                        mostrandoAnimalestIer4(generarOpcionAnimalesTier4());
                    }
                }
                this.vecesMostrado = this.vecesMostrado + 1;
            } else {
                System.out.println("Ya se mostradon los 3 animales que puedes comprar");
            }
            comprarAnimal(misMascotas);
        }
    }

    public void comprarAnimal(Mascota[] misMascotas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el numero del animal que desea comprar");
        int noAnimal = scanner.nextInt();
        if (oro >= 3) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite la posicion para poner al animal");
            int posicion = scan.nextInt();
            if (posicion <= 4 && posicion >= 0) {
                if (misMascotas[posicion] == null) {
                    comprarAnimalSeleccionado(posicion, misMascotas, noAnimal);
                    oro -= 3;
                    for (int i = 0; i <= 4; i++) {
                        if (misMascotas[i] instanceof Caballo) {
                            ((Caballo) misMascotas[i]).habilidad(misMascotas, posicion);
                            System.out.println("Caballo activo su habilidad");
                        }
                    }
                } else {
                    System.out.println("Ya hay una animal en esta posicion. Si lo que quieres es fucionarlos ve a la parte \" Ordenar Mascotas \"");
                }

            } else {
                System.out.println("La posicion tiene que estar entre 0 y  4");
            }
        } else {
            System.out.println("No tienes el oro suficiente");
        }
    }

    public void comprarAnimalSeleccionado(int posicion, Mascota[] misMascotas, int noAnimal) {
        switch (noAnimal) {
            case 1:
                misMascotas[posicion] = new Hormiga(2, 1, 1);
                break;
            case 2:
                misMascotas[posicion] = new Pescado(2, 3, 1);
                break;
            case 3:
                misMascotas[posicion] = new Mosquito(2, 3, 1);
                break;
            case 4:
                misMascotas[posicion] = new Grillo(1, 2, 1);
                break;
            case 5:
                misMascotas[posicion] = new Castor(2, 2, 1);
                break;
            case 6:
                misMascotas[posicion] = new Caballo(2, 1, 1);
                break;
            case 7:
                misMascotas[posicion] = new Nutria(1, 2, 1);
                System.out.println("Nutria activo su habilidad");
                break;
            case 8:
                misMascotas[posicion] = new Sapo(3, 3, 2);
                System.out.println("Sapo activo su habilidad");
                break;
            case 9:
                misMascotas[posicion] = new Dodo(2, 3, 2);
                break;
            case 10:
                misMascotas[posicion] = new Elefante(3, 5, 2);
                break;
            case 11:
                misMascotas[posicion] = new PuercoEspin(3, 2, 2);
                break;
            case 12:
                misMascotas[posicion] = new Pavoreal(2, 5, 2);
                break;
            case 13:
                misMascotas[posicion] = new Rata(4, 5, 2);
                break;
            case 14:
                misMascotas[posicion] = new Zorro(5, 2, 2);
                break;
            case 15:
                misMascotas[posicion] = new Arania(2, 2, 2);
                break;
            case 16:
                misMascotas[posicion] = new Camello(2, 5, 3);
                break;
            case 17:
                misMascotas[posicion] = new Mapache(5, 4, 3);
                break;
            case 18:
                misMascotas[posicion] = new Jirafa(2, 5, 3);
                break;
            case 19:
                misMascotas[posicion] = new Tortuga(1, 2, 3);
                break;
            case 20:
                misMascotas[posicion] = new Caracol(2, 2, 3);
                break;
            case 21:
                misMascotas[posicion] = new Oveja(2, 2, 3);
                break;
            case 22:
                misMascotas[posicion] = new Conejo(3, 2, 3);
                break;
            case 23:
                misMascotas[posicion] = new Buey(1, 4, 3);
                break;
            case 24:
                misMascotas[posicion] = new Canguro(1, 2, 3);
                break;
            case 25:
                misMascotas[posicion] = new Buho(5, 3, 3);
                break;
            case 26:
                misMascotas[posicion] = new Venado(1, 1, 4);
                break;
            case 27:
                misMascotas[posicion] = new Hipopotamo(4, 7, 4);
                break;
            case 28:
                misMascotas[posicion] = new Delfin(4, 6, 4);
                break;
            case 29:
                misMascotas[posicion] = new Puma(3, 7, 4);
                break;
            case 30:
                misMascotas[posicion] = new Llama(3, 6, 4);
                break;
        }
    }

    //encargado de generar aleatoriamente numeros para usar de referencia a que animal comprar de tier 1
    public int generarOpcionAnimalesTier1() {
        int animalGenerado;
        animalGenerado = (int) (Math.random() * (7 - 1) + 1);
        return animalGenerado;
    }

    //Este sera el encargado de mostrar las opciones(dependiendo  generarOpcionAnimales()) de animales de tier 1
    public void mostrandoAnimalesTier1(int noAnimal) {
        if (noAnimal == 1) {
            System.out.println("1. Hormiga");
        } else if (noAnimal == 2) {
            System.out.println("2. Pescado");
        } else if (noAnimal == 3) {
            System.out.println("3. Mosquito");
        } else if (noAnimal == 4) {
            System.out.println("4. Grillo");
        } else if (noAnimal == 5) {
            System.out.println("5. Castor");
        } else if (noAnimal == 6) {
            System.out.println("6. Caballo");
        } else if (noAnimal == 7) {
            System.out.println("7. Nutria");
        }
    }

    //encargado de generar aleatoriamente numeros para usar de referencia a que animal comprar de tier 2
    public int generarOpcionAnimalesTier2() {
        int animalGenerado;
        animalGenerado = (int) (Math.random() * (16 - 9) + 9);
        return animalGenerado;
    }

    ////Este sera el encargado de mostrar las opciones(dependiendo  generarOpcionAnimales()) de animales de tier 2
    public void mostrandoAnimalesTier2(int noAnimal) {
        if (noAnimal == 8) {
            System.out.println("8. Sapo");
        } else if (noAnimal == 9) {
            System.out.println("9. Dodo");
        } else if (noAnimal == 10) {
            System.out.println("10. Elefante");
        } else if (noAnimal == 11) {
            System.out.println("11. Puero Espin");
        } else if (noAnimal == 12) {
            System.out.println("12. Pavo Real");
        } else if (noAnimal == 13) {
            System.out.println("13. Rata");
        } else if (noAnimal == 14) {
            System.out.println("14. Zorro");
        } else if (noAnimal == 15) {
            System.out.println("15. Araña");
        }
    }

    //encargado de generar aleatoriamente numeros para usar de referencia a que animal comprar de tier 3
    public int generarOpcionAnimalesTier3() {
        int animalGenerado;
        animalGenerado = (int) (Math.random() * (26 - 17) + 17);
        return animalGenerado;
    }

    //Este sera el encargado de mostrar las opciones(dependiendo  generarOpcionAnimales()) de animales de tier 3
    public void mostrandoAnimalestIer3(int noAnimal) {
        if (noAnimal == 16) {
            System.out.println("16. Camello");
        } else if (noAnimal == 17) {
            System.out.println("17. Mapache");
        } else if (noAnimal == 18) {
            System.out.println("18. Jirafa");
        } else if (noAnimal == 19) {
            System.out.println("19. Tortuga");
        } else if (noAnimal == 20) {
            System.out.println("20. Caracol");
        } else if (noAnimal == 21) {
            System.out.println("21. Oveja");
        } else if (noAnimal == 22) {
            System.out.println("22. Conejo");
        } else if (noAnimal == 23) {
            System.out.println("23. Buey");
        } else if (noAnimal == 24) {
            System.out.println("24. Canguro");
        } else if (noAnimal == 25) {
            System.out.println("25. Buho");
        }

    }

    //encargado de generar aleatoriamente numeros para usar de referencia a que animal comprar de tier 1
    public int generarOpcionAnimalesTier4() {
        int animalGenerado;
        animalGenerado = (int) (Math.random() * (31 - 27) + 27);
        return animalGenerado;
    }

    //Este sera el encargado de mostrar las opciones(dependiendo  generarOpcionAnimales()) de animales de tier 3
    public void mostrandoAnimalestIer4(int noAnimal) {
        if (noAnimal == 26) {
            System.out.println("26. Venado");
        } else if (noAnimal == 27) {
            System.out.println("27. Hipopotamo");
        } else if (noAnimal == 28) {
            System.out.println("28. Delfin");
        } else if (noAnimal == 29) {
            System.out.println("29. Puma");
        } else if (noAnimal == 30) {
            System.out.println("30. Llama");
        }
    }

    //este sera el encargado de comprar comidas
    public void compraComida(Mascota[] misMascotas, int rondas) {
        if (rondas == 1) {
            if (this.vecesMostradoComida == 0) {
                for (int i = 0; i < 2; i++) {
                    mostrandComidaTier1(alimentosAleatoriosTier1());
                }
                this.vecesMostradoComida = this.vecesMostradoComida + 1;
            } else {
                System.out.println("Ya se mostraron las comidas que puede comprar\n");
            }
            comprandoComida(misMascotas);

        } else if (rondas == 2 || rondas == 3) {
            if (this.vecesMostradoComida == 0) {
                for (int i = 0; i < 2; i++) {
                    int tierAleatorio = (int) (Math.random() * (2 - 1) + 1);
                    if (tierAleatorio == 1) {
                        mostrandComidaTier1(alimentosAleatoriosTier1());
                    } else if (tierAleatorio == 2) {
                        mostrandComidaTier2(alimentosAleatoriosTier2());
                    }
                }
                this.vecesMostradoComida = this.vecesMostradoComida + 1;
            } else {
                System.out.println("Ya se mostraron las comidas que puede comprar\n");
            }
            comprandoComida(misMascotas);

        } else if (rondas >= 4 && rondas < 6) {
            if (this.vecesMostradoComida == 0) {
                for (int i = 0; i < 2; i++) {
                    int tierAleatorio = (int) (Math.random() * (3 - 1) + 1);
                    if (tierAleatorio == 1) {
                        mostrandComidaTier1(alimentosAleatoriosTier1());
                    } else if (tierAleatorio == 2) {
                        mostrandComidaTier2(alimentosAleatoriosTier2());
                    } else if (tierAleatorio == 3) {
                        mostrandComidaTier3(alimentosAleatoriosTier3());
                    }
                }
                this.vecesMostradoComida = this.vecesMostradoComida + 1;
            }else {
                System.out.println("Ya se mostraron las comidas que puede comprar\n");
            }
            comprandoComida(misMascotas);

        } else if (rondas >= 6) {
            if (this.vecesMostradoComida == 0) {
                for (int i = 0; i < 2; i++) {
                    int tierAleatorio = (int) (Math.random() * (4 - 1) + 1);
                    if (tierAleatorio == 1) {
                        mostrandComidaTier1(alimentosAleatoriosTier1());
                    } else if (tierAleatorio == 2) {
                        mostrandComidaTier2(alimentosAleatoriosTier2());
                    } else if (tierAleatorio == 3) {
                        mostrandComidaTier3(alimentosAleatoriosTier3());
                    } else if (tierAleatorio == 4) {
                        mostrandComidaTier4(alimentosAleatoriosTier4());
                    }
                }
                this.vecesMostradoComida = this.vecesMostradoComida + 1;
            } else {
                System.out.println("Ya se mostraron las comidas que puede comprar\n");
            }
            comprandoComida(misMascotas);
        }
    }

    public void comprandoComida(Mascota[] misMascotas) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite el numero de la comida que quiere comprar");
        int noComida = scan.nextInt();

        if (oro >= 3) {
            Scanner scannner = new Scanner(System.in);
            System.out.println("Digite la posicion del animal para darle comida");
            int posicion = scannner.nextInt();
            if (posicion <= 4 && posicion >= 0) {
                if (misMascotas[posicion] != null) {
                    comprarComidaSeleccionada(misMascotas, noComida, posicion);
                    oro -= 3;
                } else {
                    System.out.println("Ya hay una animal en esta posicion. Si lo que quieres es fucionarlos ve a la parte \" Ordenar Mascotas \"");
                }

            } else {
                System.out.println("La posicion tiene que estar entre 0 y  4");
            }
        } else {
            System.out.println("No tienes el oro suficiente");
        }
    }

    public void comprarComidaSeleccionada(Mascota[] misMascotas, int noComida, int posicion) {
        switch (noComida) {
            case 1:
                misMascotas[posicion].earnLife(1);
                misMascotas[posicion].earnDamage(1);
                break;
            case 2:
                System.out.println("Animal ahora tiene efecto de Miel");
                misMascotas[posicion].efectoActivo("Miel");
                break;
            case 3:
                System.out.println("Animal ahora tiene efecto de Pastelito");
                misMascotas[posicion].efectoActivo("Pastelito");
                misMascotas[posicion].earnLifeInBatle(3);
                misMascotas[posicion].earnDamageInBatle(3);
                break;
            case 4:
                System.out.println("Animal ahora tiene efecto de carne");
                misMascotas[posicion].efectoActivo("Hueso de carne");
                misMascotas[posicion].earnDamage(5);
                break;
            case 5:
                System.out.println("Animal ahora tiene efecto de Ajo");
                misMascotas[posicion].efectoActivo("Ajo");
                break;
            case 6:
                darEnsalada(misMascotas);
                break;
            case 7:
                misMascotas[posicion].earnDamage(2);
                misMascotas[posicion].earnLife(2);
                break;
            case 8:
                System.out.println("Animal ahora tiene efecto de Chile");
                misMascotas[posicion].efectoActivo("Chile");
                misMascotas[posicion].earnDamageInBatle(5);
                break;
            case 9:
                misMascotas[posicion].subirXpPorChocolate(1);
                break;
            case 10:
                darSushi(misMascotas);
                break;

        }
    }

    //comprobando que hay un animal en la posicion que digito
    public void noHayAnimal(int opcionAnimal, Mascota[] misMascotas) {
        if (misMascotas[opcionAnimal] == null) {
            System.out.println("No hay un animal en esta posicion");
        }
    }

    //Encargados de generar, mostrar y pode comprar comida de tier 1
    public int alimentosAleatoriosTier1() {
        int comidaGenerada;
        comidaGenerada = (int) (Math.random() * (3 - 1) + 1);
        return comidaGenerada;
    }

    public void mostrandComidaTier1(int noComida) {
        if (noComida == 1) {
            System.out.println("1. Manzana");
        } else if (noComida == 2) {
            System.out.println("2. Naranja");
        }
    }

    //Encargados de generar, mostrar y poder comprar comida de tier 2
    public int alimentosAleatoriosTier2() {
        int comidaGenerada;
        comidaGenerada = (int) (Math.random() * (4 - 3) + 3);
        return comidaGenerada;
    }

    public void mostrandComidaTier2(int noComida) {
        if (noComida == 1) {
            System.out.println("3. Pastelito");
        } else if (noComida == 2) {
            System.out.println("4. Hueso de carne");
        }
    }

    //Encargados de generar, mostrar y poder comprar comida de tier 3
    public int alimentosAleatoriosTier3() {
        int comidaGenerada;
        comidaGenerada = (int) (Math.random() * (7 - 5) + 5);
        return comidaGenerada;
    }

    public void mostrandComidaTier3(int noComida) {
        if (noComida == 1) {
            System.out.println("5. Ajo");
        } else if (noComida == 2) {
            System.out.println("6. Ensalada");
        } else if (noComida == 3) {
            System.out.println("7. Pera");
        }
    }

    public void darEnsalada(Mascota[] misMascotas) {
        int animal1 = (int) (Math.random() * (4 - 0) + 0);
        int animal2 = (int) (Math.random() * (4 - 0) + 0);

        if (misMascotas[animal1] != null) {
            misMascotas[animal1].earnDamage(1);
            misMascotas[animal1].earnLife(1);
        }
        if (misMascotas[animal1] != null) {
            misMascotas[animal2].earnDamage(1);
            misMascotas[animal2].earnLife(1);
        }

    }

    //Encargado de generar, mostrar y poder comprar comprar comida de tier 4
    public int alimentosAleatoriosTier4() {
        int comidaGenerada;
        comidaGenerada = (int) (Math.random() * (10 - 8) + 8);
        return comidaGenerada;
    }

    public void mostrandComidaTier4(int noComida) {
        if (noComida == 1) {
            System.out.println("8. Chile");
        } else if (noComida == 2) {
            System.out.println("9. Chocolate");
        } else if (noComida == 3) {
            System.out.println("10. Sushi");
        }
    }

    public void darSushi(Mascota[] misMascotas) {
        int animal1 = (int) (Math.random() * (4 - 0) + 0);
        int animal2 = (int) (Math.random() * (4 - 0) + 0);
        int animal3 = (int) (Math.random() * (4 - 0) + 0);

        if (misMascotas[animal1] != null) {
            misMascotas[animal1].earnDamage(1);
            misMascotas[animal1].earnLife(1);
        }
        if (misMascotas[animal1] != null) {
            misMascotas[animal2].earnDamage(1);
            misMascotas[animal2].earnLife(1);
        }
        if (misMascotas[animal1] != null) {
            misMascotas[animal3].earnDamage(1);
            misMascotas[animal3].earnLife(1);
        }

    }

    //proceso para ver a las mascotas
    public void verMascotas(Mascota[] misMascotas) {
        int espaciosSinMascotas = 0;
        for (int i = 0; i <= 4; i++) {
            if (misMascotas[i] != null) {
                System.out.println(i + " Nombre: " + misMascotas[i].getNombre() + " Vida: " + misMascotas[i].getLife() + " Daño: " + misMascotas[i].getDamage() + " XP: " + misMascotas[i].getXP());
            } else {
                espaciosSinMascotas += 1;

            }
            if (espaciosSinMascotas == 5) {
                System.out.println("No tienes mascotas");
            }
        }
    }

    //proceso para ordenar mascotas
    public void ordenarMascotas(Mascota[] misMascotas) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Ver mascotas");
        System.out.println("2. Mover de lugar cierta Mascota");
        System.out.println("Si al lugar donde quieres mover a tu mascota hay otra igual, se fusionaran");
        int opcion = scan.nextInt();
        if (opcion == 1) {
            verMascotas(misMascotas);
        } else if (opcion == 2) {
            moverDeLugar(misMascotas);
        }
    }

    //proceso para mover a las mascotas
    public void moverDeLugar(Mascota[] misMascotas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite el animal que quiere cambiar");
        int animalAMover = scanner.nextInt();
        System.out.println("Digite la posicion a la que lo quiere mover");
        int posicionAMover = scanner.nextInt();

        if (misMascotas[posicionAMover] != null) {
            if (misMascotas[animalAMover].getNombre().equals(misMascotas[posicionAMover].getNombre())) {
                boolean fusion = true;
                misMascotas[posicionAMover].subirXp(fusion);
                misMascotas[animalAMover] = null;
            } else {
                Mascota mascotaAux;
                mascotaAux = misMascotas[posicionAMover];
                misMascotas[posicionAMover] = misMascotas[animalAMover];
                misMascotas[animalAMover] = mascotaAux;
            }

        } else {
            misMascotas[posicionAMover] = misMascotas[animalAMover];
            misMascotas[animalAMover] = null;
        }
    }

    //proceso para vender mascotas
    public void venderMascotas(Mascota[] misMascotas) {
        Scanner scanner = new Scanner(System.in);
        int posicion;
        System.out.println("Digite la posicion de la mascota que quiere vender");
        posicion = scanner.nextInt();
        if (misMascotas[posicion] != null) {
            if (misMascotas[posicion] instanceof Castor) {
                ((Castor) misMascotas[posicion]).habilidad(misMascotas, true);
            }
            misMascotas[posicion] = null;
            oro += 1;
        } else {
            System.out.println("No hay una mascota para vender en esa posicion");
        }
    }
}
