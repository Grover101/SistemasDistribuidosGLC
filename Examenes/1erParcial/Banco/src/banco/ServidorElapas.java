package banco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author grover
 */

public class ServidorElapas {

    public static void main(String[] args) {
        int port = 5007;
        String respuesta = "";
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el Servidor Elapas TCP con exito\n");
            Socket client;
            BufferedReader fromClient;
            PrintStream toClient;
            while (true) {
                client = server.accept();
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String cadenaClient;
                cadenaClient = fromClient.readLine();
                toClient = new PrintStream(client.getOutputStream());
                System.out.println("Instruccion recibida" + cadenaClient);
                if (cadenaClient.substring(3, 4).equals("-")) {
                    String instruccion = cadenaClient.substring(0, 3);

                    if (instruccion.equals("fac")) {
                        Integer idcliente = Integer.parseInt(cadenaClient.substring(4));
                        if (idcliente == 1) {
                            respuesta = "2256-362,3216-263,4547-441";
                        }
                        if (idcliente == 2) {
                            respuesta = "1354-215,3252-172";
                        }
                    }
                    if (instruccion.equals("pag")) {
                        respuesta = "Se pagaron las Facturas de Elapas";
                    }

                    toClient.flush();
                    toClient.println(respuesta);
                } else {
                    toClient.flush();
                    toClient.println("El Comando es Erroneo");
                }
            }

        } catch (IOException e

        ) {
            System.out.println(e.getMessage());
        }
    }
}
