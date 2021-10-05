package ahoracadoudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP {

    public static void main(String args[]) {
        int port = 6789;
        try {

            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];
            Ahorcado ahorcado = new Ahorcado();
            String cadena = "", cadAux = "";

            while (true) {
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                // Leemos una petición del DatagramSocket
                DatagramPacket respuesta;
                socketUDP.receive(peticion);
                // Cliente se conecta
                System.out.println("Cliente se conecto");
                cadena = new String(peticion.getData(), 0, peticion.getLength());
                System.out.println(cadena);

                // Condicion para terminar la ejecucion del servidor
                if (cadena.equals("F")) {
                    System.out.println("SERVIDOR TERMINO LA EJECUCION");
                    break;
                }

                if (cadena.equals("S")) {
                    // Instancia cada vez que vuelva a jugar para generar una palabra distinta
                    ahorcado = new Ahorcado();
                    cadAux = Integer.toString(ahorcado.getPalabra().length());
                    byte[] palabra = cadAux.getBytes();
                    // toClient.println(ahorcado.getPalabra().length());
                    respuesta = new DatagramPacket(palabra, cadAux.length(), peticion.getAddress(), peticion.getPort());
                    socketUDP.send(respuesta);
                } else {
                    // Verifica si la letra se encuentra o no
                    ahorcado.verificarLetra(cadena.charAt(0));
                    // Da un formato legible al cliente
                    String palabraForm = "";
                    for (int i = 0; i < ahorcado.getPalabraFormada().length(); i++)
                        palabraForm += ahorcado.getPalabraFormada().charAt(i) + " ";
                    byte[] envio;
                    // Envia el estado al cliente
                    if (ahorcado.getVida() > 0) {
                        if (ahorcado.gana()) {
                            cadAux = "Felicidades Ganaste!!! la palabra fue: " + ahorcado.getPalabra();
                            envio = cadAux.getBytes();
                            respuesta = new DatagramPacket(envio, cadAux.length(), peticion.getAddress(),
                                    peticion.getPort());
                            socketUDP.send(respuesta);
                        } else {
                            cadAux = palabraForm + "\t" + "vidas: " + ahorcado.getVida();
                            envio = cadAux.getBytes();
                            respuesta = new DatagramPacket(envio, cadAux.length(), peticion.getAddress(),
                                    peticion.getPort());
                            socketUDP.send(respuesta);
                        }
                    } else {
                        cadAux = "Perdiste!!! la palabra fue: " + ahorcado.getPalabra();
                        envio = cadAux.getBytes();
                        respuesta = new DatagramPacket(envio, cadAux.length(), peticion.getAddress(),
                                peticion.getPort());
                        socketUDP.send(respuesta);
                    }
                }
                System.out.println("Cliente se conecto");
            }
            socketUDP.close();
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
