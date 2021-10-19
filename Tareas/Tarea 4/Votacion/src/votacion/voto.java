/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author grover
 */
public class voto {
    public ArrayList<Integer> candidato = new ArrayList<Integer>() ;

    public voto() {
        this.candidato.add(0);
        this.candidato.add(0);
        this.candidato.add(0);
    }
    
    public void votoPara(int candidato){
        this.candidato.set(candidato - 1 ,this.candidato.get(candidato -1 ) + 1);
    }

    public ArrayList<Integer> getCandidato() {
        return candidato;
    }

    public void setCandidato(ArrayList<Integer> candidato) {
        this.candidato = candidato;
    }
    
    public int mostrarVotos(int candidato){
        return this.candidato.get(candidato - 1);
    }
}
