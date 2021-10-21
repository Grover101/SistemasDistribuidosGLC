package banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author grover
 */

public interface IBanco extends Remote {
    public Factura[] calcular(int idcliente) throws RemoteException;

    public String pagar(Factura[] facturas) throws RemoteException;

}