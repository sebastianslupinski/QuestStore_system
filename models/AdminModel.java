package models;
import java.util.ArrayList;

public class AdminModel extends UserModel {

    public ArrayList<Group> groups = new ArrayList();
    public ArrayList<MentorModel> mentors = new ArrayList();

    public AdminModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        email = createEmail();
    }

    public createMentor(String login, String password, String name, String lastName){
        MentorModel newMentor = new MentorModel(login, password, name, lastName);
        mentors.add(newMentor);
        AdminView.displayText("Mentor created successfully");
    }
}