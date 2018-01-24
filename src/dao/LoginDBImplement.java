package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class LoginDBImplement implements LoginDB {

    public Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:queststore.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Connection with success");
        return connection;
    }
}
