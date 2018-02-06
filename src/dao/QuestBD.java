package dao;

import model.QuestModel;

import java.sql.Connection;
import java.util.ArrayList;

public interface QuestBD {

    String getLastId();
    void saveNewQuestToDatabase(QuestModel quest);
    QuestModel getAllQuests();

}
