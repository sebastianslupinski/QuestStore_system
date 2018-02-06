package dao;

import model.StudentModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface StudentDB {

    StudentModel loadStudent(Connection connection, int id);
    void exportStudent(Connection connection, StudentModel student);
    StudentModel getStudent(ResultSet resultSet);
    public ArrayList<StudentModel> getAllStudents(Connection connection);
}
