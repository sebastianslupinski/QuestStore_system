package dao;

import java.util.ArrayList;

public interface AdminDB {

    public void findAllDataOfAdmin(int admin_id);
    public void insertAdminData(String name, String lastname, String email);
    public ArrayList<String[]> getMentorsDataFromDatabase(int roleToFind);
    public void updateUserLogin(String login, String user_id);

  
}
