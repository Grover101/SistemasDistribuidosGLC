package ahoracadoudp;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientUDP {

    // Los argumentos proporcionan el mensaje y el nombre del servidor
    public static void main(String args[]) {
        int puerto = 6789;

        try {

            String opcion, letra;
            boolean inicio = true;
            Scanner input = new Scanner(System.in);
            while (true) {

                String ip = "localhost";
                DatagramSocket socketUDP = new DatagramSocket();
                InetAddress hostServidor = InetAddress.getByName(ip);
                // byte[] mensaje = dato.getBytes();
                byte[] mensaje;
                byte[] bufer = new byte[1000];
                DatagramPacket peticion;
                DatagramPacket respuesta;
                if (inicio) {
                    System.out.println("Quiere comenzar? [S/N]");
                    opcion = input.next();
                    // Comenzar el Juego
                    if (opcion.equals("S")) {
                        inicio = false;
                        mensaje = opcion.getBytes();
                        peticion = new DatagramPacket(mensaje, opcion.length(), hostServidor, puerto);
                        socketUDP.send(peticion);

                        respuesta = new DatagramPacket(bufer, bufer.length);
                        socketUDP.receive(respuesta);

                        String palabra = new String(respuesta.getData());
                        System.out.println("La palabra que le toco es de: " + palabra + " Letras");
                    } else {
                        // Opcion para salir del juego
                        System.out.println("Quiere Salir? [F/N]");
                        opcion = input.next();
                        if (opcion.equals("F")) {
                            mensaje = opcion.getBytes();
                            peticion = new DatagramPacket(mensaje, opcion.length(), hostServidor, puerto);
                            socketUDP.send(peticion);
                            // toServer.println("F");
                            break;
                        } else
                            System.out.println("Comience cuando este listo!!!!");
                    }
                } else {
                    // Envio de letras y recibo de respuestas
                    System.out.println("Ingrese una Letra:");
                    letra = input.next();
                    mensaje = letra.getBytes();
                    peticion = new DatagramPacket(mensaje, letra.length(), hostServidor, puerto);
                    socketUDP.send(peticion);

                    respuesta = new DatagramPacket(bufer, bufer.length);
                    socketUDP.receive(respuesta);

                    String response = new String(respuesta.getData());
                    if (response.charAt(0) == 'F') {
                        System.out.println(response);
                        inicio = true;
                    } else if (response.charAt(0) == 'P') {
                        System.out.println(response);
                        inicio = true;
                    } else
                        System.out.println(response);
                }
                socketUDP.close();
            }
            input.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}
