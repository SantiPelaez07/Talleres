package controller;

import javax.swing.JOptionPane;

import entity.Coder;
import model.CoderModel;

import java.awt.font.FontRenderContext;

public class CoderController {

    public static void getAll (){
        CoderModel objModel = new CoderModel();
        String listCoders = "CODER LIST \n";
        for(Object iterador: objModel.findAll()){
            //Convertimos el object a Coder
            Coder objCoder = (Coder) iterador;
            listCoders += objCoder.toString();
        }
            JOptionPane.showMessageDialog(null, listCoders);
    }

    public static String getAllString(){
        CoderModel objModel = new CoderModel();
        String listCoders = "CODER LIST \n";


        for(Object iterador: objModel.findAll()){
            //Convertimos el object a Coder
            Coder objCoder = (Coder) iterador;
            listCoders += objCoder.toString();
        }

        return listCoders;
    }

    public static void create(){
        CoderModel objCoderModel = new CoderModel();


        String name = JOptionPane.showInputDialog("Insert name: ");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Insert age: "));
        String clan = JOptionPane.showInputDialog("Insert clan: ");
        Coder objCoder = new Coder();
        objCoder.setName(name);
        objCoder.setClan(clan);
        objCoder.setAge(age);
        // Llamamos al método de inserción y guardamos el objeto que retorna en el Coder previamente instanciado
        objCoder = (Coder) objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());

    }

    public static  void delete(){
        CoderModel objCoderModel = new CoderModel();
        String listCoders = getAllString();
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog("ListCoders" + listCoders + "\n Enter the Id the coder to delete: "));

        Coder objCoder = objCoderModel.findById(idDelete);
        if (objCoder == null){
            JOptionPane.showMessageDialog(null, "Coder not found");
        }else {
           int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete the coder? \n" + objCoder.toString());
            if (confirm == 0) objCoderModel.delete(objCoder);
        }
    }

    public static void update(){
        //1. Utiliza el modelo
        CoderModel objCoderModel = new CoderModel();
        String listCoders = getAllString();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("ListCoders" + listCoders + "\n Enter the Id of the coder to edit: "));
        //2. Obteniendo un coder por el id ingresado
        Coder objCoder = objCoderModel.findById(idUpdate);
        //3.  Validamos que si exista el coder
        if (objCoder == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        }else {
            //Para convertir un entero a String utilizamos String.valueOf()
            String name = JOptionPane.showInputDialog(null, "Enter new name: ", objCoder.getName());
            int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new age: ", String.valueOf(objCoder.getAge())));
            String clan = JOptionPane.showInputDialog(null, "Enter new clan: ", objCoder.getClan());
            objCoder.setName(name);
            objCoder.setAge(age);
            objCoder.setClan(clan);
            objCoderModel.update(objCoder);
        }
    }

    public static void findById(){
        CoderModel objCoderModel = new CoderModel();
        String name = JOptionPane.showInputDialog("Enter the name of the coder: ");
        String listaString = "COINCIDENCIAS \n";
        for (Coder iterador : objCoderModel.findByName(name)){
            listaString += iterador.toString();
        }
        JOptionPane.showMessageDialog(null, listaString);
    }

}
