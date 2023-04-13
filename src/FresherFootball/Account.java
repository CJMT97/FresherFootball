package FresherFootball;

public class Account {
    private String accountNum, firstName, lastName, username, password;

    public Account(String accountNum, String firstName, String lastName, String username, String password){
        this.accountNum = accountNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public String getAccountNum(){
        return accountNum;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
