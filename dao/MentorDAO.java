package dao;
import models.MentorModel;
import java.util.List;

public interface MentorDAO {

    public MentorModel readDataFromFile();
    public void saveDataToFile(List<MentorModel> mentorCollection);
    public void addObject(MentorModel object);
    public void deleteObject(MentorModel object);
}