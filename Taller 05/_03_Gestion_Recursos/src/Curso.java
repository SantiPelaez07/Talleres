import java.util.ArrayList;
import java.util.Scanner;

public class Curso {
    private String codigo;
    private String nombre;
    private ArrayList<Estudiante> listaEstudiantes;

    public Curso(){

    }

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Scanner objScnner) {
//        try {
            System.out.print("Ingresa el código del estudiante: ");
            int idE = objScnner.nextInt();
            System.out.print("Ingresa el nombre del estudiante: ");
            String nombre = objScnner.next();
            System.out.print("Ingrese el email del estudiante: ");
            String email = objScnner.next();
            Estudiante objEstudiante = new Estudiante(idE, nombre, email);
            this.listaEstudiantes.add(objEstudiante);
            System.out.println("El estudiante se registró correctamente");
//        } catch (Exception e){
//            System.out.println("¡ERROR!\n Un dato ingresado ha sido incorrecto");
//        }
    }

    public void listarEstudiante(Scanner objScan) {
        for (Estudiante iterador : this.listaEstudiantes) {
            System.out.println("- " + iterador);
        }
    }

    public void eliminarEstudiante(String id) {
        boolean Eliminar = this.listaEstudiantes.removeIf(estudiante -> estudiante.getId() == Integer.parseInt(id));
        System.out.println(!Eliminar
                ? "El estudiante no se ha eliminado correctamente ❌"
                : "El estudiante se eliminó con exito ✔"
        );
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso " +
                "Código: '" + codigo + '\'' +
                "Nombre: '" + nombre + '\'' +
                "Lista de Estudiantes: " + listaEstudiantes;
    }
}
