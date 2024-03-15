import javax.swing.*;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<ProductoEspecifico> listaProducto;

    public Inventario() {
        this.listaProducto = new ArrayList<>();
    }

    public void agregarProducto(ProductoEspecifico producto){
        this.listaProducto.add(producto);
    }
    public boolean eliminarProducto(int id){
        return this.listaProducto.removeIf(producto -> producto.getId() == id);
    }

    public String listarProductos(){
        String productoTemporal = "";
        for (ProductoEspecifico iterador : this.listaProducto){
            productoTemporal += "- "+iterador.toString()+"\n";
        }
        return  productoTemporal;
    }

    public ProductoEspecifico buscarPorNombre(String nombreBuscar){
        if (this.listaProducto.isEmpty()){
            JOptionPane.showInputDialog(null, "No hay productos disponibles por mostrar");
        }else {
        for (ProductoEspecifico i : this.listaProducto){
            if (i.getNombre().equalsIgnoreCase(nombreBuscar)){
                return i;
            }
        }
        }
        return null;
    }

    public ProductoEspecifico buscarPorMarca(String categoriaBuscar){
        for (ProductoEspecifico i : this.listaProducto){
            if (i.getCategoria().equalsIgnoreCase(categoriaBuscar)){
                return i;
            }
        }

        return null;
    }
}