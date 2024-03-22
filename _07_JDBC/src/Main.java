import javax.swing.JOptionPane;

import controller.CoderController;


public class Main {
    public static void main(String[] args) {
        
       int option = 0;

       do {

            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. List Coders
                    2. Insert Coder
                    3. Update Coder
                    4. Delete Coder
                    5. Get coder by name
                    6. Exit

                    Ingresa una opción
                    """));
        

                    switch (option) {
                        case 1:
                                CoderController.getAll();                
                            break;
                        case 2:
                            CoderController.create();
                            break;
                        case 3:
                            CoderController.update();
                            break;
                        case 4:
                            CoderController.delete();
                            break;
                        case 5:
                            CoderController.findById();

                            break;
                    }
       } while (option != 6);


    }
}