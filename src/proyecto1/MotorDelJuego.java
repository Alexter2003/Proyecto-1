package proyecto1;

import java.util.Scanner;

public class MotorDelJuego {
    Scanner scanner = new Scanner(System.in);
    protected int opcion = 0;

    public void Menu() {
        while (opcion != 5) {
            System.out.println("\nBienvenido a SuperAutoPets\n");
            System.out.println("Que desea hacer o jugar\n");
            System.out.println("1. Modo Arena:");
            System.out.println("2. Salir");
            opcion=scanner.nextInt();
            if(opcion==1){
                iniciarArenaMode();
            }else if(opcion==2){
                System.out.println("Adios :)");
                break;
            }
        }

    }

    public void iniciarArenaMode(){
        ArenaMode arenaMode = new ArenaMode();
        arenaMode.juego();

    }

    public void inciarVersusMode(){
        VersusMode versusMode = new VersusMode();
    }

}
