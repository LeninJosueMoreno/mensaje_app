package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("----------");
            System.out.println(" Aplicacion de mensajes ");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensaje");
            System.out.println(" 3. eliminar mensaje");
            System.out.println(" 4. editar mensaje");
            System.out.println(" 5. salir");

            // leemos la opcion del usuario
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    break;
                case 4:
                    MensajeService.editarMensaje();
                    break;
                default:
                    break;

            }

        } while (opcion != 5);


    }
}
