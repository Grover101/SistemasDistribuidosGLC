/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesrmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class ClienteSeries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ISeries serie;
        int a;
        char opcion;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Quiere hacer Fibonacci o Factorial: [1/2]");
        opcion = sc.next().charAt(0);
        
        System.out.println("introduzca el valor:");
        a=sc.nextInt();
        
        try {
            serie=(ISeries)Naming.lookup("rmi://localhost/Series");
            if (opcion == '1') 
                System.out.println("El Fibonacci es : " + serie.fibonacci(a));
            else 
                System.out.println("El Factorial es: " + serie.factorial(a));
            
            
        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteSeries.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
