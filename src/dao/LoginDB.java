package dao;

import java.sql.Connection;

public interface LoginDB {
    public Connection createConnection();
    public void findUserIdAndRole();

}
