public class EmpleadoTemporal extends Empleado{
    public EmpleadoTemporal(String nombre, int edad, String celular, int idEmpleado, double salario, int tipo) {
        super(nombre, edad, celular, idEmpleado, salario, tipo);
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal: "+ super.toString();
    }
}
