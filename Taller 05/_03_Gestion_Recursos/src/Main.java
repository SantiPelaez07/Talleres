import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner objScnner = new Scanner(System.in);
        GestionCurso objGestion = new GestionCurso();


        int opcion = 0;
        do {
            System.out.print("""
                    polimorfismo es el que reescribe el metodo, es decir, cambiar la logica de un metodo de la clase padre
                    1. Administrar estudiantes
                    2. Administrar cursos
                    3. Salir
                    
                    Ingrese una opción: 
                    """);
            opcion = objScnner.nextInt();

            switch (opcion){
                case 1:
                    int opcion1 = 0;
                    do {
                        System.out.print("""
                                Menú de estudiantes
                                1. Agregar Estudiante
                                2. listar Estudiante
                                3. Eliminar por código de estudiante
                                4. Salir
                                
                                Ingrese una opción: 
                                """);
                        opcion1 = objScnner.nextInt();

                        Curso objCurso = new Curso();
                        switch (opcion1){
                            case 1:
                                objCurso.agregarEstudiante(objScnner);
                                break;
                            case 2:
                                objCurso.listarEstudiante((objScnner));
                                break;
                            case 3:
                                System.out.print("Ingresa el código del estudinte a eliminar: ");
                                String idEstudiante = objScnner.nextLine();
                                objCurso.eliminarEstudiante(idEstudiante);
                                break;
                        }

                    }while(opcion1 != 4);
                    break;
                case 2:
                    int option2 = 0;
                    do {
                        System.out.println("""
                                Menú de cursos
                                1. Agregar curso
                                2. listar cursos
                                3. Buscar por código
                                4. Salir
                                
                                Ingrese una opción: 
                                """);

                        option2 = objScnner.nextInt();

                        switch (option2){
                            case 1:
                                objGestion.agregarCurso(objScnner);
                                break;
                            case 2:
                                objGestion.listarTodosCursos();
                                break;
                            case 3:
                                System.out.print("Ingresa el código del curso que deseas buscar: ");
                                String codigo = objScnner.next();
                                Curso objCurso = objGestion.buscarCursoPorCodigo(codigo);
                                if (objGestion.buscarCursoPorCodigo(codigo) == null){
                                    System.out.println("El código ingresado no corresponde a ningún curso");
                                }else{
                                    System.out.println(objCurso.toString());
                                }
                                break;
                        }
                    }while (option2 != 4);
            }

        }while(opcion != 3);
    }
}