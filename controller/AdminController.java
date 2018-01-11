package controller;
import view.*;
import models.*;
import dao.*;


public class AdminController {

  public AdminDAOImplement newAdminDAO = new AdminDAOImplement();
  private AdminModel model = newAdminDAO.readDataFromFile();
  private AdminView view = new AdminView();

  public void run() {
    view.displayMenu();

    String option = view.getInput();
    switch (option){
      case "1":
        this.createMentor();
      case "2":
        this.createGroup();
      case "3":
        this.assignMentorToGroup();
      case "4":
        System.out.println("Show mentor profile"); // to implement
      case "5":
        System.out.println("PAPA"); // to implement
    }
  }

  public void AdminController(AdminModel model, AdminView view) {
    this.model = model;
    this.view = view;
  }

  public void createMentor() {
    String login = view.getInput("Please enter mentor login: ");
    String password = view.getInput("Please enter mentor password: ");
    String name = view.getInput("Please enter mentor name: ");
    String lastName = view.getInput("Please enter mentor lastName: ");
    MentorModel newMentor = new MentorModel(login, password, name, lastName);
    // it has to be add to list that we do not have yet
  }

  public void createGroup() {
    String name = view.getInput("Please enter group name: ");
    model.createGroup(name);
  }

  public void assignMentorToGroup() {
    System.out.println("Assign mentor to the group"); // to implement
  }
}
