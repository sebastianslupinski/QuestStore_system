package controller;

import view.AdminView;
import model.AdminModel;
import model.MentorModel;
import dao.*;

import java.util.ArrayList;


public class AdminController {

  public UserDAOImplement newAdminDAO = new UserDAOImplement();
  private ArrayList users = newAdminDAO.readDataFromFile();
  private LoginDAOImplement loginDAO = new LoginDAOImplement();
  private AdminView view = new AdminView();
  private InputController inputController = new InputController();

  public void run(String id) {
    AdminModel admin = this.createAdmin(users, id);
    this.addExistingMentors(users, admin);
    boolean adminControllerRunning = true;
    while(adminControllerRunning){
    view.displayAdminMenu();

    Integer option = inputController.getNumber("Choose option: ");
    switch (option) {
      case 1:
        //this.createMentor();
        break;
      case 2:
        // this.createGroup();
        break;
      case 3:
        // this.assignMentorToGroup();
        break;
      case 4:
        // this.editMentor();
        break;
      case 5:
        adminControllerRunning = false;
        System.out.println("PAPA"); // to implement
        break;
    }
  }
}

  public AdminModel createAdmin(ArrayList<String[]> users, String id){
    AdminModel admin = null;
    for (String[] userInfo : users){
      if (userInfo[0] == id){
        int newId = userInfo[0];
        String[] userLoginInfo = loginDAO.getLoginAndPassword(id);
        String login = userLoginInfo[0];
        String password = userLoginInfo[1];
        String name = userInfo[1];
        String lastName = userInfo[2];
        String email = userInfo[3];
        admin = new AdminModel(newId, login, password, name, lastName, email);
      }
    }
    return admin;
  }

  public void addExistingMentors(ArrayList<String[]> users, AdminModel admin){
    MentorModel mentorToAdd = null;
    String role = null;
    String id = null;
    String name = null;
    String lastName = null;
    String email = null;
    String group = null;
    String login = null;
    String password = null;

    for (String[] userInfo : users){
      role = userInfo[4];
      if (userInfo.length==6 && role=="M") {
        id = userInfo[0];
        name = userInfo[1];
        lastName = userInfo[2];
        email = userInfo[3];
        group = userInfo[5];
        String[] userLoginInfo = loginDAO.getLoginAndPassword(id);
        login = userLoginInfo[0];
        password = userLoginInfo[1];
        mentorToAdd = new MentorModel(id, login, password, name, lastName, email, group);
        admin.addMentor(mentorToAdd);
        }
    }
  }

  // public void createMentor() {
  //   String login = inputController.getString("Please enter mentor login: ");
  //   String password = inputController.getString("Please enter mentor password: ");
  //   String name = inputController.getString("Please enter mentor name: ");
  //   String lastName = inputController.getString("Please enter mentor lastName: ");
  //   MentorModel newMentor = new MentorModel(login, password, name, lastName);
  //   model.getMentors().add(newMentor);
  //   MentorView.pressEnterToContinue("Mentor created successfully, press enter to continue");
  // }

  // public void createGroup() {
  //   String name = view.getString("Please enter group name: ");
  //   GroupModel newGroup = new GroupModel(name);
  //   model.addGroup(newGroup);
  //   MentorView.pressEnterToContinue("Group created successfully, press enter to continue");
  // }

//   public GroupModel getGroup(){
//     boolean groupNotChosen = true;
//     Integer groupIndex = 0;
//     while(groupNotChosen){
//         view.displayGroups(model.getGroups());
//         String userInput = view.getInput("Choose group number");
//         groupIndex = Integer.parseInt(userInput);
//         if (groupIndex < model.getGroups().size()) {
//             groupNotChosen = false;
//         }
//     }
//     return model.getGroups().get(groupIndex);
// }

// public MentorModel getMentor(){
//   boolean mentorNotChosen = true;
//   Integer mentorIndex = 0;
//   while(mentorNotChosen){
//       view.displayMentors(model.getMentors());
//       mentorIndex = AdminView.getNumber("Please enter a mentor number");
//       if (mentorIndex < model.getMentors().size()){
//           mentorNotChosen = false;
//       }
//       else {
//         view.displayText("Wrong number");
//       }
//   }
//   return model.getMentors().get(Integer.valueOf(mentorIndex));
// }

// public void editMentor() {
//   boolean optionChosen = false;
//   while(!optionChosen) {
//     MentorModel mentorToEdit = getMentor();
//     AdminView.chooseAtributeToEdit();
//     Integer option = MentorView.getNumber("Enter your option");
//     switch (option) {
//       case 1:
//         String newLogin = AdminView.getInput("Enter new login");
//         mentorToEdit.setLogin(newLogin);
//         optionChosen = true;
//         break;
//       case 2:
//         String newPassword = AdminView.getInput("Enter new login");
//         mentorToEdit.setPassword(newPassword);
//         optionChosen = true;
//         break;
//       case 3:
//         String newName = AdminView.getInput("Enter new name");
//         mentorToEdit.setName(newName);
//         optionChosen = true;
//         break;
//       case 4:
//         String newLastName = AdminView.getInput("Enter new lastname");
//         mentorToEdit.setLastName(newLastName);
//         optionChosen = true;
//         break;
//       case 5:
//         String newEmail = AdminView.getInput("Enter new email");
//         mentorToEdit.setEmail(newEmail);
//         optionChosen = true;
//         break;
//     }
//   }
// }

// public void assignMentorToGroup(){
//   MentorModel mentorToAssign = getMentor();
//   groupToAssign.addMentor(mentorToAssign);
//   view.displayText("Mentor assigned succesfully");
// }


// public boolean checkIfGroupExist(){
//   if(model.getGroups().size()<1){
//     MentorView.displayText("Group need to be created first");
//     return false;
//   }
//   return true;
// }
}
