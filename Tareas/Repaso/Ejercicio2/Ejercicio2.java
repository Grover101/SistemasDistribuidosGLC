package Tareas.Repaso.Ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("IMPRIMIR TABLAS");
        System.out.println("1. Suma\n2. Resta\n3. Multiplicacion\n4. Division");
        int opcion;
        Scanner inputNumber = new Scanner(System.in);
        do {
            System.out.println("Elija una opcion:");
            opcion = inputNumber.nextInt();
        } while (opcion < 0 || opcion > 4);
        System.out.println("Introduzca el numero de tabla a imprimir:");
        int numTabla = inputNumber.nextInt();
        switch (opcion) {
            case 1:
                for (int i = 1; i <= 10; i++)
                    System.out.println(numTabla + " + " + i + " = " + (numTabla + i));
                break;
            case 2:
                for (int i = numTabla; i <= numTabla + 10; i++)
                    System.out.println(i + " - " + numTabla + " = " + (i - numTabla));
                break;
            case 3:
                for (int i = 1; i <= 10; i++)
                    System.out.println(numTabla + " x " + i + " = " + (i * numTabla));
                break;
            default:
                for (int i = numTabla; i <= 10 * numTabla; i += numTabla)
                    System.out.println(i + " / " + numTabla + " = " + (i / numTabla));
                break;
        }
        inputNumber.close();
    }
}
