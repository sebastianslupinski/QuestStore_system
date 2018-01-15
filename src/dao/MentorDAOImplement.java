package src.dao;

import src.models.MentorModel;

import java.util.List;
import java.util.ArrayList;


public class MentorDAOImplement implements MentorDAO {

    public List<MentorModel> mentorCollection = new ArrayList<MentorModel>();

    public MentorModel readDataFromFile() {
        MentorModel newMentor = new MentorModel("mentor1", "password1", "Dominik", "S");
        return newMentor;
    }
    public void saveDataToFile(List<MentorModel> mentorCollection) {}
    public void addObject(MentorModel object) {}
    public void deleteObject(MentorModel object) {}
}