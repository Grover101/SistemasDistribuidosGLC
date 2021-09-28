/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenainvertirmultihilo;

/**
 *
 * @author Carlos
 */
// Java implementation for a client
// Save file as Client.java
import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class ClienteMultihiloCadInvertir {

    public static void main(String[] args) throws IOException {
        int port = 5056;
        Scanner sc = new Scanner(System.in);
        try {
            String cadena;
            do {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Introduzca un cadena: ");
                cadena = sc.nextLine();
                toServer.println(cadena);
                if (cadena.equals("fin")) {
                    break;
                }
                String result = fromServer.readLine();
                System.out.println("Cadena Invertida es: " + result);
            } while (true);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
