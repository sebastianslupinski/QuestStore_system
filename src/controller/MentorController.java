package controller;

import java.util.ArrayList;
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
import view.QuestView;

import java.sql.Connection;

public class MentorController {

    private Connection connection;
    private OpenCloseConnectionWithDB connectionWithDB;
    private LoginDB loginDB = new LoginDBImplement();
    private MentorDBImplement mentorDB = new MentorDBImplement();
    private QuestController quest = new QuestController();
    private QuestView viewQuest = new QuestView();
    private MentorView view = new MentorView();
    private String HEADER = "======= HELLO-MENTOR =======\n";
    private String HEADER2 = "Choose what atribute you want to edit";
    private final String[] OPTIONS = {"Create Student",
            "Edit Student", "Create new quest", "Create new artifact", "Display all quests", "Edit information about quest",
            "Display all artifacts", "Edit information about artifact", "Exit"};
    private final String[] OPTIONS2 = {"Login", "Password", "Name",
            "Surname", "Email"};


    public MentorController(Connection newConnection) {
        this.loginDB = new LoginDBImplement(newConnection);
        this.connectionWithDB = new OpenCloseConnectionWithDB();
        this.connection = newConnection;
        this.mentorDB = new MentorDBImplement();
        // this.wallet = new WalletModel();
        this.view = new MentorView();
    }


    public void run(String id) {
        Integer option = 1;

        while (!(option == 0)) {
            view.displayMenu(HEADER, OPTIONS);
            option = InputController.getNumber("Choose option: ");
            switch (option) {
            case 1:
                System.out.println("/////create student/////");
                break;
            case 2:
                System.out.println("/////Edit Student/////");
                break;
            case 3:
                System.out.println("/////Create new quest/////");
                quest.createQuest();
                break;
            case 4:
                System.out.println("/////Create new artifact/////");
                break;
            case 5:
                System.out.println("/////Display all quests/////");
                break;
            case 6:
                System.out.println("/////Edit information about ques/////");
                break;
            case 7:
                System.out.println("/////Display all artifact/////");
                break;
            case 8:
                System.out.println("/////Edit information about artifact/////");
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
