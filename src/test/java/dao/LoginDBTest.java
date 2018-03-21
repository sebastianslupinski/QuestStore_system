package dao;

import model.AdminModel;
import model.MentorModel;
import model.StudentModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
    void savingStudentUserToDatabaseTest() {
        StudentModel userModel = new StudentModel("1", "TestLogin", "TestPassword",
                "Jerzy", "Mardaus");
        loginDB.saveNewUserToDatabase(userModel);
        String[] expected = {userModel.getId(), "3"};
        String[] results = loginDB.findUserIdAndRole(userModel.getLogin(), userModel.getPassword());
        assertArrayEquals(expected, results);
    }

    @Test
    void savingMentorUserToDatabaseTest() {
        MentorModel userModel = new MentorModel("1", "TestLogin", "TestPassword",
                "Jerzy", "Mardaus");
        loginDB.saveNewUserToDatabase(userModel);
        String[] expected = {userModel.getId(), "2"};
        String[] results = loginDB.findUserIdAndRole(userModel.getLogin(), userModel.getPassword());
        assertArrayEquals(expected, results);
    }

    @Test
    void savingAdminUserToDatabaseTest() {
        AdminModel userModel = new AdminModel("1", "TestLogin", "TestPassword",
                "Jerzy", "Mardaus");
        loginDB.saveNewUserToDatabase(userModel);
        String[] expected = {userModel.getId(), "1"};
        String[] results = loginDB.findUserIdAndRole(userModel.getLogin(), userModel.getPassword());
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
