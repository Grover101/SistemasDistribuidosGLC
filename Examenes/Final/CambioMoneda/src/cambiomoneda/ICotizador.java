package cambiomoneda;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICotizador extends Remote {
     double Cotizacion(String monedaOrigen, String monedaDestino) throws RemoteException;
}
