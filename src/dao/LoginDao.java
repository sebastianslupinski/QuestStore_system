package dao;

import java.util.List;

public interface LoginDao {

    public List<String> readDataFromFile();
    public void saveDataToFile(List<String>loginCollection);

}
