package dao;

import models.StudentModel;
import java.util.List;

public interface StudentDAO {

    public List<StudentModel> readDataFromFile();
    public void saveDataToFile(List<StudentModel> studentCollection);
    public void addObject(StudentModel object);
    public void deleteObject(StudentModel object);
}