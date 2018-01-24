package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("blleeeee");
        return conn;

    }

    public void findUserIdAndRole(){
//        String sql = "SELECT user_id, role\n" +
//                "\tFROM logins\n" +
//                "\tWHERE login='admin'\n" +
//                "\tAND password='admin';";
//        try (Connection connection = this.createConnection();
//             Statement statement =
//        )
    }


}
