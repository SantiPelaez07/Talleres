package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    static Connection objConnection = null;

    public static Connection openConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://bwehv9aweogcqdam1mvi-mysql.services.clever-cloud.com/bwehv9aweogcqdam1mvi";
            String user = "umrs8uq2d3fhtnut";
            String password = "abtcPWzbodUTJpm0CtDQ";
            objConnection = (Connection) DriverManager.getConnection(url, user,password);
        }catch (ClassNotFoundException error){
            System.out.println("Error driver no instalado: " + error.getMessage());
        }catch (SQLException error){
            System.out.println("Error >> Error al conectar a la base de datos " + error.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection !=null) objConnection.close();
        } catch (SQLException error){
            System.out.println("Error: " + error.getMessage());
        }
    }

}
