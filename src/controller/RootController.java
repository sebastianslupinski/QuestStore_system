package src.controller;

import src.view.*;
import src.models.TestQuest;

import java.util.ArrayList;
import java.io.File;


public class RootController{

    // RootView rootView = new RootView();
    // AdminController adminController = new AdminController();
    // MentorController mentorController = new MentorController();
    // StudentController studentController = new StudentController();

    public void startApplication(){
            TestQuest testquest = new TestQuest();
            testquest.createNewQuest();
        // LoginController loginController = new LoginController();
        // String[] idAndRole = loginController.processValidation();
    //     rootView.displayText("Welcome in QUESTSTORE");
    //     rootView.displayMenu();

    //     String option = rootView.getInput();

    //     switch (option) {
    //     case "1":
    //         adminController.run();
    //         break;
    //     case "2":
    //         mentorController.run();
    //         break;
    //     case "3":
    //         // studentController.run();
    //         break;
    //     }
    }
}
