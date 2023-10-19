import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean bandera =  false;
        Scanner scanner = new Scanner(System.in);
        int fila =0, asiento=0;
        String respuesta, verMapa;


        //estructura de datos a utilizar
        char[][] asientos = new char[10][10];

        //cargando mapa de asientos
        for (int f=0; f<10 ;f++){
            for (int c=0; c<10;c++){
                asientos[f][c] = 'L';
            }
        }

        System.out.println("------------BIENVENIDO AL SISTEMA DE RESERVA DE ASIENTOS -----------");


        while (!bandera){
            System.out.println("Desea ver los asientos disponibles S: si, cualquier otra letra: No");
            verMapa = scanner.next();

            if (verMapa.equalsIgnoreCase("S")){
                mostrarAsientos(asientos);
            }

            boolean estaOk = false;
            while (!estaOk) {
                System.out.println("Ingrese Fila y asiento a reservar");
                System.out.println("Fila (entre 0 y 9): ");
                fila = scanner.nextInt();

                System.out.println("Asiento(entre0 y 9): ");
                asiento = scanner.nextInt();

                if (fila<=9 && fila>=0){
                    if (asiento<=9 && asiento>=0){
                        estaOk = true;

                    }else {
                        System.out.println("El numero de asiento no es valido");
                    }
                }else {
                    System.out.println("El numero de fila no es valido");
                }
            }

            if (asientos[fila][asiento]=='L'){
                asientos[fila][asiento]='X';
                System.out.println("El asiento fue reservado correctamente");
            }else {
                System.out.println("El asiento esta ocupado");
            }


            System.out.println("Desea finalizar la reserva? S: si. Cualquier otra letra: No");
            respuesta = scanner.next();

            if(respuesta.equalsIgnoreCase("S")){
                bandera = true;
            }
        }
    }


    //void no retorna nada, es un procedimiento
    static void mostrarAsientos(char[][] asientos){
        for (int f=0;f<10;f++){
            System.out.print(f+"");

            for (int c=0;c<10;c++){
                System.out.print("["+asientos[f][c]+"]");
            }
            System.out.println(" \n ");

        }

    }
}