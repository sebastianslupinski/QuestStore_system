package model;

import java.util.ArrayList;


public class AdminModel extends UserModel {

    private ArrayList<MentorModel> mentors = new ArrayList<>();

    public AdminModel(String id, String login, String password, String name, String lastName){
        super(id, login, password, name, lastName);
    }

    public AdminModel(String id, String login, String password, String name, String lastName, String email){
        super(id, login, password, name, lastName, email);
    }

    public ArrayList<MentorModel> getMentors(){
        return mentors;
    }

    public void addMentor(MentorModel mentor){
        mentors.add(mentor);
    }


}
