/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesrmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Carlos
 */
public class ServidorSeries extends UnicastRemoteObject
        implements ISeries {

    public ServidorSeries() throws RemoteException {
        super();
    }

    public int factorial(int numero) {
        if (numero == 0) 
            return 1;
        else 
            return numero * factorial(numero - 1);
    }

    public int fibonacci(int a) {
        if (a < 2) 
            return a;
        return fibonacci(a - 1) + fibonacci(a - 2);
    }

    public static void main(String[] args) {
        ServidorSeries servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorSeries();
            Naming.bind("Series", servidor);
            System.out.println("El servidor esta listo\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
