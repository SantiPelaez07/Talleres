
public class Empleado extends Persona{
    private int idEmpleado;
    private double salario;
    private int tipo;

    public Empleado(String nombre, int edad, String celular, int idEmpleado, double salario, int tipo) {
        super(nombre, edad, celular);
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.tipo = tipo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", idEmpleado: " + idEmpleado +
                ", salario: " + salario +
                ", tipo: " + tipo;
    }
}

