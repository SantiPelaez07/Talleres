import javax.swing.*;

public class Main {
    public static void main(String[] args) {

GestionEmpleado objGestion = new GestionEmpleado();
        int option = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Agregar un empleado.
                    2. Listar empleados.
                    3. Eliminar Empleado
                    4. Listar empleados temporales.
                    5. Listar empleados permanentes.
                    6. Salir.
                    
                    Ingresa la opción correspondiente: 
                    """));
            switch (option){
                case 1:
                    objGestion.añadirEmpleado();
                    break;
                case 2:
                    objGestion.listarEmpleados();
                    break;
                case 3:
                    objGestion.eliminarEmpleado();
                    break;
                case 4:
                    objGestion.listarTemporal();
                    break;
                case 5:
                    objGestion.listarPermanente();
                    break;
            }
        }while (option != 6);


    }
}