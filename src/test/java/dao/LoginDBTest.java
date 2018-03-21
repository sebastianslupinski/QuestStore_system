package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String[] expected = {"1", role};
        loginDB.insertAllLoginData(login, password, "TestRole");
        String[] results = loginDB.findUserIdAndRole(login, password);
        assertArrayEquals(expected, results);
    }
}
