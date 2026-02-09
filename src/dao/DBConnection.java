package dao;
import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(
                "jdbc:h2:~/handicraftdb",
                "sa",
                ""
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
