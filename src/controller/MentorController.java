package src.controller;

import src.model.*;
import src.view.*;
import src.dao.UserDAOImplement;

public class MentorController {

  // public MentorDAOImplement newMentorDAO = new MentorDAOImplement();
  MentorModel model;
  MentorView view;
  public MentorController() {
    this.model = new MentorModel("10", "testMentor", "password101", "testowy", "mentor", "A");
    this.view = new MentorView();
  }

  public void run(String id) {
    view.displayText("Choose option:\n");
    view.displayMentorMenu();
  
    String option = "2";

    switch (option) {
      case "1":
        // createStudent();
        break;
      case "2":
        break;
      case "3":
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
