package model;

import view.AdminView;

import java.util.ArrayList;


public class AdminModel extends UserModel {

    private ArrayList<MentorModel> mentors = new ArrayList();
    public AdminView view = new AdminView();

    public AdminModel(int id, String login, String password, String name, String lastName){
        super(id, login, password, name, lastName);
    }

    public AdminModel(int id, String login, String password, String name, String lastName, String email){
        super(id, login, password, name, lastName, email);
    }

    public ArrayList<MentorModel> getMentors(){
        return mentors;
    }

    public void addMentor(MentorModel mentor){
        mentors.add(mentor);
    }

    // public MentorModel getMentor(){
    //     boolean mentorNotChosen = true;
    //     Integer mentorIndex = 0;
    //     while(mentorNotChosen){
    //         view.displayMentors(getMentors());
    //         mentorIndex = InputController.getNumber("Please enter a mentor number");
    //         if (mentorIndex.equals(mentors.size())){
    //             mentorNotChosen = false;
    //         }
    //     }
    //     return mentors.get(Integer.valueOf(mentorIndex));
    // }

    public void assignMentorToGroup(){
    }

}
