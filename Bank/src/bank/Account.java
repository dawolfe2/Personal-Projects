
package bank;

//Account class for user/admin accounts

public class Account {
    
        
    private final String username;
    private String password;
    private final String firstname;
    private final String lastname;
    private double balance;
    private Boolean isAdmin;
    private int accountnumber;
    
    static int accountcount = 0;
    
        //constructor initializes user account information
        //accountcount is a static variable that keeps track of the total number of accounts made
        //accountnumber is the account number of the account used to access it from main, it's used as the index value for the object array
        //isAdmin boolean for whether user is admin, default to false
    public Account(String username, String password, String firstname, String lastname){
        
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        balance = 0;
        isAdmin = false;
        accountnumber = accountcount;
        accountcount++;
    }
    
        //withdraw method with double amount parameter for money to be withdrawn.
        //if successful returns the amount asked to be withdrawn as a double
    public double Withdraw(double amount){
        
        if(balance >= amount){
            
            balance = balance - amount;
            System.out.println("Withdrawl successful, you have a new balance of $" + balance + "\n");
            return amount;
            
        }
        else{
            
            System.out.println("Your balance is not big enough for this withdrawl\n");
            amount = 0;
            return amount;
            
        }
    }
    
        //deposit money to account if logged in, double money parameter
    public void Deposit(double amount){
        
        balance = balance + amount;
        System.out.println("\nDeposit successful, you have a new balance of $" + balance + "\n"); 
        
    }
    
    public void CheckBalance(){
        System.out.println("\nBalance: $" + balance + "\n");
    }
    
    public void AccountDetails(){
        
        System.out.println("\nUsername: " + username);
        System.out.println("Name: " + firstname + " " + lastname);
        System.out.println("Balance: $" + balance + "\n");  
        
    }
    
        //method that lets an admin make another user an admin
    private void MakeAdmin(Account user){
        
        if(!isAdmin){
            
            System.out.println("\nYou do not have admin privileges\n");
            
        }
        else{
            
            user.isAdmin = true;
            
        }
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public double getBalance() {
        return balance;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public int getAccountnumber() {
        return accountnumber;
    }
    
    public static int getAccountcount() {
        return accountcount;
    } 

            //setter method for changning password with length requirements
    public void setPassword(String password) {
        
        if (password.length() > 4 && password.length() < 17){
            
            this.password = password;
            System.out.println("Password Successfully Changed\n");
            
        }
        
        else{
            
            System.out.println("Invalid Password Entered, Password did not change\n");
            
        }
        
    }
    
}
