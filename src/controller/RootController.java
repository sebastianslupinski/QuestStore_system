package controller;

import view.RootView;


public class RootController{

    private RootView rootView = new RootView();
    private AdminController adminController = new AdminController();
    private MentorController mentorController = new MentorController();
//    StudentController studentController = new StudentController();

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
             case "2":
                 mentorController.run(id);
                 break;
            // case "3":
            //     studentController.run(id);
            //     break;
        }
    }
}
