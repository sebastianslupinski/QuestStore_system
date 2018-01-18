package src.dao;

import java.util.ArrayList;

public class StudentDAOImplement implements StudentDAO {

    public ArrayList<StudentModel> readDataFromFile() { return studentCollection; }
    public void saveDataToFile(List<StudentModel> studentCollection) {}
    public void addObject(StudentModel object) {}
    public void deleteObject(StudentModel object) {}
}