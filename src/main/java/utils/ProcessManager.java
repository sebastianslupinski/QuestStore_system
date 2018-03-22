package utils;

import dao.OpenCloseConnectionWithDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessManager extends OpenCloseConnectionWithDB {

    public PreparedStatement getPreparedStatement(String statement, String... args) {
        PreparedStatement preparedStatement = null;
        int index = 1;

        try {
            getConnection();
            preparedStatement = connection.prepareStatement(statement);

            for (String element : args) {
                preparedStatement.setObject(index, element);
                index++;
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage());
        }
        return preparedStatement;
    }

    public void executePreparedStatement(PreparedStatement statement) {
        try {
            getConnection();

            if (statement != null) {
                statement.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + " --> " + e.getMessage() + "statement cannot be update in DB");

        } finally {
            closeConnection(connection);
        }
    }
}
