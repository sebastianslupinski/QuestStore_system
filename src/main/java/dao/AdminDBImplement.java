package dao;

import model.AdminModel;
import model.MentorModel;
import model.StudentModel;
import model.UserModel;
import utils.ProcessManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class AdminDBImplement implements AdminDB {

    private Connection connection = this.createConnection();
    private String idColumnName;
    private String tableName;
    private QueriesGenerator generator;
    private ProcessManager processManager;

    public AdminDBImplement() {
        this.tableName = "admins";
        this.idColumnName = "admin_id";
        this.generator = new QueriesGenerator();
    }

    public AdminModel loadAdmin(int id) {
        PreparedStatement statement = generator.getFullDataOfUser(tableName, idColumnName, id);
        ResultSet resultSet;
        AdminModel admin = null;

        try {
            resultSet = statement.executeQuery();
            admin = this.getAdmin(resultSet);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return admin;
    }

    public void exportAdmin(AdminModel admin){

        PreparedStatement statement = generator.updateLoginDataOfUser(
                admin.getLogin(),
                admin.getPassword(),
                Integer.valueOf(admin.getId()));

        PreparedStatement secondStatement = generator.updatePersonalDataOfUser(
                tableName, idColumnName,
                admin.getName(), admin.getLastName(),
                admin.getEmail(), Integer.valueOf(admin.getId()));

        try {
            statement.executeUpdate();
            secondStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public AdminModel getAdmin(ResultSet resultSet) {

        AdminModel admin = null;

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("user_id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");

                admin = new AdminModel(String.valueOf(id), login, password, name, lastname, email);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return admin;
    }

    public Connection createConnection() {

        String url = "jdbc:sqlite:queststore.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }


    public ArrayList<String[]> getMentorsDataFromDatabase(int roleToFind) {

        String tableToGetFrom = null;
        if (roleToFind == 1) {
            tableToGetFrom = "admins";
        } else if (roleToFind == 2) {
            tableToGetFrom = "mentors";
        } else if (roleToFind == 3) {
            tableToGetFrom = "students";
        }

        String sql = "SELECT user_id, login, password, name, lastname, email FROM logins JOIN mentors ON logins.user_id=mentors.mentor_id WHERE role = 2";
        int idColumn = 0;
        int loginColumn = 1;
        int passwordColumn = 2;
        int name = 3;
        int lastname = 4;
        int email = 5;
        ArrayList<String[]> allIdsLoginsAndPasswords = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String[] idLoginAndPassword = new String[6];
                idLoginAndPassword[idColumn] = rs.getString("user_id");
                ;
                idLoginAndPassword[loginColumn] = rs.getString("login");
                idLoginAndPassword[passwordColumn] = rs.getString("password");
                idLoginAndPassword[name] = rs.getString("name");
                idLoginAndPassword[lastname] = rs.getString("lastname");
                idLoginAndPassword[email] = rs.getString("email");

                allIdsLoginsAndPasswords.add(idLoginAndPassword);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allIdsLoginsAndPasswords;
    }


    public void findAllDataOfAdmin(int admin_id) {

        String sql = "SELECT * FROM admins WHERE admin_id= ?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, admin_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("ADMIN ID: " + rs.getInt("admin_id") + "\t" + "NAME: " +
                        rs.getString("name") + "\t" + "LASTNAME: " + rs.getString("lastname") +
                        "\t" + "EMAIL: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUserLogin(String login, String user_id) {

        String sql = "UPDATE logins SET login=? WHERE user_id=?;";
        processManager.executePreparedStatement(sql, login, user_id);
    }

    public void updateMentorsName(String newName, String user_id) {
        String sql = "UPDATE mentors SET name=? WHERE mentor_id=?";
        processManager.executePreparedStatement(sql, newName, user_id);
    }

    public void updateMentorsLastName(String newLastName, String user_id) {
        String sql = "UPDATE mentors SET lastname=? WHERE mentor_id=?";
        processManager.executePreparedStatement(sql, newLastName, user_id);
    }

    public void updateMentorsEmail(String newEmail, String user_id) {
        String sql = "UPDATE mentors SET email=? WHERE mentor_id=?";
        processManager.executePreparedStatement(sql, newEmail, user_id);
    }

    public void updateUserPassword(String newPassword, String user_id) {
        String sql = "UPDATE logins SET password=? WHERE user_id=?;";
        processManager.executePreparedStatement(sql, newPassword, user_id);
    }

    public void insertAdminData(String name, String lastname, String email) {
        String sql = "INSERT INTO admins (name, lastname, email) VALUES(?, ?, ?);";
        processManager.executePreparedStatement(sql, name, lastname, email);
    }

    public void createNewGroupAndAssignMentorToIt(String newGroup, String mentorId) {
        String sqlQuerry1 = "INSERT INTO group_names(signature, mentor_id) VALUES(?, ?);";
        processManager.executePreparedStatement(sqlQuerry1, newGroup, mentorId);
    }

    public ArrayList<String> getIdsOfMentorsHavingGroupsAlready(Connection connection){
        ArrayList<String> idsOfMentorsInGroups = new ArrayList<>();

        String sql = "SELECT mentor_id FROM group_names";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("mentor_id");

                idsOfMentorsInGroups.add(String.valueOf(id));
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return idsOfMentorsInGroups;
    }
}

