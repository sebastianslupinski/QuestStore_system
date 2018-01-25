package controller;

import view.RootView;


public class RootController{

    RootView rootView = new RootView();
    AdminController adminController = new AdminController();
    // MentorController mentorController = new MentorController();
    //StudentController studentController = new StudentController();

    public void startApplication(){
 
        rootView.displayMenu();
        LoginDBController loginController = new LoginDBController();
        String[] idAndRole = loginController.processValidation();
        String id = String.valueOf(idAndRole[0]).toString();
        String role = String.valueOf(idAndRole[1]).toString();

        String option = role;

        switch (option) {
            case "1":
                adminController.run(id);
                break;
            // case "M":
            //     mentorController.run(id);
            //     break;
            // case "S":
            //     studentController.run(id);
            //     break;
        }
    }
}
