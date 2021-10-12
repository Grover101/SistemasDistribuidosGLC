package laboratorio.pkg1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUniversidad {

    public static void main(String[] args) {
        IUniversidad universidad;
        Diploma diploma = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese los datos del Alumno para Emitir Diploma:");
        System.out.println("CI:");
        String ci = input.nextLine();
        System.out.println("Nombres:");
        String nombres = input.nextLine();
        System.out.println("1er Apellido:");
        String apellido1 = input.nextLine();
        System.out.println("2do Apellido:");
        String apellido2 = input.nextLine();
        System.out.println("Fecha de Nacimiento:");
        String fechaNac = input.nextLine();
        System.out.println("Carrera:");
        String carrera = input.nextLine();

        try {
            universidad = (IUniversidad) Naming.lookup("rmi://localhost/Universidad");
            diploma = universidad.emitirDiploma(ci, nombres, apellido1, apellido2, fechaNac, carrera);

            // diploma = universidad.emitirDiploma("1140504", "Walter Jhamil", "Segovia",
            // "Arellano", "11-02-996", "Ing. en Ciencias de la Computacion");

            if (diploma.getMensaje().isEmpty())
                System.out.println("La diploma del Alumno se Emitio Correctamente");
            else
                System.out.println("Existen errores: " + diploma.getMensaje());

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteUniversidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        // input.close();
    }

}
