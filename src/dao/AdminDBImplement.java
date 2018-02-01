package dao;

import java.sql.*;
import java.util.ArrayList;

public class AdminDBImplement implements AdminDB {

    private Connection connection = null;
    private Statement statement = null;

    public AdminDBImplement (){
        try{
            this.connection=createConnection();
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection() {

        String url = "jdbc:sqlite:queststore.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public ArrayList<String[]> getMentorsDataFromDatabase(int roleToFind) {

        String tableToGetFrom = null;
        if (roleToFind == 1){
            tableToGetFrom = "admins";
        }
        else if (roleToFind == 2){
            tableToGetFrom = "mentors";
        }
        else if (roleToFind == 3){
            tableToGetFrom = "students";
        }

        String sql = "SELECT user_id, login, password, name, lastname, email FROM logins JOIN mentors ON logins.user_id=mentors.mentor_id WHERE role = 2";
        int idColumn = 0;
        int loginColumn = 1;
        int passwordColumn = 2;
        int name = 3;
        int lastname = 4;
        int email = 5;
        ArrayList<String[]> allIdsLoginsAndPasswords = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String[] idLoginAndPassword = new String[6];
                idLoginAndPassword[idColumn] = rs.getString("user_id");;
                idLoginAndPassword[loginColumn] = rs.getString("login");
                idLoginAndPassword[passwordColumn] = rs.getString("password");
                idLoginAndPassword[name] = rs.getString("name");
                idLoginAndPassword[lastname] = rs.getString("lastname");
                idLoginAndPassword[email] = rs.getString("email");

                allIdsLoginsAndPasswords.add(idLoginAndPassword);
            }
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allIdsLoginsAndPasswords;
    }


    public void findAllDataOfAdmin(int admin_id) {

        String sql = "SELECT * FROM admins WHERE admin_id= ?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, admin_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("ADMIN ID: " + rs.getInt("admin_id") + "\t" + "NAME: " +
                        rs.getString("name") + "\t" + "LASTNAME: " + rs.getString("lastname") +
                        "\t" + "EMAIL: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        public void insertAdminData(String name, String lastname, String email){
            String sql = "INSERT INTO admins(name, lastname, email) VALUES(?, ?, ?);";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, lastname);
                pstmt.setString(3, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
}
