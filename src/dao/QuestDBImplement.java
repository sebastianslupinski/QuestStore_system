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

    public Integer getLastId() {
        String sql = "SELECT quest_id FROM quests ORDER BY quest_id ASC;";
        Integer lastId = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                lastId = rs.getInt("quest_id");
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
                int id = resultSet.getInt("quest_id");
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
        PreparedStatement statement = generator.insertItem(connection, tableName,
                quest.getId(), quest.getName(), quest.getDescription(), quest.getPrice());

        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
