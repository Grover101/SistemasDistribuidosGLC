package ahorcadormi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorAhorcado extends UnicastRemoteObject implements IAhorcado {

    ArrayList<String> listapalabras = new ArrayList<>();
    String palabraAdivinar;
    int intentos;
    int numeroFallos;
    String guiones;

    public ServidorAhorcado() throws RemoteException {
        listapalabras.add("nabucodonosor");
        listapalabras.add("anticostitucionalmente");
        listapalabras.add("electrodomesticos");
        listapalabras.add("ovoviviparo");
        listapalabras.add("omoplato");
        listapalabras.add("sabiduria");
        listapalabras.add("deuteronomio");
        listapalabras.add("malaquias");
        listapalabras.add("rigurosidad");
        listapalabras.add("caleidoscopio");

        IniciarJuego();
    }

    public void IniciarJuego() {
        this.numeroFallos = 0;
        this.intentos = 7;
        this.guiones = "";
        int numero = (int) (Math.random() * listapalabras.size() - 1);
        palabraAdivinar = listapalabras.get(numero);
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            guiones += "-";
        }
    }

    public boolean ExisteLetra(char letra) {
        if (palabraAdivinar.indexOf(letra) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public void ReemplazarGuiones(char letra) {
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letra) {
                guiones = guiones.substring(0, i) + letra + guiones.substring(i + 1);
            }
        }
    }

    public String Jugar(char letra) {
        if (ExisteLetra(letra)) {
            ReemplazarGuiones(letra);
            return guiones.equals(palabraAdivinar) ? "Ganaste" : "Seguir";
        } else {
            numeroFallos++;
            return numeroFallos == 7 ? "Perdiste" : "Seguir";
        }
    }

    public String getGuiones() {
        return guiones;
    }

    public int getNumeroFallos() {
        return numeroFallos;

    }

    public int getIntentos() throws RemoteException {
        return intentos;
    }

    public String getPalabraSeleccionada() throws RemoteException {
        return this.palabraAdivinar;
    }

    public void newJuego() throws RemoteException {
        this.numeroFallos = 0;
        this.guiones = "";
        int numero = (int) (Math.random() * listapalabras.size() - 1);
        palabraAdivinar = listapalabras.get(numero);
        for (int i = 0; i < palabraAdivinar.length(); i++)
            guiones += "-";
    }

    public static void main(String[] args) {
        ServidorAhorcado servidor;
        try {
            LocateRegistry.createRegistry(1099); // registrar el servidor e rmi register
            servidor = new ServidorAhorcado();
            Naming.bind("Ahorcado", servidor);
            System.out.println("Servidor corriendo...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
