public class Persona {
    private String nombre;
    private int edad;
    private String celular;

    public Persona(String nombre, int edad, String  celular) {
        this.nombre = nombre;
        this.edad = edad;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona \n" +
                "nombre: '" + nombre + '\'' +
                ", edad: " + edad +
                ", celular: " + celular;
    }
}
