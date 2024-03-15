import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCurso {
    private ArrayList<Curso> listaCursos;
    private ArrayList<Estudiante> listaEstudiantes;
    public GestionCurso (){
        this.listaCursos = new ArrayList<>();
    }

    public  void agregarCurso(Scanner objScann){
        System.out.print("Ingresa el nombre del nuevo curso: ");
        String nombre = objScann.next();
        System.out.print("Ingresa el código del nuevo curso: ");
        String codigo = objScann.next();

        //Validamos que el código del curso sea único
        if(this.buscarCursoPorCodigo(codigo) != null){
            System.out.println("Ya existe un curso con este código");
        }else {
            Curso objCurso = new Curso(codigo, nombre);
            if (this.listaCursos.add(objCurso)){
                System.out.println("Curso agregado correctamente");
            }else {
                System.out.println("No se pudo agregar el curso");
            }

        }
    }

    public void listarTodosCursos(){
        if (this.listaCursos.isEmpty()){
            System.out.println("No hay cursos registrados");
        } else {
        System.out.println("Estos son los cursos disponibles: ");
        for (Curso temporal : this.listaCursos){
            System.out.println(temporal.toString());
        }
        }
    }

    public Curso buscarCursoPorCodigo(String codigoBuscar){
        for (Curso temporal : this.listaCursos){
            if (temporal.getCodigo().equalsIgnoreCase(codigoBuscar)){
                return temporal;
            }
        }
        return null;
    }

}
