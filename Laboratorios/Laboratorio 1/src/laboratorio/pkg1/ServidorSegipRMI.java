package laboratorio.pkg1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServidorSegipRMI extends UnicastRemoteObject implements ISegip {

    Diploma diploma;

    public ServidorSegipRMI() throws RemoteException {
        super();
    }

    public RespuestaSegip verificar(String ci, String nombre, String )

    public static void main(String[] args) {
        ServidorSegipRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorSegipRMI();
            Naming.bind("Segip", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
