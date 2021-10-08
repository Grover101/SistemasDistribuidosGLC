package laboratorio.pkg1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServidorUniversidad extends UnicastRemoteObject implements IUniversidad {

    Diploma diploma;

    public ServidorUniversidad() throws RemoteException {
        super();
    }

    public Diploma emitirDiploma(String ci, String nombres, String apellido1, String apellido2, String fechaNac,
            String carrera) {
        // String timestamp = new
        // SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        diploma = new Diploma(nombres + " " + apellido1 + " " + apellido2, carrera, fechaNac, "");
        return diploma;
    }

    public static void main(String[] args) {
        ServidorUniversidad servidor;
        try {
//            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorUniversidad();
            Naming.bind("Universidad", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
