package Tareas.Repaso.Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Nivel nivel;
        List<Alunmo> alumnoList = new ArrayList<>();
        List<Materia> materiaList = new ArrayList<>();
        Aula aula = new Aula(alumnoList);
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("1. Insertar Alumno\n2. Listar Alumnos\n3. Salir");
            opcion = input.nextInt();
            switch (opcion) {
                case 1:
                    // insertar
                    System.out.println("- Inserte Nombre:");
                    String nombre = input.nextLine();
                    System.out.println("- Inserte Apellido:");
                    String apellido = input.nextLine();
                    System.out.println("- Inserte CU:");
                    String cu = input.nextLine();
                    System.out.println("- Inserte Su Carrera:");
                    System.out.println("  Inserte Nombre de la Carrera:");
                    String nombreCarrera = input.nextLine();
                    System.out.println("  Inserte Descripcion para la Carrera:");
                    String descripcionCarrera = input.nextLine();
                    System.out.println("  Elija el nivel de la Carrera:\n  1. Licenciatura\n  2. Tecnico Superior");
                    int opcionNivel = input.nextInt();
                    switch (opcionNivel) {
                        case 1:
                            nivel = Nivel.Licenciatura;
                            break;
                        default:
                            nivel = Nivel.tecnico_superior;
                            break;
                    }
                    int opcionMateria;
                    System.out.println("- Inserte las sus Materias");
                    String nombreMat, siglaMat, descripcionMat;
                    do {
                        System.out.println("1. Seguir Introduciondo\n2. Salir");
                        opcionMateria = input.nextInt();
                        if (opcionMateria == 1) {
                            System.out.println("Inserte el nombre de la Materia:");
                            nombreMat = input.nextLine();
                            System.out.println("Inserte el nombre de la Sigla:");
                            siglaMat = input.nextLine();
                            System.out.println("Inserte el nombre de la Descripcion:");
                            descripcionMat = input.nextLine();
                            materiaList.add(new Materia(nombreMat, siglaMat, descripcionMat));
                        }
                    } while (opcionMateria != 2);

                    alumnoList.add(new Alunmo(nombre, apellido, cu,
                            new Carrera(nombreCarrera, descripcionCarrera, nivel), materiaList));
                    aula.setAlunmoList(alumnoList);
                    break;
                case 2:
                    // listar
                    int i = 1;
                    for (Alunmo alumno : alumnoList) {
                        System.out.println(i + ". " + alumno.getNombres() + " " + alumno.getApellidos() + " "
                                + alumno.getCu() + " " + alumno.getCarrera().getNombre() + " "
                                + alumno.getMateiasList().size() + " Materias programadas");
                        i++;
                    }
                    break;
            }
        }
        input.close();
    }
}
