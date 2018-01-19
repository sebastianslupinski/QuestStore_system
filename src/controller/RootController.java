package src.controller;

import src.view.*;
// import src.models.TestQuest;

import java.util.ArrayList;
import java.io.File;


public class RootController{

    // RootView rootView = new RootView();
    AdminController adminController = new AdminController();
    // MentorController mentorController = new MentorController();
    // StudentController studentController = new StudentController();

    public void startApplication(){
            // TestQuest testquest = new TestQuest();
            // testquest.createNewQuest();
        LoginController loginController = new LoginController();
        String[] idAndRole = loginController.processValidation();
    //     rootView.displayText("Welcome in QUESTSTORE");
    //     rootView.displayMenu();
    String id = idAndRole[0];
    String role = idAndRole[1];

    //     String option = rootView.getInput();

        switch (role) {
        case "A":
            adminController.run(id);
            break;
    //     case "2":
    //         mentorController.run();
    //         break;
    //     case "3":
    //         // studentController.run();
    //         break;
        }
    }
}
