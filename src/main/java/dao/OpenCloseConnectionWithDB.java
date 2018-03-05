package dao;

import java.sql.*;

public class OpenCloseConnectionWithDB {

    public Connection getConnection() {
        Connection newConnection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            newConnection = DriverManager.getConnection("jdbc:sqlite:queststore.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return newConnection;
    }

    public void closeConnection(Connection connectionToClose) {
        try {
            connectionToClose.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}

