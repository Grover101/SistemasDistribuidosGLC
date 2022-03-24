package laboratorio.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSeducaTCP {

    public static void main(String[] args) {
        int port = 5010;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor Seduca TCP con exito");

            Socket client;
            PrintStream toClient;
            // while (true) {
            client = server.accept(); // conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String delCliente = fromClient.readLine();

            System.out.println(delCliente);

            String respuesta = Verficar(delCliente);

            toClient = new PrintStream(client.getOutputStream());
            toClient.println(respuesta);
            // }
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String Verficar(String cadena) {
        return cadena.equals("WaSeAr11021996") ? "Verificado con Exito" : "No se encontro el titulo de Bachiller";
    }
}
