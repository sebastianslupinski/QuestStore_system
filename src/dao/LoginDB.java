package dao;

import java.sql.Connection;

public interface LoginDB {
    public Connection createConnection();
    public void findUserIdAndRole(String login, String password);
    public void insertAllLoginData(String login, String password, String role);

}
