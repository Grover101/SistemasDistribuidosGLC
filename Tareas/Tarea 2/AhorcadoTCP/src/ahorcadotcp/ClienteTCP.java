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
            String opcion, comenzar = "";
            char letra;
            boolean inicio = true;

            do {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

                if (inicio) {
                    System.out.println("Quiere comenzar? [S/N]");
                    opcion = input.next();
                    if (opcion.equals("S")) {
                        inicio = false;
                        comenzar = "";
                        toServer.println(opcion);
                        String palabra = fromServer.readLine();
                        System.out.println("La palabra que le toco es de: " + palabra + " Letras");
                        // System.out.println(co);
                    } else {
                        System.out.println("Quiere Salir? [S/N]");
                        opcion = input.next();
                        if (opcion.equals("S"))
                            break;
                        else
                            System.out.println("Comience cuando este listo!!!!");
                    }
                } else {
                    // if (comenzar.isEmpty()) {
                    System.out.println("Ingrese una Letra:");
                    letra = input.next().charAt(0);
                    toServer.println(letra);
                    String response = fromServer.readLine();
                    if (response.equals("gano")) {
                        // System.out.println(response);
                        // toServer.println(letra);
                        System.out.println("Felicidades Ganaste!!!");
                        // comenzar = "si";
                        inicio = true;
                    } else if (response.equals("perdio")) {
                        // System.out.println(response);
                        System.out.println("Perdiste!!!");
                        // comenzar = "si";
                        inicio = true;
                        // toServer.println(letra);
                    } else
                        System.out.println(response);
                    // } else {
                    // System.out.println("Quiere volver a Jugar? [S/N]");
                    // letra = input.next().charAt(0);
                    // if (letra == 'S')
                    // inicio = true;
                    // else {
                    // System.out.println("Gracias por Jugar!!!");
                    // break;
                    // }
                    // }
                    // cadena = sc.next();
                    // String result = fromServer.readLine();
                    // System.out.println("La palabra es:\n" + result);

                }
                client.close();
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        input.close();

    }
}
