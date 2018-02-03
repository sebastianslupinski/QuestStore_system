package controller;

import java.util.ArrayList;
import dao.LoginDB;
import dao.LoginDBImplement;
import dao.QuestDBImplement;
import model.MentorModel;
import src.dao.MentorDB;
import src.dao.MentorDBImplement;
import view.AbstractView;
import view.MentorView;
import view.QuestView;


public class MentorController {

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
//    private final String[] OPTIONS2 = {"Login", "Password", "Name",
//            "Surname", "Email"};


    public void run(String id) {
        boolean mentorControllerRunning = true;
        while (mentorControllerRunning) {
            view.displayMenu(HEADER, OPTIONS);
            Integer option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    System.out.println("tutaj bedzie create student");
                    break;
                case 2:
                    System.out.println("tutaj bedzie edit student");
                    break;
                case 3:
                    quest.createQuest();
                    break;
                case 4:
                    System.out.println("tutaj bedzie create new artifact");
                    break;
                case 5:
                    System.out.println("tutaj bedzie display all quest");
                    quest.getInformationAboutAllQuests();
//                    QuestDBImplement questDB = new QuestDBImplement();
//                    ArrayList<String []> allQuests = questDB.getAllQuests();
//                    System.out.println(allQuests);
                    break;
                case 6:
                    System.out.println("tutaj bedzie edit quest");
                    quest.selectOneQuest();
                    break;
                case 7:
                    System.out.println("tutaj bedzie edit artifact");
                    break;
                case 8:
                    mentorControllerRunning = false;
                    System.out.println("PAPA"); // to implement
                    break;
            }
        }
    }
//
//    public MentorModel loadMentor(LoginDB database, String id) {
//        ArrayList<String[]> IdsLoginsAndPasswords = database.getExistingIdsLoginAndPasswords(2);
//        ArrayList<String[]> namesLastnamesEmails = database.getExistingNamesLastnamesAndEmails("mentors");
//        MentorModel mentor = null;
//        for (String[] userInfo : IdsLoginsAndPasswords) {
//            if (userInfo[0].equals(id)) {
//                String newId = userInfo[0];
//                String login = userInfo[1];
//                String password = userInfo[2];
//                for (String[] usersNames : namesLastnamesEmails) {
//                    if (usersNames[0].equals(id)) {
//                        String name = usersNames[1];
//                        String lastName = usersNames[2];
//                        String email = usersNames[3];
//                        mentor = new MentorModel(newId, login, password, name, lastName, email);
//                    }
//                }
//            }
//        }
//        return mentor;
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


