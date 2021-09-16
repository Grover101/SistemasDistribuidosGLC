/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Grover
 */
public class ServidorHola {

    public static void main(String[] args) {
        int port = 5002;
        
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;       
            client = server.accept(); //conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
           
            
            String nCliente = fromClient.readLine();
            int fact = Integer.parseInt(nCliente);
            System.out.println(fact);
            
            toClient = new PrintStream(client.getOutputStream()); 
            toClient.println("El Factorial es: " + factorial(fact));
            System.out.println("Cliente se conecto");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
     public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }
   
}
