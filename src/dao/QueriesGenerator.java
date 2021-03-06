package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public PreparedStatement getMentorGroup(Connection newConnection, int mentor_id) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("SELECT signature, groups.group_name_id " +
                    "FROM group_names " +
                    "JOIN groups " +
                    "ON groups.group_name_id = group_names.group_name_id " +
                    "WHERE mentor_id = ?;");
            statement.setInt(1, mentor_id);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return statement;
    }

    public PreparedStatement getStudentsIdsFromExactGroup(Connection newConnection, int group_id) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("SELECT student_id FROM groups WHERE group_name_id = ?");
            statement.setInt(1, group_id);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return statement;
    }



    public PreparedStatement getFullDataOfAllUsers(Connection newConnection, String tableName,
                                               String idColumnName, int role) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("SELECT user_id, login, password, name, lastname, email "
                    + "FROM logins "
                    + "INNER JOIN " + tableName +" ON user_id="
                    + idColumnName
                    + " WHERE role=?;");
            statement.setInt(1, role);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return statement;
    }

    public PreparedStatement updateLoginDataOfUser(Connection newConnection, String newLogin,
                                                   String newPassword, int newId) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement(
                    "UPDATE logins"
                    + " SET login=?"
                    + ", password=?"
                    + " WHERE user_id=?;");
            statement.setString(1, newLogin);
            statement.setString(2, newPassword);
            statement.setInt(3, newId);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(1);
        }
        return statement;
    }

    public PreparedStatement updatePersonalDataOfUser(Connection newConnection, String tableName,
                                                      String columnName, String newName, String newLastname,
                                                      String newEmail, int newId) {
        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement(
                                "UPDATE "
                                     + tableName
                                     + " SET name=?"
                                     + ", lastname=?"
                                     + ", email=?"
                                     + " WHERE "
                                     + columnName
                                     + "=?;");
//            statement.setString(1, tableName);
            statement.setString(1, newName);
            statement.setString(2, newLastname);
            statement.setString(3, newEmail);
            statement.setInt(4, newId);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(2);
        }
        return statement;
    }

    public PreparedStatement getAllQuests(Connection newConnection, String tableName) {

        PreparedStatement statement = null;
        try {
            statement = newConnection.prepareStatement("SELECT * FROM " + tableName + ";");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(3);
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
            System.exit(4);
        }
        return statement;
    }
    public PreparedStatement getUserItems(Connection newConnection,
                                             String itemTableName, String idColumnName,
                                             String studentItemsTableName, int id) {

        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("SELECT "
                    + "artefacts.artefact_id, artefacts.name, artefacts.description, artefacts.price, status.status_name"
                    + " FROM "
                    + itemTableName
                    + " INNER JOIN " + studentItemsTableName +" ON "
                    + itemTableName + "." + idColumnName + "=" + studentItemsTableName + "." + idColumnName
                    + " INNER JOIN status ON status.status_id = " + studentItemsTableName + ".status_id"
                    + " WHERE student_id =?;");
            statement.setInt(1, id);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(5);
        }
        return statement;
    }

    public PreparedStatement getUserWallet(Connection newConnection, int id) {

        PreparedStatement statement = null;

        try {
            statement = newConnection.prepareStatement("SELECT student_id, balance, total_earned"
                    + " FROM students_wallets WHERE student_id=?;");
            statement.setInt(1, id);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(6);
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
