package consumirseriejava;

import java.util.Scanner;

/**
 *
 * @author grover
 */
public class ConsumirSerieJava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Fibonacci\n2. Factorial");
        int opcion = input.nextInt();
        System.out.println("Inserte un numero: ");
        int n = input.nextInt();
        if(opcion == 1)
            System.out.println("El resultado del fibonacci es: " + fibonacci(n));
        if(opcion == 2)
            System.out.println("El resultado del factorial es: " + factorial(n));
    }    

    private static long factorial(int n) {
        servicio.WsSeries service = new servicio.WsSeries();
        servicio.WsSeriesSoap port = service.getWsSeriesSoap12();
        return port.factorial(n);
    }

    private static int fibonacci(int n) {
        servicio.WsSeries service = new servicio.WsSeries();
        servicio.WsSeriesSoap port = service.getWsSeriesSoap12();
        return port.fibonacci(n);
    }
}
