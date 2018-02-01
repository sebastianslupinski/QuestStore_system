package dao;

import java.sql.*;

import static java.lang.String.*;

public class QuestDBImplement implements QuestBD {

    private Connection connection;
    private Statement statement;

    public QuestDBImplement(){
        this.connection = createConnection();
        try {
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() {

        String url = "jdbc:sqlite:queststore.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (connection == null) {
            System.out.println("NULL NULL");
        }
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public String getLastId() {
        String sql = "SELECT id FROM quests ORDER BY id ASC;";
        int idColumn = 0;
        String lastId = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                lastId = rs.getString("id");
            }
        }

        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return lastId;
    }

    public void insertQuestData(String description, int price){
        String sql = "INSERT INTO quests(description, price) VALUES(?, ?);";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setInt(2, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
