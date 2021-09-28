/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenainvertirmultihilo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Carlos
 */
class ClientHandlerCadInvertir extends Thread {
    final BufferedReader dis;
    final PrintStream dos;
    final Socket s;

    // Constructor
    public ClientHandlerCadInvertir(Socket s, BufferedReader dis, PrintStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        while (true) {
            try {

                // Ask user what he wants
                // dos.println("FEcha hora?[Date | Time]..\n" + "Escibir Fin para terminar la conneccion.");

                // receive the answer from client
                received = dis.readLine();

                if (received.equals("Fin")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                dos.println("La cadena invertida es: " + Invertir(received));
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String Invertir(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadenaInvertida += cadena.charAt(i);
        }
        return cadenaInvertida;
    }
}
