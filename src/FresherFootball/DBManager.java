package FresherFootball;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBManager {

    private static String dbUrl, dbUsername, dbPassword;
    private static Account account;

    public DBManager() {
        try {
            Class.forName("org.postgresql.Driver");

            dbUrl = "jdbc:postgresql://cgames-db.cg6vhgtix6ra.ap-southeast-2.rds.amazonaws.com:5432/FresherFootball";
            dbUsername = "postgres";
            dbPassword = "harrypotter17";
        } catch (ClassNotFoundException e) {
        }
    }

    public Account getAccount() {
        return account;
    }

    public boolean checkNotNull() {
        if (account.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkPassword(String password) {
        if (account.getPassword().equals(password) && !account.getPassword().equals("")) {
            return true;
        }
        return false;
    }

    public static void setAccount() {
        account = null;
    }

    public static void setAccount(String username) {
        String sql = "SELECT * FROM Account WHERE username IN ('" + username + "');";

        try (
                Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                // create a statement to send to the database
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            // execute the query
            ResultSet rs = stmt.executeQuery();

            Account currAccount = new Account();

            // process the results of the query
            while (rs.next()) {

                // extract values from result columns
                String accNum = rs.getString("Account_Num");
                String firstName = rs.getString("First_Name");
                String lastName = rs.getString("Last_Name");
                String user = rs.getString("username");
                String userPassword = rs.getString("ACC_password");

                // create a Account object
                currAccount.setAccountNum(accNum);
                currAccount.setFirstName(firstName);
                currAccount.setLastName(lastName);
                currAccount.setUsername(user);
                currAccount.setPassword(userPassword);

            }

            account = currAccount;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void setupAccount(String firstName, String lastName, String username, String password) {
        int accNum = nextAccountNum();
        try (
                Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                // create a statement to send to the database
                PreparedStatement stmt = conn.prepareStatement(
                        "insert into account (Account_Num, first_name, last_name, username, acc_password) values (?, ?, ?, ?, ?);");) {
            stmt.setInt(1, accNum);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, username);
            stmt.setString(5, password);
            // execute the query
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public int nextAccountNum() {
        String sql = "SELECT Account_Num FROM Account ORDER BY Account_Num;";

        try (
                Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                // create a statement to send to the database
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            // execute the query
            ResultSet rs = stmt.executeQuery();

            ArrayList<Integer> accNums = new ArrayList<Integer>();

            // process the results of the query
            while (rs.next()) {
                // extract values from result columns
                int accNum = rs.getInt("Account_Num");
                accNums.add(accNum);
            }

            return getNumber(accNums);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    }

    public int getNumber(ArrayList<Integer> accNums) {
        if (accNums.size() == 0) {
            return 1000;
        }
        if (accNums.get(0) != 1000) {
            return 1000;
        }
        for (int i = 1; i < accNums.size(); i++) {
            if (!(accNums.get(i) == accNums.get(i - 1) + 1)) {
                return accNums.get(i - 1) + 1;
            }
        }
        return accNums.get(accNums.size() - 1) + 1;
    }

}
