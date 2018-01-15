package src.dao;

import java.util.List;


public interface QuestDao {

    public List<String> readDataFromFile();
    public void saveDataToFile(List<String> questCollection);

}