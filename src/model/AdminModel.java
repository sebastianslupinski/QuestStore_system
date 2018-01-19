package src.model;

import src.view.*;

import java.security.acl.Group;
import java.util.ArrayList;


public class AdminModel extends UserModel {

    private ArrayList<MentorModel> mentors = new ArrayList();
    public AdminView view = new AdminView();

    public AdminModel(String login, String password, String name, String lastName){
        super(login, password, name, lastName);
        email = createEmail();
    }

    public ArrayList<MentorModel> getMentors(){
        return mentors;
    }

    public MentorModel getMentor(){
        boolean mentorNotChosen = true;
        Integer mentorIndex = 0;
        while(mentorNotChosen){
            view.displayMentors(getMentors());
            mentorIndex = AdminView.getNumber("Please enter a mentor number");
            if (mentorIndex.equals(mentors.size())){
                mentorNotChosen = false;
            }
        }
        return mentors.get(Integer.valueOf(mentorIndex));
    }

    public void assignMentorToGroup(){
    }

}
