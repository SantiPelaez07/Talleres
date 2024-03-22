package model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;

import database.CRUD;
import database.ConfigDB;
import entity.Coder;

public class CoderModel implements CRUD {

    @Override
    public List<Object> findAll() {
        //1.  Crear una lista para guardar lo que nos devuelve la base de datos
        List<Object> listCoders = new ArrayList<>();
        //2. Abrir la conexión con la base de datos
        Connection objConnection = ConfigDB.openConnection();
        //3. Controlar los errores
        try {
            //4. Escribimos el query en SQL
            String sql= "SELECT * FROM coder;";
            //5. Usar el prepared Statement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //6. Ejecutar el query y recibir el resultado 
            ResultSet objResult = objPrepare.executeQuery();
            //7. Mientras haya un resultado siguiente, hacer:
            while (objResult.next()) {
                //7.1 Crear coder
                Coder objCoder = new Coder();

                //7.2 LLenar el objeto de información de la base de datos del objeto que está iterando
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setId(objResult.getInt("id"));
                objCoder.setClan(objResult.getString("clan"));

                //7.3  Agregamos el coder  la lista
                listCoders.add(objCoder);

            }
            

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), null, 0);

            // TODO: handle exception
        }

        //8. Cerrar la conexión
        ConfigDB.closeConecction();
        return listCoders;
    }

    @Override
    public Object insert(Object obj) {
        //1. Abrimos la conexión
        Connection objConnection = ConfigDB.openConnection();

        //Convertir el obj que llegó a Coder por parámetro
        Coder objCoder = (Coder) obj;

        try {
            //2. Escrbir el SQL
            String sql = "INSERT INTO coder (name,age,clan) VALUES (?,?,?);";
            //3. Preparar el PreparedStatement
            // Parámetros de preparedStatement, recibe el código sql y retorna los di's
            //PreparedStatement nos permite preparar el sql y tenerlo ahí para ejecutarlo
            //4. Preparar el PreparedStatement, además agregar la propiedad RETURN_GENERATED_KEYS que hace que la sentencia SQL nos retorne los id generados  por la Base de Datos
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);




            //5. Asignar valor a los ?,?,?
            objPrepare.setString(1,objCoder.getName());
            objPrepare.setInt(2,objCoder.getAge());
            objPrepare.setString(3,objCoder.getClan());

            //6. Ejecutar el query
            objPrepare.execute();

            //7. Obtener el resultado con los id (Llaves generadas)
            ResultSet objResult = objPrepare.getGeneratedKeys();


            //8. Iterar mientras haya un regístro
            while (objResult.next()){
                //Podemos obtener el valor también con índices
                objCoder.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Coder insertion was successful");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        ConfigDB.closeConecction();
        return objCoder;
    }

    @Override
    public boolean update(Object obj) {
            //1. Abrir la conexión
            Connection objConnection = ConfigDB.openConnection();
            //2. Convierto  el parámetro a tipo coder
            Coder objCoder = (Coder) obj;
            //3. Variablepara conocer el estado de la acción
            boolean isUpdated = false;
            try {
                //4. Crear la sentencia SQL
                String sql = "UPDATE coder SET name = ?, age = ?, clan = ? WHERE id = ?;";
                //5. Crear el statement
                PreparedStatement objPrepared = objConnection.prepareStatement(sql);

                //6. Asignar valor  los parámetro del Query
                objPrepared.setString(1, objCoder.getName());
                objPrepared.setInt(2, objCoder.getAge());
                objPrepared.setString(3, objCoder.getClan());
                objPrepared.setInt(4, objCoder.getId());

                //7. Ejecutar el query
                int totalRowAffected = objPrepared.executeUpdate();
                if (totalRowAffected > 0) {
                    isUpdated = true;
                    JOptionPane.showMessageDialog(null, "The update was successful.");
                }

            }catch (SQLException error){
                JOptionPane.showMessageDialog(null, "Error: " + error.getMessage());
            } finally {
                //8. Finally = que se ejecute pase lo que pase
                ConfigDB.closeConecction();
            }
            return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        //1. Convertir el objeto a coder
        Coder objCoder = (Coder) obj;

        //2. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        //3. Crear una variable del estado de eliminación
        boolean isDelete = false;

        try {
            //4. Escribir la sentencia SQL
            String sql = "DELETE FROM coder WHERE id = ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //5. Dar valor al signo de interrogación
            objPrepared.setInt(1, objCoder.getId());

            //6. Ejecutmos el query (ExecuteUpdate) devuelve el número de registros afectados
            int totalAfectedRows = objPrepared.executeUpdate();


            //Si las filas afectdas son mayores a cero
            if (totalAfectedRows > 0){
                //6. S i las filas afectadas fueron mayor a cero quierec edur
                isDelete = true;
                JOptionPane.showMessageDialog(null, "The delete was successful");
            }


        } catch (SQLException error){
                JOptionPane.showMessageDialog(null, error.getMessage());
        }


        ConfigDB.closeConecction();
        return isDelete;
    }

    public Coder findById (int id){

        //1. Abrir la conexión
        Connection objConnection = ConfigDB.openConnection();

        //2. Crear el coder que vamos a retornar
        Coder objCoder = null;

        try {
        //3. Sentencia SQL
            String sql = "SELECT * FROM coder WHERE id = ?;";

            //4. Preparamos el statement
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);

            //5. Darle valor al parámetro del query
            objPrepared.setInt(1,id);

            ResultSet objResult = objPrepared.executeQuery();

            if (objResult.next()){
                objCoder = new Coder();
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setClan(objResult.getString("clan"));
                objCoder.setId(objResult.getInt("id"));
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,  e.getMessage());
        }
        ConfigDB.closeConecction();
        return  objCoder;
    }

    public List<Coder> findByName(String name){
        List<Coder> listCoder = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM coder WHERE name like ?;";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setString(1, '%'+name+'%');
            ResultSet objResult = objPrepared.executeQuery();

            while (objResult.next()){
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                listCoder.add(objCoder);
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        ConfigDB.closeConecction();
        return listCoder;
    }


}
