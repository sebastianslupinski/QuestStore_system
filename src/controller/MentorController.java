package controller;

import model.GroupModel;
import dao.LoginDB;
import dao.LoginDBImplement;
import dao.OpenCloseConnectionWithDB;
import dao.StudentDB;
import dao.StudentDBImplement;
import model.StudentModel;
import view.MentorView;

import java.sql.Connection;
import java.util.ArrayList;

public class MentorController {
    private Connection connection;
    private LoginDB loginDB;
    private OpenCloseConnectionWithDB connectionWithDB;
    private StudentDB studentDB;
    private QuestController quest;
    private MentorView mentorView;
    private String HEADER = "======= HELLO-MENTOR =======\n";
    private String HEADER2 = "Choose what atribute you want to edit";
    private ArrayList<StudentModel> existingStudents;
    private final String[] OPTIONS = {  "Create Student",
                                        "Edit Student",
                                        "Display students in my group",
                                        "Option for quest",
                                        "Option for artifacts",
                                        "Exit"};
    private final String[] OPTIONS2 = {"Login", "Password", "Name",
                                        "Surname", "Email"};


    public MentorController(Connection newConnection) {
        this.loginDB = new LoginDBImplement(newConnection);
        this.quest = new QuestController(newConnection);
        this.connectionWithDB = new OpenCloseConnectionWithDB();
        this.connection = newConnection;
        this.studentDB = new StudentDBImplement();
        // this.wallet = new WalletModel();
        this.mentorView = new MentorView();
        this.existingStudents = studentDB.getAllStudents(connection);
    }


    public void run(String id) {
        GroupModel mentorGroup = studentDB.getMentorGroupByMentorID(connection, id);
        Integer option = 1;
        while (!(option == 6)) {
            mentorView.displayMenu(HEADER, OPTIONS);
            option = InputController.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    this.createStudent();
                    break;
                case 2:
                    StudentModel studentToEdit = this.editStudent();
                    studentDB.exportStudent(connection, studentToEdit);
                    break;
                case 3:
                    mentorView.displayUsers(mentorGroup.getStudents());
                    break;
                case 4:
                    quest.questOption();
                    break;
                case 5:
                    System.out.println("/////Artifact Option/////");
                    quest.questOption();
                    break;
                case 6:
                    connectionWithDB.closeConnection(connection);
                    MentorView.displayText("Good bye");
                    break;
            }
        }
    }


    public void createStudent() {
        String id = loginDB.getLastId();
        String login = InputController.getString("Please enter student login: ");
        String password = InputController.getString("Please enter student password: ");
        String name = InputController.getString("Please enter student name: ");
        String lastName = InputController.getString("Please enter student lastName: ");
//        String group = setGroupForMentor(getExistingGroups(admin));
        StudentModel newStudent = new StudentModel(id, login, password, name, lastName);
        loginDB.saveNewUserToDatabase(newStudent);
        MentorView.displayText("Student created successfully");
    }

    public StudentModel editStudent() {
        boolean optionChosen = false;
        StudentModel studentToEdit = getStudent();
        while(!optionChosen) {
            String studentID = studentToEdit.getId();
            mentorView.displayMenu(HEADER2, OPTIONS2);
            Integer option = InputController.getNumber("Enter your option");
            switch (option) {
                case 1:
                    String newLogin = InputController.getString("Enter new login");
                    studentToEdit.setLogin(newLogin);
                    optionChosen = true;
                    break;
                case 2:
                    String newPassword = InputController.getString("Enter new password");
                    studentToEdit.setPassword(newPassword);
                    optionChosen = true;
                    break;
                case 3:
                    String newName = InputController.getString("Enter new name");
                    studentToEdit.setName(newName);
                    optionChosen = true;
                    break;
                case 4:
                    String newLastName = InputController.getString("Enter new lastname");
                    studentToEdit.setLastName(newLastName);
                    optionChosen = true;
                    break;
                case 5:
                    String newEmail = InputController.getString("Enter new email");
                    studentToEdit.setEmail(newEmail);
                    optionChosen = true;
                    break;
            }
        }
        return studentToEdit;
    }

    public StudentModel getStudent(){
        boolean studentNotChosen = true;
        Integer studentIndex = 0;
        while(studentNotChosen){
            mentorView.displayUsers(this.existingStudents);
            studentIndex = InputController.getNumber("Please enter a mentor number");
            if (studentIndex < this.existingStudents.size()){
                studentNotChosen = false;
            }
            else {
                mentorView.displayText("Wrong number");
            }
        }
        return this.existingStudents.get(Integer.valueOf(studentIndex));
    }
}

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
