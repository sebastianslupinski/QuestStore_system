package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.StudentModel;

public class StudentDBImplement implements StudentDB {

    private String idColumnName;
    private String tableName;
    QueriesGenerator generator;
    private int role;

    public StudentDBImplement() {
        this.tableName = "students";
        this.idColumnName = "student_id";
        this.role = 3;
        this.generator = new QueriesGenerator();
    }

    public StudentModel loadStudent(Connection connection, int id) {
        PreparedStatement statement = generator.getFullDataOfUser(connection, tableName, idColumnName, id);
        ResultSet resultSet = null;
        StudentModel student = null;

        try {
            resultSet = statement.executeQuery();
            student = this.getStudent(resultSet);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return student;
    }

    public void exportStudent(Connection connection, StudentModel student) {

        PreparedStatement statement = generator.updateLoginDataOfUser(connection, student.getLogin(),
                student.getPassword(), Integer.valueOf(student.getId()));

        PreparedStatement secondStatement = generator.updatePersonalDataOfUser(connection, tableName,
                idColumnName, student.getName(), student.getLastName(), student.getEmail(),
                Integer.valueOf(student.getId()));

        try {
            statement.executeUpdate();
            secondStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public StudentModel getStudent(ResultSet resultSet) {

        StudentModel student = null;

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");

                student = new StudentModel(String.valueOf(id), login, password, name, lastname, email);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return student;
    }

    public ArrayList<StudentModel> getAllStudents(Connection connection){
        PreparedStatement statement = generator.getFullDataOfAllUsers(connection, tableName, idColumnName, role);
        ResultSet resultSet = null;
        ArrayList<StudentModel> existingStudents = new ArrayList<>();

        try {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");

                StudentModel student = new StudentModel(String.valueOf(id), login, password, name, lastname, email);
                existingStudents.add(student);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return existingStudents;
    }

}
