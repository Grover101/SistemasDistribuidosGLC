package laboratorio.pkg1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUniversidad extends Remote {

    Diploma emitirDiploma(String ci, String nombres, String apellido1, String apellido2, String fechaNac,
            String carrera) throws RemoteException;

}
