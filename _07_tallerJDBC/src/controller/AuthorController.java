package controller;

import entities.Author;
import model.AuthorModel;

import javax.swing.*;

public class AuthorController {
    public static void create(){
        AuthorModel objModel = new AuthorModel();

        String name = JOptionPane.showInputDialog("Enter the name of the new author: ");
        String nationality = JOptionPane.showInputDialog("Enter the nationality of the new author: ");

        Author objAuthor = new Author();
        objAuthor.setName(name);
        objAuthor.setNationality(nationality);

        objAuthor = (Author) objModel.insertAuthor(objAuthor);
        JOptionPane.showMessageDialog(null, objAuthor.toString());
    }

    public static void listAuthor(){
        AuthorModel objModel = new AuthorModel();
        String listAuthors = "List Author's 👨‍⚖️\n";
        for (Object i : objModel.listAuthor()){
            Author objAuthor = (Author) i;
            listAuthors += objAuthor.toString();
        }
        JOptionPane.showMessageDialog(null, listAuthors);
    }



    public static String listAuthorString(){
        AuthorModel objModel = new AuthorModel();
        String listAuthor = "List Author's 👨‍⚖️\n";
        for (Object i : objModel.listAuthor()){
            Author objAuthor = (Author) i;
            listAuthor += objAuthor.toString();
        }
        return listAuthor;
    }

    public static void updateAuthor(){
        AuthorModel objModel = new AuthorModel();
        Author objAuthor = new Author();
        String listAuthor = listAuthorString();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(listAuthor + "\nEnter the id of the author to modify: "));
        objAuthor = objModel.findById(idUpdate);
        if (objAuthor == null){
            JOptionPane.showMessageDialog(null, "Author not found.");
        }else {
            String name = JOptionPane.showInputDialog(null, "Enter the author's new name: ", String.valueOf(objAuthor.getName()));
            String nationality = JOptionPane.showInputDialog(null,  "Enter the author's new nationality: ", String.valueOf(objAuthor.getNationality()));
            objAuthor.setName(name);
            objAuthor.setNationality(nationality);
            objModel.updateAuthor(objAuthor);
        }
    }

    public static void deleteAuthor(){
        AuthorModel objModel = new AuthorModel();
        String listAuthor = listAuthorString();
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listAuthor + "\nEnter the id of the author to delete: "));
        Author objAuthor = objModel.findById(idDelete);
        if (objAuthor == null){
            JOptionPane.showMessageDialog(null, "Author not found.");
        }else {
            int confirmAuthor = JOptionPane.showConfirmDialog(null, objAuthor.toString()+"\nAre you sure want to delete the author?");
            if (confirmAuthor == 0) objModel.deleteAuthor(objAuthor);
        }
        }
    }
