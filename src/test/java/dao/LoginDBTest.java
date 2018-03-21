package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LoginDBTest {

    private LoginDB loginDB;

    @BeforeEach
    void before() throws IOException {
        String testDbPath = "testDb.db";
        Files.deleteIfExists(new File(testDbPath).toPath());
        OpenCloseConnectionWithDB.setDatabasePath(testDbPath);
        DatabaseCreator.setDatabasePath(testDbPath);
        new DatabaseCreator().createDatabaseFromScript("CreateTables.sql");
        loginDB = new LoginDBImplement(new OpenCloseConnectionWithDB().getConnection());

    }

    @Test
    void insertingAndGettingLoginDataTest() {
        String login = "TestLogin";
        String password = "TestPassword";
        String role = "TestRole";
        String id = "1";
        String[] expected = {id, role};
        loginDB.insertAllLoginData(login, password, role);
        String[] results = loginDB.findUserIdAndRole(login, password);
        assertArrayEquals(expected, results);
    }

    @Test
    void updatingUserLoginAndPasswordTest() {
        String login = "TestLogin";
        String password = "TestPassword";
        String role = "TestRole";
        loginDB.insertAllLoginData(login, password, role);
        String newLogin = "NewLogin";
        String newPassword = "NewPassword";
        loginDB.updateUserLoginAndPassword(newLogin, newPassword, 1);
        String[] results = loginDB.findUserIdAndRole(newLogin, newPassword);
        String[] expected = {"1", role};
        assertArrayEquals(expected, results);
    }

    @Test
    void deletingAllUserLoginDataTest() {
        String login = "TestLogin";
        String password = "TestPassword";
        String role = "TestRole";
        loginDB.insertAllLoginData(login, password, role);
        loginDB.deleteAllUserLoginData(1);
        String[] results = loginDB.findUserIdAndRole(login, password);
        assertNull(results[0]);
        assertNull(results[1]);
    }

    @Test
    void gettingLastIdIfNoEntitiesInDatabaseTest() {
        String id = loginDB.getLastId();
        assertNull(id);
    }

    @Test
    void gettingLastIdTest() {
        loginDB.insertAllLoginData("TestLogin1", "TestPassword1", "TestRole1");
        loginDB.insertAllLoginData("TestLogin2", "TestPassword2", "TestRole2");
        String id = loginDB.getLastId();
        assertEquals("2", id);
    }
}
