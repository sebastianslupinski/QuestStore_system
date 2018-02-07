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

    public PreparedStatement insertItem(Connection newConnection, String tableName,
                                        int quest_id, String name, String description, int price) {

        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("INSERT INTO "
                + tableName
                + " (quest_id, name, description, price) VALUES(?, ?, ?, ?);");

            statement.setInt(1, quest_id);
            statement.setString(2, name);
            statement.setString(3, description);
            statement.setInt(4, price);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statement;
    }



    public PreparedStatement updateItem(Connection newConnection, String tableName, int quest_id,
                                        String name, String description, int price) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("UPDATE "
                + tableName
                + " SET name = ?, description = ?, price = ? WHERE quest_id = ?;") ;
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setInt(3, price);
            statement.setInt(4, quest_id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statement;
    }


    public PreparedStatement deleteItem(Connection newConnection, String tableName, int quest_id) {

        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("DELETE FROM "
                                                            + tableName
                                                            + " WHERE quest_id = ?;");
            statement.setInt(1, quest_id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statement;
    }

}
