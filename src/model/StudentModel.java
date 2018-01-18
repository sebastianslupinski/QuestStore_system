package src.model;


public class StudentModel extends UserModel {

    String group = "default";

    public StudentModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        this.group = group;
    }
    
    public String getGroup() {
        return this.group;
    }

    public void setGroup(String newGroup) {
        this.group = newGroup;
    }
}