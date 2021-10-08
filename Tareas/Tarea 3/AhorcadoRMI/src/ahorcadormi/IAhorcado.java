package ahorcadormi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAhorcado extends Remote {
    void IniciarJuego() throws RemoteException;

    boolean ExisteLetra(char letra) throws RemoteException;

    void ReemplazarGuiones(char letra) throws RemoteException;

    String Jugar(char letra) throws RemoteException;

    String getGuiones() throws RemoteException;

    int getNumeroFallos() throws RemoteException;

    int getIntentos() throws RemoteException;

    String getPalabraSeleccionada() throws RemoteException;

    void newJuego() throws RemoteException;

}
