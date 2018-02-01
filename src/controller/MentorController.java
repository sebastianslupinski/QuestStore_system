package controller;

import dao.LoginDB;
import dao.LoginDBImplement;
import src.dao.MentorDB;
import src.dao.MentorDBImplement;
import view.MentorView;


public class MentorController {
    private LoginDB loginDB = new LoginDBImplement();
    private MentorDBImplement mentorDB = new MentorDBImplement();
    private QuestController quest = new QuestController();
    private MentorView view = new MentorView();
    private String HEADER = "======= HELLO-MENTOR =======\n";
    private String HEADER2 = "Choose what atribute you want to edit";
    private final String[] OPTIONS = {"Create Student",
            "Edit Student", "Create new quest", "Create new artifact", "Edit information about quest",
            "Edit information about artifact", "Exit"};
//    private final String[] OPTIONS2 = {"Login", "Password", "Name",
//            "Surname", "Email"};


    // public MentorController() {
  //   this.model = model;
  //   this.view = view;
  // }

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
              case 4:
                  System.out.println("tutaj bedzie create new artifact");
                  break;
              case 5:
                  System.out.println("tutaj bedzie edit quest");
                  break;
              case 6:
                  System.out.println("tutaj bedzie edit artifact");
                  break;
              case 7:
                  mentorControllerRunning = false;
                  System.out.println("PAPA"); // to implement
                  break;
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

}
