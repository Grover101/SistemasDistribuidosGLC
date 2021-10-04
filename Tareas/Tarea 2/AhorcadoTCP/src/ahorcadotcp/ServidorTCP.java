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
                client = server.accept(); // conexion
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el
                toClient = new PrintStream(client.getOutputStream()); // lector
                System.out.println("Cliente se conecto");
                cadena = fromClient.readLine();
                System.out.println(cadena);

                if (cadena.equals("fin")) {
                    System.out.println("SERVIDOR TERMINO LA EJECUCION");
                    break;
                }

                if (cadena.equals("S")) {
                    ahorcado = new Ahorcado();
                    toClient.println(ahorcado.getPalabra().length());
                } else {
                    ahorcado.verificarLetra(cadena.charAt(0));
                    String palabraForm = "";
                    for (int i = 0; i < ahorcado.getPalabraFormada().length(); i++)
                        palabraForm += ahorcado.getPalabraFormada().charAt(i) + " ";

                    // System.out.println(cad);
                    // toClient.println(ahorcado.getPalabraFormada());
                    if (ahorcado.getVida() > 0) {
                        if (ahorcado.gana())
                            toClient.println("gano");
                        else
                            toClient.println(palabraForm + "\t" + "vidas: " + ahorcado.getVida());
                    } else
                        toClient.println("perdio");

                }

                // String otro = fromClient.readLine();
                // System.out.println(otro);
                System.out.println("Cliente se conecto");
            }
            server.close();
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
