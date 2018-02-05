package controller;

import dao.OpenCloseConnectionWithDB;
import view.RootView;

import java.sql.Connection;


public class RootController{

    RootView rootView = new RootView();
    OpenCloseConnectionWithDB connectionWithDB = new OpenCloseConnectionWithDB();
    Connection newConnection = connectionWithDB.getConnection();
    LoginDBController loginController = new LoginDBController(newConnection);

    public void startApplication(){
 
        rootView.displayMenu();
        String[] idAndRole = loginController.processValidation();
        String id = String.valueOf(idAndRole[0]).toString();
        String role = String.valueOf(idAndRole[1]).toString();

        String option = role;
        switch (option) {
            case "1":
                AdminController adminController = new AdminController(newConnection);
                adminController.run(id);
                break;
            case "2":
//                MentorController mentorController = new MentorController(newConnection);
//                mentorController.run(id);
                break;
            case "3":
                StudentController studentController = new StudentController(newConnection);
                studentController.run(id);
                break;
        }
    }
}
