/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio.pkg1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServidorSereciUDP {

    public static void main(String args[]) {
        int port = 6789;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            System.out.println("Se inicio el servidor Serecil UDP con exito");
            byte[] bufer = new byte[1000];

            // while (true) {
            // Construimos el DatagramPacket para recibir peticiones
            DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

            // Leemos una petición del DatagramSocket
            socketUDP.receive(peticion);

            String datos = new String(peticion.getData(), 0, peticion.getLength());

            String verificado = Verificar(datos);

            byte[] respuestaConvert = verificado.getBytes();

            // Construimos el DatagramPacket para enviar la respuesta
            DatagramPacket respuesta = new DatagramPacket(respuestaConvert, verificado.length(), peticion.getAddress(),
                    peticion.getPort());

            // Enviamos la respuesta, que es un eco
            socketUDP.send(respuesta);
            // }
            socketUDP.close();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    public static String Verificar(String cadena) {
        String[] valores = cadena.split(":");
        String[] datos = valores[1].split(",");
        return (datos[0].equals("Walter Jhamil") && datos[1].equals("Segovia Arellano")
                && datos[2].equals("11-02-1996")) ? "Verificacion Correcta" : "Error fecha nacimiento no correcta";
    }
}
