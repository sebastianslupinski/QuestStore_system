package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.StudentModel;

public class StudentDBImplement implements StudentDB {

    private String idColumnName;
    private String tableName;
    QueriesGenerator generator;

    public StudentDBImplement() {
        this.tableName = "students";
        this.idColumnName = "student_id";
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
}
