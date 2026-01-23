package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            String url = "jdbc:postgresql://localhost:5432/job_hunter";
            String user = "postgres";
            String pass = "123";

            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}