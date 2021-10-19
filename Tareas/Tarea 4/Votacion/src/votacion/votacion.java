package votacion;

import java.io.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

public class votacion extends ReceiverAdapter {

    JChannel channel;
    //String user_name=System.getProperty("user.name", "n/a");
    private String user_name;
    private List<voto> candidato = new ArrayList<voto>();

    public votacion(String user_name) {
        this.user_name = user_name;
        this.candidato.add(new voto());
        this.candidato.add(new voto());
        this.candidato.add(new voto());
        this.candidato.add(new voto());
    }
    final List<String> state = new LinkedList<>();

    public void viewAccepted(View new_view) {
        System.out.println("** vista: " + new_view);
    }

    public void receive(Message msg) {
//        String line = msg.getSrc() + ": " + msg.getObject();
        String line = msg.getObject();

        String[] eleccion = line.split(",");
        int mesa = Integer.parseInt(eleccion[0]);
        this.candidato.get(mesa - 1).votoPara(Integer.parseInt(eleccion[1]));
//        System.out.println(mesa + "  " + this.candidato.get(mesa - 1).candidato + "  " + this.candidato.get(mesa).getNroVotos());
//        System.out.println(line);
        synchronized (state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatCluster");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("> \nMesas: [1, 2, 3, 4]\nCantidatos:\n1. Juan\n2. Pedro\n3. Maria");
                System.out.println("Introduzca Formato para enviar: (Nro. Mesa, Nro Cantidato)");
                System.out.flush();
                String line = in.readLine().toLowerCase();

                if (line.startsWith("quit") || line.startsWith("exit")) {
                    break;
                }

                if (line.startsWith("resultado")) {
                    int i = 1;
                    String nombre = "";
                    ArrayList<Integer> aux;
                    for (voto candi : this.candidato) {
                        System.out.println("Mesa " + i);
                        aux = candi.getCandidato();
                        System.out.println("Candidatos: ");
                        for (int j = 0; j < aux.size(); j++) {
                            switch (j) {
                                case 0:
                                    nombre = "Juan";
                                    break;
                                case 1:
                                    nombre = "Pedro";
                                    break;
                                case 2:
                                    nombre = "Maria";
                                    break;
                            }
                            System.out.println("Candidato: " + nombre + "    Nro Votos: " + aux.get(j));
                        }
                        i++;
                    }
                }
//                line = "[" + user_name + "] " + line;
                Message msg = new Message(null, line);
                channel.send(msg);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca su nombre de Votante: ");
        String nombre;
        nombre = sc.next();
        new votacion(nombre).start();
    }
}
