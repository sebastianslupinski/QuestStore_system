package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GroupModel;
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

    public StudentModel loadStudent(int id) {
        PreparedStatement statement = generator.getFullDataOfUser(tableName, idColumnName, id);
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

    public void exportStudent(StudentModel student) {

        PreparedStatement statement = generator.updateLoginDataOfUser(student.getLogin(),
                student.getPassword(), Integer.valueOf(student.getId()));

        PreparedStatement secondStatement = generator.updatePersonalDataOfUser(
                tableName, idColumnName,
                student.getName(), student.getLastName(),
                student.getEmail(), Integer.valueOf(student.getId()));

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

    public ArrayList<StudentModel> getAllStudents(){
        PreparedStatement statement = generator.getFullDataOfAllUsers(tableName, idColumnName, role);
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

    public GroupModel getMentorGroupByMentorID(String mentorId){
        ArrayList<StudentModel> studentsInGroup = new ArrayList<>();
        ArrayList<Integer> idsOfStudents = new ArrayList<>();
        String groupName = null;
        int groupId = 0;
        ResultSet resultSet1;
        ResultSet resultSet2;

        PreparedStatement statement1 = generator.getMentorGroup(Integer.valueOf(mentorId));

        try {
            resultSet1 = statement1.executeQuery();
            while (resultSet1.next()) {
                groupId = resultSet1.getInt("group_name_id");
                groupName = resultSet1.getString("signature");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        PreparedStatement statement2 = generator.getStudentsIdsFromExactGroup(groupId);
        try {
            resultSet2 = statement2.executeQuery();
            while (resultSet2.next()){
                int studentId = resultSet2.getInt("student_id");
                idsOfStudents.add(studentId);
            }
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        for (int id : idsOfStudents){
            StudentModel student = loadStudent(id);
            studentsInGroup.add(student);
        }

        GroupModel group = new GroupModel(groupName, groupId, Integer.valueOf(mentorId), studentsInGroup);
        return group;
    }

    public void insertNewStudentToGroup(int studentId, int groupId){
        String sql = "INSERT INTO groups(group_name_id, student_id) VALUES(?, ?);";
        OpenCloseConnectionWithDB connectionManager = new OpenCloseConnectionWithDB();

        Connection connection = connectionManager.getConnection();
        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, groupId);
            pstmt.setInt(2, studentId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        finally {
            connectionManager.closeConnection(connection);
        }
    }
}

