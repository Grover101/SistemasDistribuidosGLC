package banco;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author grover
 */
public class ClienteBanco {
    public static void main(String args[]) {
        IBanco banco;
        int idcliente;
        String pago = "";
        try {
            banco = (IBanco) Naming.lookup("rmi://localhost/Banco");
            System.out.println("Introduzca ID del cliente para mostra sus Facturas: ");
            Scanner input = new Scanner(System.in);
            idcliente = input.nextInt();
            System.out.println("\tFacturas Pendientes");
            Factura[] pend = banco.calcular(idcliente);
            for (Factura f : pend) {
                System.out.print(f.getEmpresa() + "   ");
                System.out.print(f.getIdFactura() + "   ");
                System.out.println(f.getMonto());
            }
            System.out.println("Desea Pagar las Facturas: [S/N]");
            String pagar = input.next();
            if (pagar.charAt(0) == 'S') {
                pago = banco.pagar(pend);
                System.out.println("Se realizo los siguientes pagos:\n" + pago);
            } else
                System.out.println("Pague sus deudas");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
