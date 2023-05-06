package br.com.videos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

    public static void main(String[] args) {
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "sa";

        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");
             Statement stmt = conn.createStatement()) {

            System.out.println("Connection successful!");

            ResultSet rs = stmt.executeQuery("SELECT 1+1");
            rs.next();
            int result = rs.getInt(1);
            System.out.println("Result of SELECT 1+1 = " + result);

        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
