package src.dao;

import java.util.ArrayList;


public interface userDAO {

    public ArrayList<String[]> readDataFromFile();
    public void saveDataToFile(ArrayList<String[]> studentCollection);
    
}