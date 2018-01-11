package controller;
import view.*;
import models.*;

public class AdminController {
  private AdminModel model;
  private AdminView view;

  public AdminController(AdminModel model, AdminView view) {
    this.model = model;
    this.view = view;
  }

  public createMentor() {
    String login = view.getInput("Please enter mentor login: ");
    String password = view.getInput("Please enter mentor password: ");
    String name = view.getInput("Please enter mentor name: ");
    String lastName = view.getInput("Please enter mentor lastName: ");
    model.createMentor(login, password, name, lastName);
  }

  public createGroup() {
    String name = view.getInput("Please enter group name: ");
    model.createGroup(name);
  }

  /*public createLevels() {
  }*/
}
