package banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author grover
 */

public interface ICessa extends Remote {
    public Factura[] Facturaspendientes(int idcliente) throws RemoteException;

    public String pagar(Factura[] facturas) throws RemoteException;

}
