package controller;

import dao.LoginDBImplement;
import view.RootView;

import java.sql.Connection;
import java.sql.SQLException;


public class RootControllerTestowe {

    RootView rootView = new RootView();
    LoginDBImplement loginDB = new LoginDBImplement();
    //AdminController adminController = new AdminController();
    //MentorController mentorController = new MentorController();
    //StudentController studentController = new StudentController();

    public void startApplication(){
 
        rootView.displayMenu();
//        Connection c = loginDB.createConnection();
        System.out.println("AKUKU METODA FIND"+"\n");
        loginDB.findUserIdAndRole("admin", "admin");
        System.out.println("Mamy tabelkę");
        System.out.println("\n");

        System.out.println("AKUKU METODA UPDATE"+"\n");
        loginDB.insertAllLoginData("Ania","anana", "2");
        System.out.println("Mamy tabelkę");
        System.out.println("\n");

        System.out.println("AKUKU METODA INSERT"+"\n");
        loginDB.updateUserLoginAndPassword("Anna","A3mna",11);
        System.out.println("Mamy tabelkę");
        System.out.println("\n");





//        LoginController loginController = new LoginController();
//        String[] idAndRole = loginController.processValidation();
//        String id = idAndRole[0];
//        String role = idAndRole[1];
//
//        String option = role;
//
//        switch (option) {
//            case "A":
//                adminController.run(id);
//                break;
//            // case "M":
//            //     mentorController.run(id);
//            //     break;
//            // case "S":
//            //     studentController.run(id);
//            //     break;
        }
    }

