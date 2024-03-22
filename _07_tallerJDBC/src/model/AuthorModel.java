package model;

import database.CRUDAuthor;
import database.ConfigDB;
import entities.Author;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorModel implements CRUDAuthor {

    @Override
    public Object insertAuthor(Object obj) {
        Author author = (Author) obj;
        Connection objConnection = ConfigDB.openConnection();
        String sql = "INSERT INTO author (name, nationality) VALUES(?, ?);";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepared.setString(1, author.getName());
            objPrepared.setString(2, author.getNationality());
            objPrepared.execute();
            ResultSet objResult = objPrepared.getGeneratedKeys();
            if (objResult.next()) {
                author.setId(objResult.getInt(1));
            }
                JOptionPane.showMessageDialog(null, "The author was entered correctly");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return author;
    }

    @Override
    public List<Object> listAuthor() {
        List<Object> listAuthor = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();
        String sql = "SELECT * FROM author;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()){
                Author author = new Author();
                author.setId(objResult.getInt("id"));
                author.setName(objResult.getString("name"));
                author.setNationality(objResult.getString("nationality"));

                listAuthor.add(author);
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return listAuthor;
    }

    @Override
    public boolean updateAuthor(Object obj){
        boolean updateAuthor = false;
        Connection objConnection = ConfigDB.openConnection();
        Author objAuthor = (Author) obj;
        String sql = "UPDATE author SET name = ?, nationality = ? WHERE id = ?;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setString(1,objAuthor.getName());
            objPrepared.setString(2, objAuthor.getNationality());
            objPrepared.setInt(3, objAuthor.getId());

            int affectRows = objPrepared.executeUpdate();

            if (affectRows > 0){
                JOptionPane.showMessageDialog(null, "The author was successfully modified");
                updateAuthor = true;
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return updateAuthor;
    }

    @Override
    public boolean deleteAuthor(Object obj) {
        boolean deleteAuthor = false;
        Author objAuthor = (Author) obj;
        Connection objConnection = ConfigDB.openConnection();
        String sql = "DELETE FROM author WHERE id = ?;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1, objAuthor.getId());
            int affectRos = objPrepared.executeUpdate();
            if (affectRos > 0){
              deleteAuthor = true;
                JOptionPane.showMessageDialog(null, "The author was successfully removed");
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return deleteAuthor;
    }

    public Author findById(int id){
            Connection objConnection = ConfigDB.openConnection();
            Author objAuthor = null;
            String sql = "SELECT * FROM author WHERE id = ?;";
            try {
                PreparedStatement objPrepared = objConnection.prepareStatement(sql);
                objPrepared.setInt(1,id);
                ResultSet objResult = objPrepared.executeQuery();
                if (objResult.next()){
                    objAuthor = new Author();
                    objAuthor.setName(objResult.getString("name"));
                    objAuthor.setNationality(objResult.getString("nationality"));
                }
            }catch (SQLException error){
                JOptionPane.showMessageDialog(null, error.getMessage());
            }

        return objAuthor;
    }

}
