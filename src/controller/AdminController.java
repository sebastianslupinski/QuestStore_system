package controller;

import view.AdminView;
import model.AdminModel;
import model.MentorModel;
import dao.*;
import view.MentorView;

import java.util.ArrayList;

public class AdminController {

//<<<<<<< HEAD
//    private UserDAOImplement newAdminDAO = new UserDAOImplement();
//    private ArrayList<String[]> users = newAdminDAO.readDataFromFile();
//    private LoginDAOImplement loginDAO = new LoginDAOImplement();
//=======
    private LoginDB loginDB = new LoginDBImplement();
    private AdminDB adminDB = new AdminDBImplement();

    private AdminView view = new AdminView();
    private String HEADER = "======= HELLO-ADMIN =======\n";
    private String HEADER2 = "Choose what atribute you want to edit";
    private final String[] OPTIONS = {"Display existing mentors", "Create Mentor",
                                      "Edit mentor", "IN PROGRESS", "Exit"};
    private final String[] OPTIONS2 = {"Login", "Password", "Name",
                                       "Surname", "Email"};

    public void run(String id) {
        AdminModel admin = this.loadAdmin(loginDB, id);
        this.addExistingMentors(adminDB, admin);
        boolean adminControllerRunning = true;

        while (adminControllerRunning) {
            view.displayMenu(HEADER, OPTIONS);
            Integer option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    view.displayUsers(admin.getMentors());
                    break;
                case 2:
                    this.createMentor(admin, loginDB);
                    break;
                case 3:
                    this.editMentor(admin);
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

    public AdminModel loadAdmin(LoginDB database, String id) {
        ArrayList<String[]> IdsLoginsAndPasswords = database.getExistingIdsLoginAndPasswords(1);
        ArrayList<String[]> namesLastnamesEmails = database.getExistingNamesLastnamesAndEmails("admins");
        AdminModel admin = null;
        for (String[] userInfo : IdsLoginsAndPasswords) {
            if (userInfo[0].equals(id)) {
                String newId = userInfo[0];
                String login = userInfo[1];
                String password = userInfo[2];
                for(String[] usersNames : namesLastnamesEmails){
                    if (usersNames[0].equals(id)){
                        String name = usersNames[1];
                        String lastName = usersNames[2];
                        String email = usersNames[3];
                        admin = new AdminModel(newId, login, password, name, lastName, email);
                    }
                }
            }
        }
        return admin;
    }

    public void addExistingMentors(AdminDB database, AdminModel admin) {
        ArrayList<String[]> loginsInfo = database.getMentorsDataFromDatabase(2);
        for (String[] userInfo : loginsInfo) {
            MentorModel mentorToAdd = null;
            String id = userInfo[0];
            String login = userInfo[1];
            String password = userInfo[2];
            String name = userInfo[3];
            String lastName = userInfo[4];
            String email = userInfo[5];
            mentorToAdd = new MentorModel(id, login, password, name, lastName, email);
            admin.addMentor(mentorToAdd);
        }
    }

    public static MentorModel createMentor(AdminModel admin, LoginDB loginDB) {
        String id = loginDB.getLastId();
        String login = InputController.getString("Please enter mentor login: ");
        String password = InputController.getString("Please enter mentor password: ");
        String name = InputController.getString("Please enter mentor name: ");
        String lastName = InputController.getString("Please enter mentor lastName: ");
//        String group = setGroupForMentor(getExistingGroups(admin));
        MentorModel newMentor = new MentorModel(id, login, password, name, lastName);
        admin.getMentors().add(newMentor);
        MentorView.displayText("Mentor created successfully");
        loginDB.saveNewUserToDatabase(newMentor);
        return newMentor;
    }

    public static String[] prepareMentorToSave(MentorModel mentorToSave){
        String[] mentorInfoToSave = null;
        mentorInfoToSave[0] = mentorToSave.getId();
        mentorInfoToSave[1] = mentorToSave.getLogin();
        mentorInfoToSave[2] = mentorToSave.getPassword();
        mentorInfoToSave[3] = mentorToSave.getName();
        mentorInfoToSave[4] = mentorToSave.getLastName();
        mentorInfoToSave[5] = mentorToSave.getEmail();
        return mentorInfoToSave;
    }

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

     public MentorModel getMentor(AdminModel admin){
       boolean mentorNotChosen = true;
       Integer mentorIndex = 0;
       while(mentorNotChosen){
           view.displayUsers(admin.getMentors());
           mentorIndex = InputController.getNumber("Please enter a mentor number");
           if (mentorIndex < admin.getMentors().size()){
               mentorNotChosen = false;
           }
           else {
             view.displayText("Wrong number");
           }
       }
       return admin.getMentors().get(Integer.valueOf(mentorIndex));
     }

     public void editMentor(AdminModel admin) {
       boolean optionChosen = false;
       while(!optionChosen) {
         MentorModel mentorToEdit = getMentor(admin);
         view.displayMenu(HEADER2, OPTIONS2);
         Integer option = InputController.getNumber("Enter your option");
         switch (option) {
           case 1:
             String newLogin = InputController.getString("Enter new login");
             mentorToEdit.setLogin(newLogin);
             optionChosen = true;
             break;
           case 2:
             String newPassword = InputController.getString("Enter new password");
             mentorToEdit.setPassword(newPassword);
             optionChosen = true;
             break;
           case 3:
             String newName = InputController.getString("Enter new name");
             mentorToEdit.setName(newName);
             optionChosen = true;
             break;
           case 4:
             String newLastName = InputController.getString("Enter new lastname");
             mentorToEdit.setLastName(newLastName);
             optionChosen = true;
             break;
           case 5:
             String newEmail = InputController.getString("Enter new email");
             mentorToEdit.setEmail(newEmail);
             optionChosen = true;
             break;
         }
       }
     }

// public void assignMentorToGroup(){
//   MentorModel mentorToAssign = getMentor();
//   groupToAssign.addMentor(mentorToAssign);
//   view.displayText("Mentor assigned succesfully");
// }

//    public static ArrayList<String> getExistingGroups(AdminModel admin) {
//        ArrayList<MentorModel> mentors = admin.getMentors();
//        ArrayList<String> existingGroups = new ArrayList<>();
//        for (MentorModel mentor : mentors) {
//            existingGroups.add(mentor.getGroup());
//        }
//        return existingGroups;
//    }

//    public static String setGroupForMentor(ArrayList<String> existingGroups) {
//        String group = null;
//        boolean groupNotChosen = true;
//        while (groupNotChosen) {
//            group = InputController.getString("Enter a group you want to assign mentor to");
//            if (!(existingGroups.contains(group))) {
//                AdminView.displayText("There is no group like this, do you want to create it ? Enter 'Y' if yes");
//                String answer = InputController.getString();
//                if (answer.equals("Y")) {
//                    groupNotChosen = false;
//                    return group;
//                }
//            }
//            else {
//                groupNotChosen = false;
//            }
//        }
//        return group;
//    }
}
