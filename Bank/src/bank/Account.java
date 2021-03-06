
package bank;


public class Account {
    
    private final String username;
    private final String password;
    private final String firstname;
    private final String lastname;
    private double balance;
    private Boolean isAdmin;
    
    public Account(String username, String password, String firstname, String lastname, double initialdeposit){
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        balance = initialdeposit;
        isAdmin = false;
    }
    
    static void AccountDetails(){
        System.out.println("Username: ");
    }
    
}
