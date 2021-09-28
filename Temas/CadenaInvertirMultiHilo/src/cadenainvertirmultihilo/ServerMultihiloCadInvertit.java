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
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class ServerMultihiloCadInvertit {

    public static void main(String[] args) throws IOException {
        // Escuchandoen el puerto 5056
        ServerSocket ss = new ServerSocket(5056);

        //ciclo al infinito
        while (true) {
            Socket client = null;

            try {
                // Coneccion del cliente
                client = ss.accept();

                System.out.println("un nuevo cliente se ha conectado : " + client);

                // obtener su entrada y salida de stream
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");

                PrintStream toClient = new PrintStream(client.getOutputStream());

                System.out.println("Asignar un nuevo hilo para este cliente ");

                // create a new thread object
                Thread t = new ClientHandlerCadInvertir(client, fromClient, toClient);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                client.close();
                e.printStackTrace();
            }
        }
    }

}
