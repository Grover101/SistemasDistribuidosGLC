package cambiomoneda;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorCotizadorRMI extends UnicastRemoteObject implements ICotizador {

    public ServidorCotizadorRMI() throws RemoteException {
        super();
    }

    public double Cotizacion(String monedaOrigen, String monedaDestino) throws RemoteException {
        double moneda = 0.0;
        switch (monedaOrigen) {
            case "Bs":
                switch (monedaDestino) {
                    case "Bs":
                        moneda = 1;
                        break;
                    case "US":
                        moneda = 6.96;
                        break;
                    case "R":
                        moneda = 1.277;
                        break;
                    case "Arg":
                        moneda = 0.066;
                        break;
                }
                break;
            case "US":
                switch (monedaDestino) {
                    case "Bs":
                        moneda = 0.143;
                        break;
                    case "US":
                        moneda = 1;
                        break;
                    case "R":
                        moneda = 0.192;
                        break;
                    case "Arg":
                        moneda = 0.009;
                        break;
                }
                break;
            case "R":
                switch (monedaDestino) {
                    case "Bs":
                        moneda = 0.78;
                        break;
                    case "US":
                        moneda = 5.2;
                        break;
                    case "R":
                        moneda = 1;
                        break;
                    case "Arg":
                        moneda = 0.51;
                        break;
                }
                break;
            case "Arg":
                switch (monedaDestino) {
                    case "Bs":
                        moneda = 15.201;
                        break;
                    case "US":
                        moneda = 104.84;
                        break;
                    case "R":
                        moneda = 19.457;
                        break;
                    case "Arg":
                        moneda = 1;
                        break;
                }
                break;
        }
        System.out.println(moneda);
        return moneda;
    }

    public static void main(String[] args) {
        ServidorCotizadorRMI servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorCotizadorRMI();
            Naming.rebind("Cotizador", servidor);
            System.out.println("El servidor Segip con RMI listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
