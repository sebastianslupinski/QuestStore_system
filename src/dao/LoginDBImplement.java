package dao;

import java.sql.*;

public class LoginDBImplement implements LoginDB {

    Connection connection = null;
    Statement statement = null;

    public LoginDBImplement(){
        this.connection=createConnection();
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
                System.out.println("USER ID: " + rs.getString("user_id") +  "\t" + "ROLE: "+
                        rs.getString("role") + "\t");
                String userId = rs.getString("user_id");
                String userRole = rs.getString("role");
                idAndRole[idColumn] = userId;
                idAndRole[roleColumn] = userRole;
                System.out.println("user id"+idAndRole[0]);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idAndRole;
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
}
