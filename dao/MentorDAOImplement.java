package dao;

import models.MentorModel;
import java.util.List;
import java.util.ArrayList;

public class MentorDAOImplement implements MentorDAO {

    public List<MentorModel> mentorCollection = new ArrayList<MentorModel>();

    public List<MentorModel> readDataFromFile() {
        MentorModel newMentor = new MentorModel("mentor1", "password1", "Dominik", "S");
        mentorCollection.add(newMentor);
        return mentorCollection;
    }
    public void saveDataToFile(List<MentorModel> mentorCollection) {}
    public void addObject(MentorModel object) {}
    public void deleteObject(MentorModel object) {}
}