package Tareas.Repaso.Ejercicio1;

import java.util.Scanner;

/**
 * Ejercicio1
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduzca una cadena:");
        String cadenaInput = input.nextLine(), cadenaInvertida = "";
        System.out.println("Cadena Original: " + cadenaInput);
        for (int i = cadenaInput.length() - 1; i >= 0; i--) {
            cadenaInvertida += cadenaInput.charAt(i);
        }
        System.out.println("Cadena Invertida: " + String.valueOf(cadenaInvertida));
        input.close();
    }
}