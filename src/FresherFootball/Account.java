package FresherFootball;

public class Account {
    private String accountNum, firstName, lastName, username, password;

    public Account(){}

    public void setAccountNum(String accountNum){
        this.accountNum = accountNum;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
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
        if(password == null){
            return "";
        }
        return password;
    }
    public boolean isEmpty(){
        if(username == null){
            return true;
        }
        return false;
    }
}
