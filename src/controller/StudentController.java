package controller;

import view.StudentView;
import model.StudentModel;
import dao.LoginDB;
import dao.LoginDBImplement;
import dao.StudentDB;
import dao.StudentDBImplement;

public class StudentController {

    private LoginDB loginDB = new LoginDBImplement();
    private StudentDB adminDB = new StudentDBImplement();
    //private WalletModel wallet = new WalletModel();
    private StudentView view = new StudentView();

    public void run(String id) {
        StudentModel student = this.loadStudent(loginDB, id);
        boolean adminControllerRunning = true;
        while (adminControllerRunning) {

            view.displayStudentMenu();
            Integer option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    //view.displayStudentData(student.toString(), wallet.toString());
                    break;
                case 2:
                    this.displayStudentItems();
                    break;
                case 3:
                    this.displayQuests();
                    break;
                case 4:
                    ;
                    break;
                case 5:
                    adminControllerRunning = false;
                    System.out.println("PAPA"); // to implement
                    break;
            }
        }
    }
}