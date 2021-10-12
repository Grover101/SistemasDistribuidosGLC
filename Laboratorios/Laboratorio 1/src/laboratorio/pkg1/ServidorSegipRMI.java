package laboratorio.pkg1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorSegipRMI extends UnicastRemoteObject implements ISegip {

    Diploma diploma;

    public ServidorSegipRMI() throws RemoteException {
        super();
    }

    public RespuestaSegip verificarDatos(String ci, String nombres, String apellidos) throws RemoteException {
        RespuestaSegip respuesta = new RespuestaSegip(false, "Los Datos del CI no son Correctos");
        if (ci.equals("1140506") && nombres.equals("Walter Jhamil") && apellidos.equals("Segovia Arellano")) {
            respuesta.setEstado(true);
            respuesta.setMensaje("Los Datos son Correctos");
        }
        return respuesta;
    }

    public static void main(String[] args) {
        ServidorSegipRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorSegipRMI();
            Naming.rebind("Segip", servidor);
            System.out.println("El servidor Segip con RMI listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
