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
        System.out.println("blleeeee");
        return connection;
    }


    public void findUserIdAndRole(){
        String sql = "SELECT user_id, role FROM logins WHERE login='admin' AND password='admin'";

        try (Connection connection = this.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
//                System.out.println(rs.getString("user_id") +  "\t" +
//                        rs.getString("role") + "\t");
                String login_id = rs.getString("user_id");
                String role = rs.getString("role");

                System.out.println( "FIRST NAME = " + login_id);
                System.out.println( "ROLE = " + role+"\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
