package utils;

import dao.OpenCloseConnectionWithDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessManager {

    private OpenCloseConnectionWithDB connectionManager = new OpenCloseConnectionWithDB();
    private Connection connection;

    public boolean executePreparedStatement(String statement, String... args) {
        connection = connectionManager.getConnection();
        int index = 1;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);

            for (String element : args) {
                preparedStatement.setObject(index, element);
                index++;
            }
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
            return false;

        } finally {
            connectionManager.closeConnection(connection);
        }
    }
}
