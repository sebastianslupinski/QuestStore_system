package controller;

import models.*;
import view.*;
import dao.MentorDAOImplement;

public class MentorController {

  public MentorDAOImplement newMentorDAO = new MentorDAOImplement();
  private MentorModel model = newMentorDAO.readDataFromFile();
  private MentorView view = new MentorView();

  public MentorController() {
    this.model = model;
    this.view = view;
  }

  public void run() {
    view.displayText("Choose option:\n");
    view.displayMenu();
  
    String option = view.getInput();

    switch (option) {
      case "1":
        this.createStudent();
        break;
      case "2":
        System.out.println("Tutaj kolejna opcja");
        break;
      case "3":
        System.out.println("ETC.");
        break;
    }
  }

  public StudentModel createStudent() {
    StudentModel newStudent = new StudentModel("nowyStudent1", "haslo1", "student", "nowy");
    return newStudent;
  }

  public void changeGroup() {
  }

  public void addNewQuest() {
  }

  public void addArtefactToStore() {
  }

  public void updateQuest() {
  }

  public void updateArtifact() {
  }

  public void splitArtifactToCategory() {
  }

  public void splitQuestToCategory() {
  }

  public void markStudentAchievedQuest() {
  }

  public void markStudentBoughtArtifact() {
  }

  public void displayInfo() {
  }

}
