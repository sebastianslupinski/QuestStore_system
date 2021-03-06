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

    public void updateEditedQuestInDatabase(QuestModel quest) {
        PreparedStatement statement = generator.updateItem(connection, tableName, quest.getId(), quest.getName(),
                quest.getDescription(), quest.getPrice());

        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deleteQuestByID (QuestModel quest){
        PreparedStatement statement = generator.deleteItem(connection, tableName, quest.getId());

        try {
            statement.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            }
        }


}
