package dao;

import model.StudentModel;

import java.sql.Connection;

public interface StudentDB{

    StudentModel loadStudent(Connection connection, int id);
}
