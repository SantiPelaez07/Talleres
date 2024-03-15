import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ProductoEspecifico objProducto1 = new ProductoEspecifico(1,"Lápiz", 2300, "Papelería", "Big");
        ProductoEspecifico objProducto2 = new ProductoEspecifico(2,"Cuaderno", 6000, "Papelería", "Norma");

        Inventario objInventario = new Inventario();

        objInventario.agregarProducto(objProducto1);
        objInventario.agregarProducto(objProducto2);

        int option = 0, id = 1;
        do {
        option = Integer.parseInt(JOptionPane.showInputDialog(null,"Opciones disponibles:\n" +
                "1. Agregar producto\n" +
                "2. Eliminar producto\n" +
                "3. Buscar por nombre\n" +
                "4. Buscar por categoría\n" +
                "5. Listar inventario\n" +
                "6. Salir"));

            switch (option){
                case 1:
                    String nameProduct = JOptionPane.showInputDialog("Ingresa el nombre del producto: ");
                    double precioProduct = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio el producto: "));
                    String category = JOptionPane.showInputDialog("Ingresa la categoría del producto: ");
                    String marca = JOptionPane.showInputDialog("Ingresa la marca del producto: ");
                    ProductoEspecifico objProductI = new ProductoEspecifico(id, nameProduct, precioProduct, category, marca);
                    if(){
                        JOptionPane.showMessageDialog(null, "El producto se agregó correctamente");
                        objInventario.agregarProducto(objProductI);
                    id++;
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al agregar un producto");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Productos: \n" + objInventario.listarProductos(), "Productos", JOptionPane.INFORMATION_MESSAGE);
                    int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto que desea eliminar:"));
                    if (objInventario.eliminarProducto(idEliminar)){
                        JOptionPane.showMessageDialog(null, "El producto se eliminó correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "El producto NO se eliminó");
                        break;
                    }
                    break;
                case 3:
                    String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto que deseas buscar: ");
                    JOptionPane.showMessageDialog(null, objInventario.buscarPorNombre(nombreProducto));
                    break;
                case 4:
                    String categoriaProducto = JOptionPane.showInputDialog("Ingrese la categoria del producto que deseas buscar: ");
                    JOptionPane.showMessageDialog(null, objInventario.buscarPorMarca(categoriaProducto));
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Productos: \n" + objInventario.listarProductos(), "Productos", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        }while(option != 6);
    }
}