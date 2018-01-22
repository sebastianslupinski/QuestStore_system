package src.model;

import java.util.ArrayList;


public class MentorModel extends UserModel{

    private String group;

    public MentorModel(String id, String login, String password,
                       String name, String lastName, String group) {
        super(id, login, password, name, lastName);
        this.group = group;
    }
    public MentorModel(String id, String login, String password,
                       String name, String lastName, String email, String group){
        super(id, login, password, name, lastName, email);
        this.group = group;
    }
}
    // public void createStudent(String login, String password, String name, String lastName){
    //     boolean studentNotAdded = true;
    //     while(studentNotAdded){
    //         String groupName = MentorView.getInput("Please enter name of group to add student");
    //         for (Group group : guidedGroups){
    //             if (group.name == groupName) {
    //                 group = group.name;
    //                 studentNotAdded = false;
    //             } else {
    //               MentorView.displayText("There is no group like this.");
    //             }
    //         }
    //     StudentModel newStudent = new StudentModel(login, password, name, lastName, group);
    //     group.addStudent(newStudent);
    //     MentorView.displayText("Student added succesfully.");
    // }


    // public GroupModel getGroupByName(String name) {
    //     for (GroupModel group : guidedGroups){
    //         if(group.name == name){
    //         }
    //         return group;
    //     }
    //     return null;
    // }
