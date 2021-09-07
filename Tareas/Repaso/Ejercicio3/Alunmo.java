package Tareas.Repaso.Ejercicio3;

import java.util.List;

public class Alunmo {
    private String nombres;
    private String apellidos;
    private String cu;
    private Carrera carrera;
    private List<Materia> materiasList;

    public Alunmo(String nombres, String apellidos, String cu, Carrera carrera, List<Materia> materiasList) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cu = cu;
        this.carrera = carrera;
        this.materiasList = materiasList;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Materia> getMateiasList() {
        return materiasList;
    }

    public void setMateiasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

}
