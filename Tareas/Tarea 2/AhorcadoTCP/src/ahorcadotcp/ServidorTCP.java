package ahorcadotcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static void main(String[] args) {
        int port = 5010;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");

            Socket client;
            PrintStream toClient;
            Ahorcado ahorcado = new Ahorcado();
            String cadena = "";
            while (true) {
                // conexion
                client = server.accept();
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toClient = new PrintStream(client.getOutputStream());
                System.out.println("Cliente se conecto");
                cadena = fromClient.readLine();
                System.out.println(cadena);

                // Termina la ejecucuion del Servidor
                if (cadena.equals("F")) {
                    System.out.println("SERVIDOR TERMINO LA EJECUCION");
                    break;
                }

                if (cadena.equals("S")) {
                    // Instancia cada vez que vuelva a jugar para generar una palabra distinta
                    ahorcado = new Ahorcado();
                    toClient.println(ahorcado.getPalabra().length());
                } else {
                    // Verifica si la letra se encuentra o no
                    ahorcado.verificarLetra(cadena.charAt(0));

                    // Da un formato legible al cliente
                    String palabraForm = "";
                    for (int i = 0; i < ahorcado.getPalabraFormada().length(); i++)
                        palabraForm += ahorcado.getPalabraFormada().charAt(i) + " ";

                    // Envia el estado al cliente
                    if (ahorcado.getVida() > 0) {
                        if (ahorcado.gana())
                            toClient.println("Felicidades Ganaste!!! la palabra fue: " + ahorcado.getPalabra());
                        else
                            toClient.println(palabraForm + "\t" + "vidas: " + ahorcado.getVida());
                    } else
                        toClient.println("Perdiste!!! la palabra fue: " + ahorcado.getPalabra());

                }
                System.out.println("Cliente se conecto");
            }
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
