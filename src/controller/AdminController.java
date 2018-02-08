package controller;

import view.AdminView;
import model.AdminModel;
import model.MentorModel;
import dao.*;
import view.MentorView;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Set;

public class AdminController {

    private Connection connection;
    private LoginDB loginDB;
    private OpenCloseConnectionWithDB connectionWithDB;
    private AdminDB adminDB;
    private AdminView view;
    private String HEADER = "======= HELLO-ADMIN =======\n";
    private String HEADER2 = "Choose what attribute you want to edit";
    private final String[] OPTIONS = {"Display existing mentors", "Create Mentor",
                                      "Edit mentor", "Create new group and assign mentor to it",
                                        "Exit"};
    private final String[] OPTIONS2 = {"Login", "Password", "Name",
                                       "Surname", "Email"};

    public AdminController(Connection newConnection) {
        this.loginDB = new LoginDBImplement(newConnection);
        this.connectionWithDB = new OpenCloseConnectionWithDB();
        this.connection = newConnection;
        this.adminDB = new AdminDBImplement();
        this.view = new AdminView();

    }

    public void run(String id) {
        AdminModel admin = adminDB.loadAdmin(connection, Integer.valueOf(id));
        this.addExistingMentors(adminDB, admin);
        Integer option = 1;

        while (!(option == 0)) {
            view.displayMenu(HEADER, OPTIONS);
            option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    view.displayUsers(admin.getMentors());
                    InputController.getString();
                    break;
                case 2:
                    this.createMentor(admin, loginDB);
                    break;
                case 3:
                    this.editMentor(admin, adminDB);
                    break;
                case 4:
                    this.assignMentorToGroup(admin,loginDB, adminDB, connection);
                    break;
                case 0:
                    connectionWithDB.closeConnection(connection);
                    AdminView.displayText("Good bye");
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
        loginDB.saveNewUserToDatabase(newMentor);
        MentorView.displayText("Mentor created successfully");
        return newMentor;
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

     public void editMentor(AdminModel admin, AdminDB database) {
       boolean optionChosen = false;
       while(!optionChosen) {
         MentorModel mentorToEdit = getMentor(admin);
         String mentorId = mentorToEdit.getId();
         view.displayMenu(HEADER2, OPTIONS2);
         Integer option = InputController.getNumber("Enter your option");
         switch (option) {
           case 1:
             String newLogin = InputController.getString("Enter new login");
             mentorToEdit.setLogin(newLogin);
             database.updateUserLogin(newLogin, mentorId);
             optionChosen = true;
             break;
           case 2:
             String newPassword = InputController.getString("Enter new password");
             mentorToEdit.setPassword(newPassword);
             database.updateUserPassword(newPassword, mentorId);
             optionChosen = true;
             break;
           case 3:
             String newName = InputController.getString("Enter new name");
             mentorToEdit.setName(newName);
             database.updateMentorsName(newName, mentorId);
             optionChosen = true;
             break;
           case 4:
             String newLastName = InputController.getString("Enter new lastname");
             mentorToEdit.setLastName(newLastName);
             database.updateMentorsLastName(newLastName, mentorId);
             optionChosen = true;
             break;
           case 5:
             String newEmail = InputController.getString("Enter new email");
             mentorToEdit.setEmail(newEmail);
             database.updateMentorsEmail(newEmail, mentorId);
             optionChosen = true;
             break;
         }
       }
     }

 public void assignMentorToGroup(AdminModel admin, LoginDB database,
                                 AdminDB adminDatabase, Connection connection){
        boolean mentorNotChosen = true;
        String mentorId = null;
        ArrayList<String> mentorsIdsWithGroups = adminDatabase.getIdsOfMentorsHavingGroupsAlready(connection);
        while (mentorNotChosen) {
            MentorModel mentorToAssign = getMentor(admin);
            mentorId = mentorToAssign.getId();
            if(mentorsIdsWithGroups.contains(mentorId)){
                view.displayText("This Mentor have group already, " +
                        "please choose another one or create new one");
            }
            else
                {mentorNotChosen = false;}
        }
           String newGroup = this.setGroupForMentor(database.getExistingGroups());
           adminDatabase.createNewGroupAndAssignMentorToIt(newGroup, mentorId);
           view.displayText("Mentor assigned succesfully");
 }

//    public static ArrayList<String> getExistingGroups(AdminModel admin) {
//        ArrayList<MentorModel> mentors = admin.getMentors();
//        ArrayList<String> existingGroups = new ArrayList<>();
//        for (MentorModel mentor : mentors) {
//            existingGroups.add(mentor.getGroup());
//        }
//        return existingGroups;
//    }

    public static String setGroupForMentor(Set<String> existingGroups) {
        String group = null;
        boolean groupNotChosen = true;
        while (groupNotChosen) {
            group = InputController.getString("Enter a group you want to create");
            if (existingGroups.contains(group)) {
                AdminView.displayText("There is already group like this, create new group");
                }
                else {
                groupNotChosen = false;
            }
        }
        return group;
    }
}
