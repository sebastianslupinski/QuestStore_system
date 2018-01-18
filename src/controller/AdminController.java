package src.controller;

import src.view.*;
import src.models.*;
import src.dao.*;
import src.Levels;


public class AdminController{

  public AdminDAOImplement newAdminDAO = new AdminDAOImplement();
  private AdminModel model = newAdminDAO.readDataFromFile();
  private AdminView view = new AdminView();
  public Levels levels = new Levels();

  public void run() {
    boolean adminControllerRunning = true;
    while(adminControllerRunning){
    view.displayMenu();

    Integer option = view.getNumber("Choose option: ");
    switch (option) {
      case 1:
        this.createMentor();
        break;
      case 2:
        this.createGroup();
        break;
      case 3:
        this.assignMentorToGroup();
        break;
      case 4:
        this.editMentor();
        break;
      case 5:
        this.();
        break;
      case 6:
        adminControllerRunning = false;
        System.out.println("PAPA"); // to implement
        break;
      }
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
    model.getMentors().add(newMentor);
    MentorView.pressEnterToContinue("Mentor created successfully, press enter to continue");
  }

  public void createGroup() {
    String name = view.getInput("Please enter group name: ");
    GroupModel newGroup = new GroupModel(name);
    model.addGroup(newGroup);
    MentorView.pressEnterToContinue("Group created successfully, press enter to continue");
  }

  public GroupModel getGroup(){
    boolean groupNotChosen = true;
    Integer groupIndex = 0;
    while(groupNotChosen){
      view.displayGroups(model.getGroups());
      String userInput = view.getInput("Choose group number");
      groupIndex = Integer.parseInt(userInput);
      if (groupIndex < model.getGroups().size()) {
          groupNotChosen = false;
      }
    }
    return model.getGroups().get(groupIndex);

  }

  public MentorModel getMentor(){
    boolean mentorNotChosen = true;
    Integer mentorIndex = 0;
    while(mentorNotChosen){
      view.displayMentors(model.getMentors());
      mentorIndex = AdminView.getNumber("Please enter a mentor number");
      if (mentorIndex < model.getMentors().size()){
          mentorNotChosen = false;
      }
      else {
        MentorView.displayText("Wrong number");
      }
    }
    return model.getMentors().get(Integer.valueOf(mentorIndex));
  }

  public void editMentor() {
    boolean optionChosen = false;
    while(!optionChosen) {
      MentorModel mentorToEdit = getMentor();
      AdminView.chooseAtributeToEdit();
      Integer option = MentorView.getNumber("Enter your option");
      switch (option) {
        case 1:
          String newLogin = AdminView.getInput("Enter new login");
          mentorToEdit.setLogin(newLogin);
          optionChosen = true;
          break;
        case 2:
          String newPassword = AdminView.getInput("Enter new login");
          mentorToEdit.setPassword(newPassword);
          optionChosen = true;
          break;
        case 3:
          String newName = AdminView.getInput("Enter new name");
          mentorToEdit.setName(newName);
          optionChosen = true;
          break;
        case 4:
          String newLastName = AdminView.getInput("Enter new lastname");
          mentorToEdit.setLastName(newLastName);
          optionChosen = true;
          break;
        case 5:
          String newEmail = AdminView.getInput("Enter new email");
          mentorToEdit.setEmail(newEmail);
          optionChosen = true;
          break;
      }
    }
  }

  public void assignMentorToGroup(){
    if (checkIfGroupExist()){
    GroupModel groupToAssign = getGroup();
    MentorModel mentorToAssign = getMentor();
    groupToAssign.addMentor(mentorToAssign);
    view.displayText("Mentor assigned succesfully");
    }
  }

  public boolean checkIfGroupExist(){
    if(model.getGroups().size()<1){
      MentorView.displayText("Group need to be created first");
      return false;
    }
    return true;
  }

  public void createLevels() {
    levels.addLevels();
  }

}
