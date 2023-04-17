package FresherFootball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.ByteArrayInputStream;

/**
 * <p>
 * DBManger class is responsible for getting and inserting information from and
 * too
 * the FresherFootball database
 * </p>
 * 
 * @author Charlie Templeton
 */
public class DBManager implements Instances{

    // Datafields
    private static String dbUrl, dbUsername, dbPassword;
    private static Account account;

    /**
     * <p>
     * DBManager constructor initalises datafields and the JDBC driver
     * </p>
     */
    public DBManager() {
        try {
            Class.forName("org.postgresql.Driver");
            dbUrl = "jdbc:postgresql://localhost:5432/FresherFootball";
            dbUsername = "postgres";
            dbPassword = "Blanket10687";
        } catch (ClassNotFoundException e) {
        }
    }

    /**
     * <p>
     * getAccount method returns the current account
     * </p>
     * 
     * @return account The current account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * <p>
     * checkNotNull method returns true if the account is not empty
     * aand false if it is empty
     * </p>
     * 
     * @return true or false
     */
    public boolean checkNotNull() {
        if (account.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * <p>
     * checkPassword method makes sure the password supplied matches the password in
     * the data base
     * </p>
     * 
     * @param password The password enter by the user
     * @return true or false
     */
    public boolean checkPassword(String password) {
        if (account.getPassword().equals(password) && !account.getPassword().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * setAccount method sets the account datafield
     * </p>
     */
    public static void setAccount() {
        account = null;
    }

    /**
     * <p>
     * setAccount method sets the account data field using the username provied by
     * the user
     * </p>
     * 
     * @param username The username provided by the user
     */
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
                int accNum = rs.getInt("Account_Num");
                String firstName = rs.getString("First_Name");
                String lastName = rs.getString("Last_Name");
                String user = rs.getString("username");
                String userPassword = rs.getString("ACC_password");
                String age = rs.getString("Born_On");
                String country = rs.getString("Country");

                // create a Account object
                currAccount.setAccountNum(accNum);
                currAccount.setFirstName(firstName);
                currAccount.setLastName(lastName);
                currAccount.setUsername(user);
                currAccount.setPassword(userPassword);
                currAccount.setDOB(age);
                currAccount.setCountry(country);

            }

            account = currAccount;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    /**
     * <p>
     * setupAccount method creates a new account and adds it to the data base
     * </p>
     * 
     * @param firstName The firstname provided by the user
     * @param lastName  The lastname provided by the user
     * @param username  The username provided by the user
     * @param password  The password provided by the user
     */
    public void setupAccount(String firstName, String lastName, String username, String password, String age,
            String country) {
        int accNum = nextAccountNum();
        try (
                Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                // create a statement to send to the database
                PreparedStatement stmt = conn.prepareStatement("insert into account (Account_Num, first_name, last_name, username, acc_password, Born_On, Country) values (?, ?, ?, ?, ?, ?, ?);");) {
            
            java.sql.Date date = java.sql.Date.valueOf(age);
            stmt.setInt(1, accNum);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setDate(6, date);
            stmt.setString(7, country);
            // execute the query
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void addImage(int id, ImageIcon icon) {

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    
            // Get the BufferedImage from the ImageIcon
            Image image = icon.getImage();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(image, null, null);
    
            // Write the BufferedImage to a byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] imageData = baos.toByteArray();
    
            // Insert the data into the database
            String sql = "INSERT INTO Account_Image (Account_Num, Image_Data) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setBytes(2, imageData);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getImage(int accNum) {

        String sql = "SELECT image_data FROM Account_Image WHERE Account_Num = ?";
        try (
                Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);) {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] imageData = rs.getBytes("image_data");
                InputStream in = new ByteArrayInputStream(imageData);
                BufferedImage image = ImageIO.read(in);
                return image;
            }

            return null;
        } catch (SQLException | IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    /**
     * <p>
     * nextAccountNum returns the next account number that is avalible to be used in
     * order
     * from smallest to largest
     * </p>
     * 
     * @return next Avaliable account number
     */
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

    /**
     * <p>
     * getNumber method returns the next number in the arraylist in order from
     * smallest
     * to largest
     * </p>
     * 
     * @param accNums The ArrayList of current account numbers
     * @return The next avalible account number
     */
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
