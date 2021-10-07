/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadormi;

import java.util.ArrayList;

/**
 *
 * @author WINDOWS 10
 */
public class Ahorcado {

    ArrayList<String> listapalabras;
    String palabraAdivinar;
    int numeroFallos;
    String guiones;

    public Ahorcado() {
        listapalabras = new ArrayList<String>();
        listapalabras.add("sqlserver");
        listapalabras.add("Mysql");
        listapalabras.add("mongodb");
        listapalabras.add("firebase");
        IniciarJuego();

    }

    public void IniciarJuego() {
        this.numeroFallos = 0;
        this.guiones = "";
        int numero = (int) Math.random() * listapalabras.size();
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

    private void ReemplazarGuiones(char letra) {
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letra) {
                guiones = guiones.substring(0, i) + letra + guiones.substring(i + 1);
            }
        }
    }

    public String Jugar(char letra) {
        if (ExisteLetra(letra)) {
            ReemplazarGuiones(letra);
            if (guiones.equals(palabraAdivinar)) {
                return "Ganaste";
            } else {
                return "Seguir";
            }
        } else {
             numeroFallos++;
            if (numeroFallos == 5) {
                return "Perdiste";
            } else {
                return "Seguir";
            }
        }
    }

    public String getGuiones() {
        return guiones;
    }

    public int getNumeroFallos() {
        System.out.println("letra incorrecta tienes menos intentos");
        return numeroFallos;
        
    }
    
}
