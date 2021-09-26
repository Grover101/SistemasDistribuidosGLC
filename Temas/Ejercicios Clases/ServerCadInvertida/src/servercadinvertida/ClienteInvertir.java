package servercadinvertida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class ClienteInvertir {

    public static void main(String[] args) {
        int port = 5010;
        Scanner sc=new Scanner(System.in); 
        try {
            String cadena;
            do {
                Socket client = new Socket("localhost", port); 
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Introduzca un cadena: ");               
                cadena = sc.nextLine();
                toServer.println(cadena);
                if (cadena.equals("fin")) break;
                String result = fromServer.readLine();
                System.out.println("Cadena Invertida es: " + result);
            } while (true);
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
