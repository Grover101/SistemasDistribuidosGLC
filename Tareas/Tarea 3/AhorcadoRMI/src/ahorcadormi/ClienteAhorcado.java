package ahorcadormi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteAhorcado {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IAhorcado ahorcado;
        char letra;
        String estado;
        System.out.println("\tJuego del Ahoracado\n");
        try {
            ahorcado = (IAhorcado) Naming.lookup("rmi://localhost/Ahorcado");
            System.out.println("La palabra que le toco es de: " + ahorcado.getGuiones().length() + " Letras");
            do {
                System.out.println(
                        ahorcado.getGuiones() + "\tvidas:" + (ahorcado.getIntentos() - ahorcado.getNumeroFallos()));
                System.out.println("Ingrese una Letra:");
                letra = input.next().charAt(0);
                estado = ahorcado.Jugar(letra);
                System.out.println(estado);
                if (!estado.equals("Seguir")) {
                    if (estado.equals("Ganaste"))
                        System.out
                                .println("Felicidades Ganaste!!! la palabra fue: " + ahorcado.getPalabraSeleccionada());
                    if (estado.equals("Perdiste"))
                        System.out.println("Perdiste!!! la palabra fue: " + ahorcado.getPalabraSeleccionada());

                    System.out.println("Quiere volver a Jugar? [S/N]");
                    letra = input.next().charAt(0);
                    if (letra == 'S') {
                        ahorcado.newJuego();
                        System.out
                                .println("La palabra que le toco es de: " + ahorcado.getGuiones().length() + " Letras");
                    } else if (letra == 'N')
                        break;
                }
            } while (true);

        } catch (NotBoundException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClienteAhorcado.class.getName()).log(Level.SEVERE, null, ex);
        }
        input.close();
    }

}
