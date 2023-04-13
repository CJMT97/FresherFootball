package FresherFootball;

import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {

    public DBManager() throws ClassNotFoundException {

        // Load the JDBC driver
        Class.forName("/Users/charlietempleton/FootballApp/FresherFootball/src/postgresql-42.6.0.jar");

        // Establish a connection to the database
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Ziggy@97R";

        String sql = "SELECT * FROM Scientist ORDER BY Scientist_Num";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                // create a statement to send to the database
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            // execute the query
            ResultSet rs = stmt.executeQuery();

            // create a list to hold the scientists
            ArrayList<Account> accounts = new ArrayList<>();

            // process the results of the query
            while (rs.next()) {

                // extract values from result columns
                String accNum = rs.getString("Account_Num");
                String firstName = rs.getString("First_Name");
                String lastName = rs.getString("Last_Name");
                String username = rs.getString("username");
                String userPassword = rs.getString("password");

                // create a Account object
                Account account = new Account(accNum, firstName, lastName, username, userPassword);

                // store the object in the list
                accounts.add(account);
            }

            // return the list
            for(Account acc: accounts){
            System.out.println(acc.getFirstName());
            }

        } catch (SQLException ex) {
            System.out.println("HI");
        }
    }
}
