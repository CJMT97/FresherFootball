package FresherFootballApp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * Account Class stores the account infomation
 * </p>
 * 
 * @author Charlie Templeton
 */
public class Account {

    // Datafield
    private int accountNum, age;
    private String firstName, lastName, username, password, dob, country;

    // Default Constructor
    public Account() {
    }

    /**
     * <p>
     * setAccountNum method sets the Account number
     * </p>
     * 
     * @param accountNum The accountNum supplied by the user
     */
    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    /**
     * <p>
     * setFirstName method sets the FirstName
     * </p>
     * 
     * @param firstName The firstname supplied by the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <p>
     * setLastName method sets the LastName
     * </p>
     * 
     * @param lastName The lastname supplied by the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <p>
     * setUsername method sets the username
     * </p>
     * 
     * @param username The username supplied by the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <p>
     * setPassword method set the password
     * </p>
     * 
     * @param password The password supplied by the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>
     * setAge method set the password
     * </p>
     * 
     * @param age The age supplied by the user
     */
    public void setDOB(String dob) {
        this.dob = dob;
    }

    /**
     * <p>
     * setCountry method set the password
     * </p>
     * 
     * @param country The country supplied by the user
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <p>
     * getAccountNum method returns the account number
     * </p>
     * 
     * @return accountNum The account number
     */
    public int getAccountNum() {
        return accountNum;
    }

    /**
     * <p>
     * getFirstName method returns the firstname
     * </p>
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <p>
     * getLastName method returns the lastname
     * </p>
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <p>
     * getUsername method returns the username
     * </p>
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>
     * getPassword method returns the password
     * </p>
     * 
     * @return password
     */
    public String getPassword() {
        if (password == null) {
            return "";
        }
        return password;
    }

    /**
     * <p>
     * getAge method returns the password
     * </p>
     * 
     * @return age
     */
    public String getDOB() {
        return dob;
    }

    /**
     * <p>
     * getCountry method returns the password
     * </p>
     * 
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>
     * isEmpty method returns true or false depending on if the account is empty
     * </p>
     * 
     * @return true or false
     */
    public boolean isEmpty() {
        if (username == null) {
            return true;
        }
        return false;
    }

    public int convertToDate(String dateString) {
        LocalDate birthDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
