package controller;

import dao.LoginDB;
import dao.LoginDBImplement;
import dao.OpenCloseConnectionWithDB;
import dao.StudentDB;
import dao.StudentDBImplement;
import dao.MentorDB;
import model.MentorModel;
import view.AdminView;
import view.MentorView;
import dao.MentorDBImplement;

import java.sql.Connection;

public class MentorController {

    private Connection connection;
    private LoginDB loginDB;
    private OpenCloseConnectionWithDB connectionWithDB;
    private MentorDB mentorDB;
    // private WalletModel wallet;
    private MentorView view;
    private final String HEADER = "======= HELLO-MENTOR =======\n";
    private final String[] OPTIONS = {"Display my profile", "Display students", "Display quests"};

    public MentorController(Connection newConnection) {
        this.loginDB = new LoginDBImplement(newConnection);
        this.connectionWithDB = new OpenCloseConnectionWithDB();
        this.connection = newConnection;
        this.mentorDB = new MentorDBImplement();
        // this.wallet = new WalletModel();
        this.view = new MentorView();
    }

    public void run(String id) {
        view.displayMentorMenu();
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
