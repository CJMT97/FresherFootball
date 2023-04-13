package FresherFootball;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class test {
    public static void main(String[] args) throws ClassNotFoundException{

        Class.forName("org.postgresql.Driver");
        

        String dbUrl = "jdbc:postgresql://cgames-db.cg6vhgtix6ra.ap-southeast-2.rds.amazonaws.com:5432/FresherFootball";
        String username = "postgres";
        String password = "harrypotter17";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            // use the connection object to execute SQL queries
        } catch (SQLException e) {
            // handle exception
            System.out.println("Error: " + e.getMessage());
        }
        

         DBManager d = new DBManager();
         DBManager.setAccount("Da_Wolf2");
         System.out.println(d.getAccount().getFirstName());
        

    }
}
