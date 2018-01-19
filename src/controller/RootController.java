package src.controller;

import src.view.*;
import src.models.TestQuest;

import java.util.ArrayList;
import java.io.File;


public class RootController{

    RootView rootView = new RootView();
    AdminController adminController = new AdminController();
    MentorController mentorController = new MentorController();
    StudentController studentController = new StudentController();

    public void startApplication(){
 
        rootView.displayMenu();
        LoginController loginController = new LoginController();
        String[] idAndRole = loginController.processValidation();
        String id = idAndRole[0];
        String role = idAndRole[1];

        String option = role;

        switch (option) {
            case "A":
                adminController.run(id);
                break;
            case "M":
                mentorController.run(id);
                break;
            case "S":
                studentController.run(id);
                break;
        }
    }
}
