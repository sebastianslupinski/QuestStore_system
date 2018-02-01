package controller;

import view.StudentView;
import model.StudentModel;
import dao.LoginDB;
import dao.LoginDBImplement;
import dao.StudentDB;
import dao.StudentDBImplement;

import java.sql.Connection;

public class StudentController {

    private LoginDB loginDB;
    private StudentDB adminDB;
    // private WalletModel wallet;
    private StudentView view;
    private final String HEADER = "======= HELLO-STUDENT =======\n";
    private final String[] OPTIONS = {"Display my profile", "Display my items", "Display quests"};

    public StudentController(Connection newConnection) {
        this.loginDB = new LoginDBImplement(newConnection);
        this.adminDB = new StudentDBImplement();
        // this.wallet = new WalletModel();
        this.view = new StudentView();
    }

    public void run(String id) {
        //StudentModel student = this.loadStudent(loginDB, id);
        Integer option = null;
        while (!(option == 0)) {
            view.displayMenu(HEADER, OPTIONS);
            option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    //view.displayStudentData(student.toString(), wallet.toString());
                    break;
                case 2:
                    //this.displayStudentItems();
                    break;
                case 3:
                    //this.displayQuests();
                    break;
                case 4:
                    break;
                case 0:
                    view.displayText("Good bye");
                    break;
            }
        }
    }
}