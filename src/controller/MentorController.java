package controller;

import dao.*;
import model.MentorModel;
import view.AdminView;
import view.MentorView;

import java.sql.Connection;

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
}

//   public createStudent(){
//     boolean studentNotAdded = true;
//     while(studentNotAdded){
//         String groupName = MentorView.getInput("Please enter name of group to add student")
//         for (Group group : guidedGroups){
//             if (group.name == groupName){
//                 group = group.name;
//                 studentNotAdded = false;
//             }
//             else{
//                 MentorView.displayText("There is no group like this.");
//             }
//         }
//     StudentModel newStudent = new StudentModel(login, password, name, lastName, group);
//     group.addStudent(newStudent);
//     MentorView.displayText("Student added succesfully.");
// }

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

// }
