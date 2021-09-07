package Tareas.Repaso.Ejercicio3;

public class Materia {
    private String nombre;
    private String sigla;
    private String descripcion;

    public Materia(String nombre, String sigla, String descripcion) {
        this.nombre = nombre;
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
