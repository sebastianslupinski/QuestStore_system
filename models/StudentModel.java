package models;

public class StudentModel extends UserModel{

    String group;

    public StudentModel(String login, String password, String name, String lastName, String group){
        super(login, password, name, lastName);
        this.group = group;
    }
}