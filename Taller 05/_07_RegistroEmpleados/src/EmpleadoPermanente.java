public class EmpleadoPermanente extends Empleado{
    public EmpleadoPermanente(String nombre, int edad, String celular, int idEmpleado, double salario, int tipo) {
        super(nombre, edad, celular, idEmpleado, salario, tipo);
    }

    @Override
    public String toString() {
        return "EmpleadoPermanente: "+ super.toString();
    }
}
