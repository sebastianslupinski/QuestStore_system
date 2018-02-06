package dao;

import model.QuestModel;

import java.sql.*;
import java.util.ArrayList;

public class QuestDBImplement implements QuestBD {

    private Connection connection;
    private QueriesGenerator generator;
    private String tableName;

    public QuestDBImplement(Connection connection) {
        this.tableName = "quests";
        this.connection = connection;
        this.generator = new QueriesGenerator();
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
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return lastId;
    }

//    public void insertQuestData(String description, int price){
//        String sql = "INSERT INTO quests(description, price) VALUES(?, ?);";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//            pstmt.setString(1, description);
//            pstmt.setInt(2, price);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    public void getOneQuestbyID(int id){
//        String sql = "SELECT * FROM quests WHERE id = ?;";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                System.out.println("ID: " + rs.getInt("id") + "\t" + "NAME: " +
//                        rs.getString("name") + "\t" + "DISCRIPTION: " + rs.getString("description") +
//                        "\t" + "PRICE: " + rs.getInt("price"));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public QuestModel getQuest(ResultSet resultSet) {
//        QuestModel quest = null;
//
//        try {
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String description = resultSet.getString("description");
//                int price = resultSet.getInt("price");
//
//                quest = new QuestModel(String.valueOf(id), name, description, price)
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        } return quest;
//    }

    public QuestModel getAllQuests() {

        PreparedStatement statement = generator.getAllQuests(connection, tableName);
        QuestModel quest = null;

        try {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                quest = new QuestModel(String.valueOf(id), name, description, price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return quest;
    }

    public void saveNewQuestToDatabase(QuestModel quest) {
        String id = quest.getId();
        String name = quest.getName();
        String description = quest.getDescription();
        int price = quest.getPrice();
        String sqlQuerry2 = null;

//        if (quest instanceof QuestModel) {
//           role = "2";
//            sqlQuerry2 = "INSERT INTO quests(id, name, description, price) VALUES(?, ?, ?, ?);";
//        }
        String sqlQuerry1 = "INSERT INTO quests(id, name, description, price) VALUES(?, ?, ?, ?);";

        try (PreparedStatement pstmt1 = connection.prepareStatement(sqlQuerry1)) {
            pstmt1.setString(1, id);
            pstmt1.setString(2, name);
            pstmt1.setString(3, description);
            pstmt1.setInt(4, price);
            pstmt1.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//        try (PreparedStatement pstmt2 = connection.prepareStatement(sqlQuerry2)) {
//            pstmt2.setString(1, id);
//            pstmt2.setString(2, name);
//            pstmt2.setString(3, description);
//            pstmt2.setInt(4, price);
//            pstmt2.executeUpdate();
//        }
//        catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

}
