package dao;

import java.sql.Connection;

public interface LoginDB {
    public Connection createConnection();
    public void findUserIdAndRole(String login, String password);
    public void insertAllLoginData(String login, String password, String role);
    public void updateUserLoginAndPassword(String login, String password, int user_id);
    public void deleteAllUserLoginData(int user_id);


}
