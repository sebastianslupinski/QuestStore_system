package dao;

import java.sql.Connection;
import java.util.ArrayList;

public interface LoginDB {

    public String[] findUserIdAndRole(String login, String password);
    public void insertAllLoginData(String login, String password, String role);
    public void updateUserLoginAndPassword(String login, String password, int user_id);
    public void deleteAllUserLoginData(int user_id);
    public ArrayList<String[]> getExistingNamesLastnamesAndEmails(String tableToGetFrom);
    public ArrayList<String[]> getExistingIdsLoginAndPasswords(int roleToFind);
    public String getLastId();

}
