package laboratorio.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorUniversidad extends UnicastRemoteObject implements IUniversidad {

    Diploma diploma;

    public ServidorUniversidad() throws RemoteException {
        super();
    }

    public Diploma emitirDiploma(String ci, String nombres, String apellido1, String apellido2, String fechaNac,
            String carrera) {
        RespuestaSegip respuesta = segipRMI(ci, nombres, apellido1 + " " + apellido2);
        String resultadoTCP = seducaTCP(nombres, apellido1, apellido2, fechaNac);
        String resultadoUDP = serecilUDP(nombres, apellido1, apellido2, fechaNac);

        diploma = new Diploma(nombres + " " + apellido1 + " " + apellido2, carrera, fechaNac, "");

        if (!respuesta.isEstado())
            diploma.setMensaje("\n" + respuesta.getMensaje());
        if (resultadoTCP.charAt(0) != 'V')
            diploma.setMensaje(diploma.getMensaje() + "\n" + resultadoTCP);
        if (resultadoUDP.charAt(0) != 'V')
            diploma.setMensaje(diploma.getMensaje() + "\n" + resultadoUDP);
        return diploma;
    }

    public static void main(String[] args) {
        ServidorUniversidad servidor;
        try {
            // LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorUniversidad();
            Naming.bind("Universidad", servidor);
            System.out.println("El servidor Universitario esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String Rude(String nombre, String apellido1, String apellido2, String fecha) {
        return nombre.substring(0, 2) + apellido1.substring(0, 2) + apellido2.substring(0, 2) + fecha.replace("-", "");
    }

    private static RespuestaSegip segipRMI(String ci, String nombres, String apellidos) {
        RespuestaSegip respuesta = null;
        try {
            ISegip segip = (ISegip) Naming.lookup("//localhost/Segip");
            respuesta = segip.verificarDatos(ci, nombres, apellidos);

            System.out.println(respuesta.getMensaje());

        } catch (NotBoundException ex) {
            Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    private static String seducaTCP(String nombres, String apellido1, String apellido2, String fechaNac) {
        int port = 5010;
        String resultadoTCP = "";
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println(Rude(nombres, apellido1, apellido2, fechaNac));

            resultadoTCP = fromServer.readLine();
            System.out.println(resultadoTCP);
            client.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return resultadoTCP;
    }

    private static String serecilUDP(String nombres, String apellido1, String apellido2, String fechaNac) {
        int puerto = 6789;
        String resultadoUDP = "";
        try {
            String dato = "Ver-fecha:" + nombres + "," + apellido1 + " " + apellido2 + "," + fechaNac;
            String ip = "localhost";
            DatagramSocket socketUDP = new DatagramSocket();

            byte[] mensaje = dato.getBytes();

            InetAddress hostServidor = InetAddress.getByName(ip);

            // Construimos un datagrama para enviar el mensaje al servidor
            DatagramPacket peticion = new DatagramPacket(mensaje, dato.length(), hostServidor, puerto);

            // Enviamos el datagrama
            socketUDP.send(peticion);

            // Construimos el DatagramPacket que contendrá la respuesta
            byte[] bufer = new byte[1000];
            DatagramPacket respuest = new DatagramPacket(bufer, bufer.length);
            socketUDP.receive(respuest);

            // Enviamos la respuesta del servidor a la salida estandar
            resultadoUDP = new String(respuest.getData());
            System.out.println(resultadoUDP);

            // Cerramos el socket
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        return resultadoUDP;
    }
}
