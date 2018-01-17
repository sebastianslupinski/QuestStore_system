package src.dao;

import java.util.ArrayList;


public interface LoginDao {

    public ArrayList<String[]> readDataFromFile();
    public Boolean saveDataToFile(ArrayList<String[]> loginCollection);

}
