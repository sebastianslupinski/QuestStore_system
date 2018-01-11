public class Student extends User{

    String group;

    public Student(String login, String password, String name, String lastName, String group){
        super(login, password, name, lastName);
        this.group = group;
    }
}