package cambiomoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorBancoTCP {

    public static void main(String[] args) {
        int port = 5010;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Se inicio el servidor Banco TCP con exito");

            Socket client;
            PrintStream toClient;
            // while (true) {
            client = server.accept(); // conexion
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String delCliente = fromClient.readLine();

            String[] aux = delCliente.split(":");
            double cant = Double.parseDouble(aux[0]);
            double respuestaCotizador = Cotizador(delCliente);
            
            String respuesta = String.valueOf(cant * respuestaCotizador);
            
            toClient = new PrintStream(client.getOutputStream());
            toClient.println(respuesta);
            // }
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double Cotizador(String cadena) {
        ICotizador cotizador;
        double respuesta = 0.0;
        try {
            String[] valores = cadena.split(":");
            System.out.println(valores[0] + " " + valores[1] + " " + valores[2]);
            cotizador = (ICotizador) Naming.lookup("rmi://localhost/Cotizador");
            respuesta = cotizador.Cotizacion(valores[1], valores[2]);
        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorBancoTCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorBancoTCP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorBancoTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
}
