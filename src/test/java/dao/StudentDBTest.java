package dao;

import model.StudentModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDBTest {

    private StudentDB studentDB;

    @BeforeAll
    static void beforeAll() throws IOException {
        String testDbPath = "testDb.db";
        Files.deleteIfExists(new File(testDbPath).toPath());
        OpenCloseConnectionWithDB.setDatabasePath(testDbPath);
        DatabaseCreator.setDatabasePath(testDbPath);
        new DatabaseCreator().createDatabaseFromScript("CreateTables.sql");
    }

    @BeforeEach
    void beforeEach() {
        truncateAllTables();
        studentDB = new StudentDBImplement();
    }

    @Test
    void exportingStudentToDatabaseTest() {
        StudentModel expected = new StudentModel("1", "TestLogin", "TestPassword", "TestName",
                "TestLastName");
        studentDB.exportStudent(expected);
        StudentModel result = studentDB.loadStudent(1);
        assertEquals(expected, result);
    }

    @Test
    void gettingAllStudentsTest() {
        StudentModel studentModel1 = new StudentModel("1", "TestLogin1", "TestPassword1",
                "TestName1","TestLastName1");
        StudentModel studentModel2 = new StudentModel("2", "TestLogin2", "TestPassword2",
                "TestName2","TestLastName2");
        studentDB.exportStudent(studentModel1);
        studentDB.exportStudent(studentModel2);
        ArrayList<StudentModel> expected = new ArrayList<>();
        expected.add(studentModel1);
        expected.add(studentModel2);
        ArrayList<StudentModel> result = studentDB.getAllStudents();
        assertEquals(expected, result);
    }

    private void truncateAllTables() {
        String truncateStudents = "DELETE FROM students;";
        String resetRowIdStudents = "DELETE FROM sqlite_sequence WHERE name= 'students';";
        executeStatement(truncateStudents);
        executeStatement(resetRowIdStudents);
    }

    private void executeStatement(String sqlStatement) {
        try (PreparedStatement ps = new OpenCloseConnectionWithDB().getConnection().prepareStatement(sqlStatement)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
