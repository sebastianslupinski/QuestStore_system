package model;


public class StudentModel extends UserModel {

    private String group;

    public StudentModel(String id, String login, String password, String name,
                        String lastName, String email, String group) {
        super(id, login, password, name, lastName, email);
        this.group = group;
    }

    public StudentModel(String id, String login, String password, String name, String lastName, String group){
        super(id, login, password, name, lastName);
        this.group = group;
    }
    
    public String getGroup() {
        return this.group;
    }

    public void setGroup(String newGroup) {
        this.group = newGroup;
    }
}