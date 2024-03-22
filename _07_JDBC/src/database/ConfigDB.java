package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Este atributo tendrá el estado de la conexión.
    static Connection objConnection = null;

    //Método para conectar la DB

    public static Connection openConnection(){

        try {
            //Lllamamos el driver
           Class.forName("com.mysql.cj.jdbc.Driver");

           // Creamos las variables de conexión
            // servidor:puerto/nombre base de datos
            String url = "jdbc:mysql://localhost:3306/_01_jdbc_lovelace";
            String user = "root";
            String password = "";

            //Establecer la conexión
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Me conecté perfectamente!!!!");


        } catch (ClassNotFoundException error){
            System.out.println("Error, driver no instalado " + error.getMessage());
        } catch (SQLException error){
            System.out.println("Error >> Error al conectar la base de datos " + error.getMessage());
        }

        return objConnection;
    }


    //Método para finalizar una conexión

    public static void closeConecction(){
        try {
            if (objConnection != null) objConnection.close();
        } catch (SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
    }


}
