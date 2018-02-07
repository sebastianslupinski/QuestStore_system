package dao;

import model.QuestModel;

import java.sql.Connection;
import java.util.ArrayList;

public interface QuestBD {

    Integer getLastId();
    void saveNewQuestToDatabase(QuestModel quest);
    void updateEditedQuestInDatabase(QuestModel quest);
    QuestModel getAllQuests();


}
