package src.controller;
import src.view.*;
import src.models.*;
import src.dao.*;


public class AdminController{

  public AdminDAOImplement newAdminDAO = new AdminDAOImplement();
  private AdminModel model = newAdminDAO.readDataFromFile();
  private AdminView view = new AdminView();

  public void run() {
    boolean adminControllerRunning = true;
    while(adminControllerRunning){
    view.displayMenu();

    Integer option = view.getNumber(" ");
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
        System.out.println("Show mentor profile"); // to implement
        break;
      case 5:
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
      if (mentorIndex.equals(model.getMentors().size())){
          mentorNotChosen = false;
      }
  }
  return model.getMentors().get(Integer.valueOf(mentorIndex));
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


}
