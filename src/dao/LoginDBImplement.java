package dao;

import java.sql.*;
import java.util.ArrayList;

public class LoginDBImplement implements LoginDB {

    Connection connection = null;
    Statement statement = null;

    public LoginDBImplement(){
        this.connection = createConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void closeConnection() {
        try {
            connection.close();
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public String[] findUserIdAndRole(String login, String password) {

        String sql = "SELECT user_id, role FROM logins WHERE login=? AND password=?;";
        int idColumn = 0;
        int roleColumn = 1;
        int arrayCapacity = 2;
        String[] idAndRole = new String[arrayCapacity];

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            ResultSet rs  = pstmt.executeQuery();

            while (rs.next()) {
                String userId = rs.getString("user_id");
                String userRole = rs.getString("role");
                idAndRole[idColumn] = userId;
                idAndRole[roleColumn] = userRole;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idAndRole;
    }

    public ArrayList<String[]> getExistingIdsLoginAndPasswords(int roleToFind) {
        String sql = "SELECT * FROM logins WHERE role = "+roleToFind;
        int idColumn = 0;
        int loginColumn = 1;
        int passwordColumn = 2;
        String[] idLoginAndPassword = new String[3];
        ArrayList<String[]> allIdsLoginsAndPasswords = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                idLoginAndPassword[idColumn] = rs.getString("user_id");
                idLoginAndPassword[loginColumn] = rs.getString("login");
                idLoginAndPassword[passwordColumn] = rs.getString("password");
                allIdsLoginsAndPasswords.add(idLoginAndPassword);
            }
        }

        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allIdsLoginsAndPasswords;
    }

    public ArrayList<String[]> getExistingNamesLastnamesAndEmails(String tableToGetFrom){
        String sql = "SELECT * FROM "+tableToGetFrom;
        int id = 0;
        int name = 1;
        int lastname = 2;
        int email = 3;
        String[] nameLastnameAndEmail = new String[4];
        ArrayList<String[]> allNamesLastnamesAndEmails = new ArrayList<>();
        String columnWithId = null;

        if (tableToGetFrom.equals("admins")){
            columnWithId = "admin_id";
        }
        else if (tableToGetFrom.equals("mentors")){
            columnWithId = "mentor_id";
        }
        else if (tableToGetFrom.equals("students")){
            columnWithId = "student_id";
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                nameLastnameAndEmail[id] = rs.getString(columnWithId);
                nameLastnameAndEmail[name] = rs.getString("name");
                nameLastnameAndEmail[lastname] = rs.getString("lastname");
                nameLastnameAndEmail[email] = rs.getString("email");
                allNamesLastnamesAndEmails.add(nameLastnameAndEmail);
            }
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allNamesLastnamesAndEmails;
    }


    public void insertAllLoginData(String login, String password, String role){
        String sql = "INSERT INTO logins(login, password, role) VALUES(?, ?, ?);";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateUserLoginAndPassword(String login, String password, int user_id) {

        String sql = "UPDATE logins SET login=?, password=? WHERE user_id=?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setInt(3,user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllUserLoginData(int user_id) {

        String sql = "DELETE FROM logins WHERE user_id= ? ;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getLastId() {
        String sql = "SELECT user_id FROM logins ORDER BY user_id ASC;";
        int idColumn = 0;
        String lastId = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                lastId = rs.getString("user_id");
            }
        }

        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return lastId;
    }
}
