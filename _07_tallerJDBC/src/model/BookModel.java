package model;

import database.CRUDBook;
import database.ConfigDB;
import entities.Author;
import entities.Book;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookModel implements CRUDBook {
    @Override
    public Object insertBook(Object obj) {
        Book objBook = (Book) obj;
        Connection objConnection = ConfigDB.openConnection();
        String sql = "INSERT INTO book (title, publicationYear, price, id_author) VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepared.setString(1,  objBook.getTitle());
            objPrepared.setInt(2,  objBook.getAgeOfPublication());
            objPrepared.setDouble(3,  objBook.getPrice());
            objPrepared.setInt(4,  objBook.getIdAuthor());

            objPrepared.execute();
            ResultSet objResult = objPrepared.getGeneratedKeys();
            while (objResult.next()) {
                objResult.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "The book was entered correctly");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return objBook;
    }

    public List<Object> listBook() {
        List<Object> listBook = new ArrayList<>();


        Connection objConnection = ConfigDB.openConnection();
        String sql = "SELECT * FROM book;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()){
                Book objBook = new Book();
                Author objAuthor = new Author();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setAgeOfPublication(objResult.getInt("publicationYear"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setIdAuthor(objResult.getInt("id_author"));
                listBook.add(objBook);
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return listBook;
    }


    public List<Object> listBookAndAuthor() {
        List<Object> listBook = new ArrayList<>();

        Connection objConnection = ConfigDB.openConnection();
        String sql = "SELECT * FROM book INNER JOIN author;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()){
                Book objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setAgeOfPublication(objResult.getInt("publicationYear"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setIdAuthor(objResult.getInt("id_author"));

                listBook.add(objBook);

            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return listBook;
    }

    @Override
    public boolean updateBook(Object obj) {
        boolean updateBook = false;
        Connection objConnection = ConfigDB.openConnection();
        Book objBook = (Book) obj;
        String sql = "UPDATE book SET title = ?, publicationYear = ?, price = ?, id_author = ? WHERE id = ?;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setString(1,objBook.getTitle());
            objPrepared.setInt(2, objBook.getAgeOfPublication());
            objPrepared.setDouble(3, objBook.getPrice());
            objPrepared.setInt(4, objBook.getIdAuthor());

            objPrepared.setInt(5, objBook.getId());

            int affectRows = objPrepared.executeUpdate();

            if (affectRows > 0){
                JOptionPane.showMessageDialog(null, "The book was successfully modified");
                updateBook = true;
            }

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return updateBook;
    }

    @Override
    public boolean deleteBook(Object obj) {
        boolean deleteBook = false;
        Book objBook = (Book) obj;
        Connection objConnection = ConfigDB.openConnection();
        String sql = "DELETE FROM book WHERE id = ?;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1, objBook.getId());
            int affectRos = objPrepared.executeUpdate();
            if (affectRos > 0){
                deleteBook = true;
                JOptionPane.showMessageDialog(null, "The book was successfully removed");
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return deleteBook;
    }

    public Book findById(int id){
        Connection objConnection = ConfigDB.openConnection();
        Book objBook = null;
        String sql = "SELECT * FROM book WHERE id = ?;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1,id);
            ResultSet objResult = objPrepared.executeQuery();
            if (objResult.next()){
                objBook = new Book();
                objBook.setTitle(objResult.getString("title"));
                objBook.setAgeOfPublication(objResult.getInt("publicationYear"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setIdAuthor(objResult.getInt("id_author"));
            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        return objBook;
    }

    public List<Book> findByIdAndAuthor(int id){
        List<Book> objList = new ArrayList<>();
        Book objBook = null;
        Connection objConnection = ConfigDB.openConnection();
        String sql = "SELECT *  FROM book WHERE id_author = ?;";
        try {
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1, id);
            ResultSet objResult = objPrepared.executeQuery();
            while (objResult.next()){
                objBook = new Book();
                objBook.setId(objResult.getInt("id"));
                objBook.setTitle(objResult.getString("title"));
                objBook.setAgeOfPublication(objResult.getInt("publicationYear"));
                objBook.setPrice(objResult.getDouble("price"));
                objBook.setIdAuthor(objResult.getInt("id_author"));
                objList.add(objBook);
            }
        } catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return objList;
    }
}
