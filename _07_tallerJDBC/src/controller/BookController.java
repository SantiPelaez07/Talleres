package controller;


import entities.Book;
import model.BookModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    public static void createBook() {
        BookModel objModel = new BookModel();

        String title = JOptionPane.showInputDialog("Enter the title of the new book: ");
        int ageOfPublication = Integer.parseInt(JOptionPane.showInputDialog("Enter the age of the publication of new book: "));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price of the new book: "));
        int idAuthor = Integer.parseInt(JOptionPane.showInputDialog("Enter the identifier of the author of the book you wish to associate the book with.: "));


        Book objBook = new Book();
        objBook.setTitle(title);
        objBook.setAgeOfPublication(ageOfPublication);
        objBook.setPrice(price);
        objBook.setIdAuthor(idAuthor);
        objBook = (Book) objModel.insertBook(objBook);
        JOptionPane.showMessageDialog(null, objBook.toString());
    }

    public static void listBook() {
        BookModel objModel = new BookModel();
        String listBook = "List Book's 👨‍⚖️\n";
        for (Object i : objModel.listBook()) {
            Book objBook = (Book) i;
            listBook += objBook.toString();
        }
        JOptionPane.showMessageDialog(null, listBook);
    }

    public static String listBookString() {
        BookModel objModel = new BookModel();
        String listBook = "List Book's 👨‍⚖️\n";
        for (Object i : objModel.listBook()) {
            Book objBook = (Book) i;
            listBook += objBook.toString();
        }
        return listBook;
    }

    public static String listBookAndAuthor() {
        BookModel objModel = new BookModel();
        String listBookandAuthor = "List Book's and Author's 👨‍⚖️\n";
        for (Object i : objModel.listBookAndAuthor()) {
            Book objBook = (Book) i;
            listBookandAuthor += objBook.toString();
        }
        JOptionPane.showMessageDialog(null, listBookandAuthor);
        return listBookandAuthor;
    }

    public static void updateBook() {
        BookModel objModel = new BookModel();
        Book objBook = new Book();
        String listBook = listBookString();
        int idUpdateBook = Integer.parseInt(JOptionPane.showInputDialog(listBook + "\nEnter the id of the book to modify: "));
        objBook = objModel.findById(idUpdateBook);
        if (objBook == null) {
            JOptionPane.showMessageDialog(null, "Book not found.");
        } else {
            String title = JOptionPane.showInputDialog(null, "Enter the book of new title: ", String.valueOf(objBook.getTitle()));
            int ageOfPublication = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the age of publication of the new book: ", String.valueOf(objBook.getAgeOfPublication())));
            double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter price of the book: ", String.valueOf(objBook.getPrice())));
            int idAuthor = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id of Author with the asociate of book: ", String.valueOf(objBook.getIdAuthor())));
            objBook.setTitle(title);
            objBook.setAgeOfPublication(ageOfPublication);
            objBook.setPrice(price);
            objBook.setIdAuthor(idAuthor);
            objModel.updateBook(objBook);
        }
    }


    public static void deleteBook() {
        BookModel objModel = new BookModel();
        String listBook = listBookString();
        int idDeleteBook = Integer.parseInt(JOptionPane.showInputDialog(listBook + "\nEnter the id of the book to delete: "));
        Book objBook = objModel.findById(idDeleteBook);
        if (objBook == null) {
            JOptionPane.showMessageDialog(null, "Book not found.");
        } else {
            int confirmAuthor = JOptionPane.showConfirmDialog(null, objBook.toString() + "\nAre you sure want to delete the Book?");
            if (confirmAuthor == 0) objModel.deleteBook(objBook);
        }
    }

    public static void findIdBookAndAuthor() {
        BookModel objModel = new BookModel();
        int idFindBook = Integer.parseInt(JOptionPane.showInputDialog("\nEnter the id of the book to consult: "));
        String listBook = String.valueOf(objModel.findById(idFindBook));
        if (listBook == null) {
            JOptionPane.showMessageDialog(null, "Id Author not found.");
        } else {
            for (Book iterador : objModel.findByIdAndAuthor(idFindBook)) {
                listBook += iterador.toString();
            }
            JOptionPane.showMessageDialog(null, listBook);
        }
    }

}
