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
//        Connection conn = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }


    public void findUserIdAndRole(String login, String password){

        String sql = "SELECT user_id, role FROM logins WHERE login='" + login + "' AND password='" + password + "';";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
//                System.out.println(rs.getString("user_id") +  "\t" +
//                        rs.getString("role") + "\t");
                String login_id = rs.getString("user_id");
                String role = rs.getString("role");

                System.out.println("LOGIN_ID = " + login_id);
                System.out.println("ROLE = " + role+"\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
}
