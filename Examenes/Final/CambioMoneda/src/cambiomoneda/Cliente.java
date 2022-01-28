package cambiomoneda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author grover
 */
public class Cliente {

    public static void main(String[] args) {
      int port = 5010;
        Scanner sc=new Scanner(System.in); 
        try {
            Socket client = new Socket("localhost", port); 
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Introduzca el Moneda de Origen [Bs,US,R,Arg]:");
            String A=sc.next();
            System.out.println("Introduzca el Moneda de Destino [Bs,US,R,Arg]:");
            String B=sc.next();
            System.out.println("Introduzca la cantidad:");
            String C=sc.next();
            
            String cadena;
            cadena=C+":"+A+":"+B;
            
            toServer.println(cadena);
            String result = fromServer.readLine();  
            System.out.println("Cantidad de monedas necesarias: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
