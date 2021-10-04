/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Carlos
 */
public interface ISeries  extends Remote {
    int factorial(int a) throws RemoteException;
    int fibonacci(int a)throws RemoteException;
    
}
