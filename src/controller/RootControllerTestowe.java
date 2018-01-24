package controller;

import dao.LoginDBImplement;
import view.RootView;

import java.sql.Connection;


public class RootControllerTestowe {

    RootView rootView = new RootView();
    LoginDBImplement loginDB = new LoginDBImplement();
    //AdminController adminController = new AdminController();
    //MentorController mentorController = new MentorController();
    //StudentController studentController = new StudentController();

    public void startApplication(){
 
        rootView.displayMenu();
        Connection c = loginDB.createConnection();
        System.out.println("AKUKU");

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

