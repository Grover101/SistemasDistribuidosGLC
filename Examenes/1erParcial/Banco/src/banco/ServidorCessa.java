package banco;

/**
 *
 * @author grover
 */

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class ServidorCessa extends UnicastRemoteObject implements ICessa

{
    ServidorCessa() throws java.rmi.RemoteException {
        super();
    }

    public Factura[] Facturaspendientes(int idcliente) throws RemoteException {
        if (idcliente == 1) {
            Factura[] fac = new Factura[2];
            fac[0] = new Factura("Cessa", 154, 150.00);
            fac[1] = new Factura("Cessa", 326, 701.00);

            return fac;
        } else if (idcliente == 2) {
            Factura[] fac = new Factura[2];
            fac[0] = new Factura("Cessa", 325, 610.00);
            fac[1] = new Factura("Cessa", 457, 801.00);

            return fac;
        } else
            throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods,
                                                                           // choose Tools | Templates.
    }

    public String pagar(Factura[] facturas) throws RemoteException {
        return "Se pago las Facturas de Cessa";
    }

    public static void main(String args[]) {
        try {
            ServidorCessa cessa;
            LocateRegistry.createRegistry(1099);
            cessa = new ServidorCessa();
            Naming.bind("Cessa", cessa);
            System.out.println("El Servidor Cessa esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}