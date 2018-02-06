package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueriesGenerator {

    public PreparedStatement getFullDataOfUser(Connection newConnection, String tableName,
                                               String idColumnName, int id) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("SELECT user_id, login, password, name, lastname, email "
                    + "FROM logins "
                    + "INNER JOIN " + tableName +" ON user_id="
                    + idColumnName
                    + " WHERE user_id=?;");
            statement.setInt(1, id);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return statement;
    }

    public PreparedStatement getAllQuests(Connection newConnection, String tableName) {

        PreparedStatement statement = null;
        try {
            statement = newConnection.prepareStatement("SELECT * FROM " + tableName + ";");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return statement;
    }


}
