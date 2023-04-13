package FresherFootball;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String dbUrl = "jdbc:postgresql://cgames-db.cg6vhgtix6ra.ap-southeast-2.rds.amazonaws.com:5432/FresherFootball";
        String username = "postgres";
        String password = "Ziggy@97R";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            // use the connection object to execute SQL queries
        } catch (SQLException e) {
            // handle exception
            System.out.println("Error: " + e.getMessage());
        }
        

        // DBManager d = new DBManager();

    }
}
