package ahorcadotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) {
        int port = 5010;
        Scanner input = new Scanner(System.in);
        try {
            String opcion;
            char letra;
            boolean inicio = true;

            do {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

                // Inicio del juego
                if (inicio) {
                    System.out.println("Quiere comenzar? [S/N]");
                    opcion = input.next();
                    // Comenzar el Juego
                    if (opcion.equals("S")) {
                        inicio = false;
                        toServer.println(opcion);
                        String palabra = fromServer.readLine();
                        System.out.println("La palabra que le toco es de: " + palabra + " Letras");
                    } else {
                        // Opcion para salir del juego
                        System.out.println("Quiere Salir? [F/N]");
                        opcion = input.next();
                        if (opcion.equals("F")) {
                            toServer.println("F");
                            break;
                        } else
                            System.out.println("Comience cuando este listo!!!!");
                    }
                } else {
                    // Envio de letras y recibo de respuestas
                    System.out.println("Ingrese una Letra:");
                    letra = input.next().charAt(0);
                    toServer.println(letra);
                    String response = fromServer.readLine();
                    if (response.charAt(0) == 'F') {
                        System.out.println(response);
                        inicio = true;
                    } else if (response.charAt(0) == 'P') {
                        System.out.println(response);
                        inicio = true;
                    } else
                        System.out.println(response);
                }
                client.close();
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        input.close();

    }
}
