import javax.swing.*;
import java.security.PublicKey;
import java.util.ArrayList;

public class GestionEmpleado {

    private ArrayList<Empleado> listEmpleados;
    private ArrayList<EmpleadoTemporal> listTemporal;
    private ArrayList<EmpleadoPermanente> listPermanente;
    public static int index = 0, tipo = 0;

    public GestionEmpleado() {
        listEmpleados = new ArrayList<>();
        listTemporal = new ArrayList<>();
        listPermanente = new ArrayList<>();
    }
    public void añadirEmpleado (){

        int confirm = 1;
        do {
        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del empleado: ");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad del empleado: "));
        if (edad <18){
            JOptionPane.showMessageDialog(null, "El empleado es menor de edad, no se puede registrar");
            break;
        }
        String celular = JOptionPane.showInputDialog("Ingresa el número de celular del empleado: ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el salario del empleado: "));
        tipo = Integer.parseInt(JOptionPane.showInputDialog("""
                1. Empleado temporal.
                2. Empleado permanente.
                
                Ingrese el tipo del empleado:
                """));
        if (tipo < 1 || tipo > 2){
            JOptionPane.showMessageDialog(null, "El tipo ingresado no existe", "Dato incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
        boolean agregar = this.listEmpleados.add(new Empleado(nombre, edad, celular, index, salario, tipo));
        if (!this.listEmpleados.isEmpty()){
            if (agregar){
                JOptionPane.showMessageDialog(null, "El empleado se agregó correctamente");
                if (tipo == 1){
                    this.listTemporal.add(new EmpleadoTemporal(nombre, edad, celular, index, salario, tipo));
                } else if (tipo == 2) {
                    this.listPermanente.add(new EmpleadoPermanente(nombre, edad, celular, index, salario, tipo));
                }
                confirm = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro empleado?");
                index++;
            } else {
                JOptionPane.showMessageDialog(null, "¡ERROR!\nEl empleado no se agregó correctamente");
            }
        }else {
            JOptionPane.showMessageDialog(null, "¡ERROR!\nEl empleado no se agregó correctamente");
        }
        }

        }while (confirm == 0);
    }

    public void listarEmpleados(){
        String temporal = "";
        for (Empleado iterador : this.listEmpleados){
            temporal += "- "+iterador.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null, temporal, "Empleados disponibles: ", JOptionPane.INFORMATION_MESSAGE);
    }

    public void eliminarEmpleado (){
        listarEmpleados();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del empleado que deseas eliminar: "));
        if (id > index){
            JOptionPane.showMessageDialog(null, "El id ingresado no corresponde a ningún empleado", "Empleado inexistente", JOptionPane.ERROR_MESSAGE);
        }else {

        if (this.listEmpleados.removeIf(empleado -> empleado.getIdEmpleado() == id)){
            this.listTemporal.removeIf(temporal -> temporal.getIdEmpleado() == id);
            this.listPermanente.removeIf(temporal -> temporal.getIdEmpleado() == id);
            JOptionPane.showMessageDialog(null, "El empleado se eliminó correctamente");
        }else {
            JOptionPane.showMessageDialog(null, "El empleado no se pudo eliminar");
        }
        }
    }

    public void listarTemporal (){
        String empleadoTemporal = "";
        if (this.listTemporal.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay empleados temporales por el momento.");
        }else {
        for (EmpleadoTemporal iterador : this.listTemporal){
            empleadoTemporal += "- "+iterador.toString()+"\n";
        }
        JOptionPane.showMessageDialog(null, empleadoTemporal, "Empleados disponibles: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void listarPermanente (){
        String empleadoPermanente = "";
        if (this.listPermanente.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay empleados permanentes por el momento.");
        }else {
            for (EmpleadoPermanente iterador : this.listPermanente){
                empleadoPermanente += "- "+iterador.toString()+"\n";
            }
            JOptionPane.showMessageDialog(null, empleadoPermanente, "Empleados disponibles: ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
