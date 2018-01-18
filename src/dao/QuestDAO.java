package src.dao;

import java.util.List;


public interface QuestDAO {

    public List<String> readDataFromFile();
    public void saveDataToFile(List<String> questCollection);

}
