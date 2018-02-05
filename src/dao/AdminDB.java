package dao;

import model.AdminModel;

import java.sql.Connection;
import java.util.ArrayList;

public interface AdminDB {

    public void findAllDataOfAdmin(int admin_id);
    public void insertAdminData(String name, String lastname, String email);
    public ArrayList<String[]> getMentorsDataFromDatabase(int roleToFind);
    public void updateUserLogin(String login, String user_id);
    public void updateUserPassword(String newPassword, String user_id);
    public void updateMentorsName(String newName, String user_id);
    public void updateMentorsLastName(String newLastName, String user_id);
    public void updateMentorsEmail(String newEmail, String user_id);
    public AdminModel loadAdmin(Connection connection, int id);
  
}
