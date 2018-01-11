package dao;

import models.StudentModel;
import java.util.List;
import java.util.ArrayList;

public class StudentDAOImplement implements StudentDAO {

    public List<StudentModel> studentCollection = new ArrayList<StudentModel>();

    public List<StudentModel> readDataFromFile() { return studentCollection; }
    public void saveDataToFile(List<StudentModel> studentCollection) {}
    public void addObject(StudentModel object) {}
    public void deleteObject(StudentModel object) {}
}