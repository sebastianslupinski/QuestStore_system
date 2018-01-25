package dao;

import java.sql.*;

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
