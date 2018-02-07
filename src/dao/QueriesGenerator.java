package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
            System.exit(0);
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
            System.exit(0);
        }
        return statement;
    }
}
