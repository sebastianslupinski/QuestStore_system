package controller;

import model.MentorModel;
import view.MentorView;
import dao.UserDAOImplement;

public class MentorController {

  // public MentorDAOImplement newMentorDAO = new MentorDAOImplement();
  // private MentorModel model = newMentorDAO.readDataFromFile();
  MentorView view = new MentorView();

  // public MentorController() {
  //   this.model = model;
  //   this.view = view;
  // }

  public void run(String id) {
    view.displayText("Choose option:\n");
    view.displayMentorMenu();
  
    String option = "2";

    switch (option) {
      case "1":
        // createStudent();
        break;
      case "2":
        System.out.println("Tutaj kolejna opcja");
        break;
      case "3":
        System.out.println("ETC.");
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

// }
