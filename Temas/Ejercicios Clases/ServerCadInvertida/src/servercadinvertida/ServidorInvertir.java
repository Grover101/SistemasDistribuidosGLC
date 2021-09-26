package servercadinvertida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorInvertir {

    public static void main(String[] args) {
        int port = 5010;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");

            Socket client;
            PrintStream toClient;
            while (true) {
                client = server.accept(); //conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                String cadena = fromClient.readLine();
                System.out.println(cadena);
                if (cadena.equals("fin")) {
                    System.err.println("SERVIDOR TERMINO LA EJECUCION");
                    break;
                }
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(Invertir(cadena));
                System.out.println("Cliente se conecto");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String Invertir(String cadena) {
        String cadenaInvertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--)
            cadenaInvertida += cadena.charAt(i);
        return cadenaInvertida;
    }
}
