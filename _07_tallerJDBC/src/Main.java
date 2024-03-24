import controller.AuthorController;
import controller.BookController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
    int option = 0;

    do {
        option = Integer.parseInt(JOptionPane.showInputDialog("""
                1. View Author's
                2. View Book's
                3. Consult books by an author
                4. Exit 
                
                
                Enter the desired option: 
                """));
        int optionAuthor = 0;
        int optionBook = 0;
        switch (option){
            case 1:
                do {
                    optionAuthor = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Insert new Author
                            2. List Author's available
                            3. Update Author
                            4. Delete Author
                            5. Exit
                            
                            Enter the desired option: 
                            """));

                    switch (optionAuthor){
                        case 1:
                                AuthorController.create();
                            break;
                        case 2:
                                AuthorController.listAuthor();
                            break;
                        case 3:
                                AuthorController.updateAuthor();
                            break;
                        case 4:
                                AuthorController.deleteAuthor();
                            break;
                    }
                }while (optionAuthor != 5);
                break;
            case 2:
                do {
                    optionBook = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Insert new Book
                            2. List Book's available
                            3. Update Book
                            4. Delete Book
                            5. Find Book's by name
                            6. Find Book's by id
                            7. Exit
                            
                            Enter the desired option: 
                            """));


                    switch (optionBook){
                        case 1:
                            BookController.createBook();
                            break;
                        case 2:
                            BookController.listBook();
                            break;
                        case 3:
                            BookController.updateBook();
                            break;
                        case 4:
                            BookController.deleteBook();
                            break;
                        case 5:
                            BookController.listBookAndAuthor();
                            break;
                    }

                }while (optionBook != 7);
            case 3:
                BookController.findIdBookAndAuthor();
                break;
        }
    }while (option != 4);
    }
}