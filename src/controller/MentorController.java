package controller;

import dao.*;
import model.MentorModel;
import model.StudentModel;
import view.AdminView;
import view.MentorView;

import java.sql.Connection;
import java.util.Set;

public class MentorController {
    private Connection connection;
    private LoginDB loginDB;
    private OpenCloseConnectionWithDB connectionWithDB;
    private MentorDB mentorDB;
    private QuestController quest = new QuestController();
    private MentorView mentorView;
    private String HEADER = "======= HELLO-MENTOR =======\n";
    private String HEADER2 = "Choose what atribute you want to edit";
    private final String[] OPTIONS = {"Create Student",
            "Edit Student", "Create new quest", "Create new artifact", "Edit information about quest",
            "Edit information about artifact", "Exit"};
    private final String[] OPTIONS2 = {"Login", "Password", "Name",
            "Surname", "Email"};

    // private WalletModel wallet;
//    private MentorView view;

    public MentorController(Connection newConnection) {
        this.loginDB = new LoginDBImplement(newConnection);
        this.connectionWithDB = new OpenCloseConnectionWithDB();
        this.connection = newConnection;
        this.mentorDB = new MentorDBImplement();
        // this.wallet = new WalletModel();
        this.mentorView = new MentorView();
    }

    //  public void run(String id) {
//      boolean mentorControllerRunning = true;
    public void run(String id) {
        mentorView.displayMenu(HEADER, OPTIONS);
        Integer option = 1;

        while (!(option == 0)) {
            InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    this.createStudent();
                    break;
                case 2:
                    break;
                case 0:
                    connectionWithDB.closeConnection(connection);
                    MentorView.displayText("Good bye");
                    break;
            }
        }
    }


    public void createStudent() {
        String id = loginDB.getLastId();
        String login = InputController.getString("Please enter mentor login: ");
        String password = InputController.getString("Please enter mentor password: ");
        String name = InputController.getString("Please enter mentor name: ");
        String lastName = InputController.getString("Please enter mentor lastName: ");
//        String group = setGroupForMentor(getExistingGroups(admin));
        StudentModel newStudent = new StudentModel(id, login, password, name, lastName);
        loginDB.saveNewUserToDatabase(newStudent);
        MentorView.displayText("Mentor created successfully");
    }
}

//   public void changeGroup() {
//   }

//   public void addNewQuest() {
//   }

//   public void addArtefactToStore() {
//   }

//   public void updateQuest() {
//   }

//   public void updateArtifact() {
//   }

//   public void splitArtifactToCategory() {
//   }

//   public void splitQuestToCategory() {
//   }

//   public void markStudentAchievedQuest() {
//   }

//   public void markStudentBoughtArtifact() {
//   }

//   public void displayInfo() {
//   }
