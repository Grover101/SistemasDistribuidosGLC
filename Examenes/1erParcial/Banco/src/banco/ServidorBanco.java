package banco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.stream.Stream;

/**
 *
 * @author grover
 */

public class ServidorBanco extends UnicastRemoteObject implements IBanco

{
    ServidorBanco() throws java.rmi.RemoteException {
        super();
    }

    public Factura[] calcular(int idcliente) throws RemoteException {
        ICessa cessa;
        try {
            cessa = (ICessa) Naming.lookup("rmi://localhost/Cessa");
            Factura[] FactuPendinCessa = cessa.Facturaspendientes(idcliente);
            String[] pendinElapas = conectarElapas("fac-" + String.valueOf(idcliente)).split(",");
            Factura[] FactuPendinElapas = new Factura[pendinElapas.length];

            int i = 0;
            for (String f : pendinElapas) {
                String[] factu = f.split("-");
                int IdFactura = Integer.parseInt(factu[0]);
                double monto = Integer.parseInt(factu[1]);
                FactuPendinElapas[i] = new Factura("Elapas", IdFactura, monto);
                i++;
            }

            Factura[] result = Stream.of(FactuPendinCessa, FactuPendinElapas).flatMap(Stream::of)
                    .toArray(Factura[]::new);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String pagar(Factura[] fact) throws RemoteException {
        ICessa cessa;
        try {
            cessa = (ICessa) Naming.lookup("rmi://localhost/Cessa");
            int contarCessa = 0;
            String factElapas = "";
            for (Factura fac : fact) {
                if (fac.getEmpresa().equals("Cessa")) {
                    contarCessa++;
                }
                if (fac.getEmpresa().equals("Elapas")) {
                    factElapas += String.valueOf(fac.getIdFactura()) + ",";
                }

            }

            factElapas = factElapas.substring(0, factElapas.length() - 1);

            Factura[] FacturasCessa = new Factura[contarCessa];

            int iCessa = 0;
            for (Factura fac : fact) {
                if (fac.getEmpresa().equals("Cessa")) {
                    FacturasCessa[iCessa] = fac;
                    iCessa++;
                }
            }
            return cessa.pagar(FacturasCessa) + "\n" + conectarElapas("pag-" + factElapas);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String args[]) {
        try {
            ServidorBanco Banco;
            // LocateRegistry.createRegistry(1099);
            Banco = new ServidorBanco();
            Naming.bind("Banco", Banco);
            System.out.println("El Servidor Banco esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String conectarElapas(String cadena) {
        int port = 5007;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println(cadena);
            String result = fromServer.readLine();
            return result;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
