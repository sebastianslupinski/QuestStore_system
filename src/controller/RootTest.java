package controller;

import dao.AdminDBImplement;
import dao.LoginDBImplement;
import view.RootView;

public class RootTest {

    RootView rootView = new RootView();
    AdminDBImplement adminDB = new AdminDBImplement();


    //AdminController adminController = new AdminController();
    //MentorController mentorController = new MentorController();
    //StudentController studentController = new StudentController();

    public void startApplication() {

        rootView.displayMenu();
//        LoginDBController loginController = new LoginDBController();
        adminDB.findAllDataOfAdmin(1);
        System.out.println("TESTING INSERT");
        adminDB.insertAdminData("Jan", "Kowalski", "jan.kowalski@cc.com");
    }
}