package dao;

import model.QuestModel;

import java.sql.Connection;
import java.util.ArrayList;

public interface QuestBD {

    Connection createConnection();
    ArrayList<String[]> getAllQuests();

}
