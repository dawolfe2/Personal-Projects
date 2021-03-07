
package bank;

import java.util.Scanner;

 /* @author Daniel Wolfe
    Bank project that allows user to interact with bank database
    functionality of interacting with primitive user interface
    The interface has two states: logged in and not logged in
    In the first state, the user can create an account, login, get the banks information or end session
    In the second state, the user can deposit, withdraw, check balance, check account details, change password and log out
*/
 
public class Bank {

    private final String location;
    private final String name;
    private final int openingTime;
    private final int closingTime;
    private final String owner;
   
    public Bank(String location, String name, int openingTime, int closingTime, String owner){
        
        this.location = location;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.owner = owner;
    }
    
    static void CreateAccount(Account[] accounts){
        
        Scanner scan = new Scanner(System.in);
        String inputStr;
        Boolean enterusername = true;
        Boolean newusername = false;
        String username = "";
        String password;
        String firstname;
        String lastname;
        
            //prompts for username input and loops until a valid username is input
        while(enterusername){
            
            System.out.println("Enter a username");
            inputStr = scan.next();
            
                //loops through all created accounts
            for(int i = 0; i < accounts[0].getAccountcount(); i++){
                    
                    //checks if username matches any existing usernames
                    //if match is found, exit loop and prompt for input again
                if(inputStr.equals(accounts[i].getUsername())){
                    
                    System.out.println("Username already exists\n");
                    i = accounts[0].getAccountcount() + 1;
                    
                } 
                
                    //if loop finished and no matches are found then sets newusername to input and exits loop
                if(i == accounts[0].getAccountcount() - 1){
                    
                    username = inputStr;
                    enterusername = false;
                    
                }
            }         
        } 
        
            //prompts for other inputs
        System.out.println("Enter a password");
        password = scan.next();
        
        System.out.println("Enter your first name");
        firstname = scan.next();
        
        System.out.println("Enter your last name");
        lastname = scan.next();
       
            //creates new account object from input data, index value is current accounts created static variable
        accounts[accounts[0].getAccountcount()] = new Account(username,password,firstname,lastname);         
    }
    
    static int LogIn(Account[] accounts){
        
        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        
        System.out.println("Enter username");
        username = scan.next();       
        
        System.out.println("Enter Password");
        password = scan.next();
        
            //loops through accounts and checks if username/password match any accounts
            //if match is found, sends output message and returns i
            //i represents the account number/account index
        for(int i = 0; i < accounts[0].getAccountcount(); i++){
            
            if(accounts[i].getUsername().equals(username) && accounts[i].getPassword().equals(password)){
                
                System.out.println("logged in");
                return i;
                
            }
        }    
       
        System.out.println("Incorrect username or password");
        return -1;
        
    }
    
    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public String getOwner() {
        return owner;
    }
    

    public static void main(String[] args) {
        
        Bank bank1 = new Bank("somewhere","first bank",600,1900, "Tom Anderson");
        Account[] accounts = new Account[100];
        accounts[0] = new Account("john123","johniscool","John","Anderson");
        Boolean run = true;
        Scanner scan = new Scanner(System.in);
        int inputInt;
        String inputStr;
        int accountnum = -1;
        double cash = 1000;
        
            //while loop runs while run boolean is true, user input can change run and terminate program
        while(run){
                
                //accountnum represents if an account is logged in or not, -1 is the not logged in state
            if(accountnum == -1){
                
                    //user determines which commands to execute, switch statement operates using user input
                System.out.println("Enter 1 to Log in");
                System.out.println("Enter 2 to Create Account");
                System.out.println("Enter 3 to see Bank information");
                System.out.println("Enter 4 to End Session");
                inputInt = scan.nextInt();
                
                switch(inputInt){
                    case 1:
                        
                        accountnum = LogIn(accounts);
                        
                        break;
                    case 2:
                        
                        CreateAccount(accounts);
                        
                        break;
                    case 3:
                        
                        System.out.println("\nBank Name: " + bank1.getName());
                        System.out.println("Location: " + bank1.getLocation());
                        System.out.println("Owner: " + bank1.getOwner());
                        System.out.println("Open Hours: 0" + bank1.getOpeningTime() + " hours to " + bank1.getClosingTime() + " hours\n");
                        
                        break;
                    case 4: 
                        
                        System.out.println("\nShutting Down\n");
                        run = false;
                        
                        break;
                    default:
                        
                        System.out.println("\nInvalid Input\n");  
                        
                        break;
                }
            }
            else{
                    //LogIn command will return an account number if completed, this while loop will start running when logged in
                    //user input again executes commands
                while(accountnum != -1){
                    
                    System.out.println("Enter 1 to Deposit");
                    System.out.println("Enter 2 to Withdraw");
                    System.out.println("Enter 3 to Check Balance");
                    System.out.println("Enter 4 to See Account Details");
                    System.out.println("Enter 5 to Change Password");
                    System.out.println("Enter 6 to Log out");
                    inputInt = scan.nextInt();
                    
                    switch(inputInt){
                        case 1:
                            
                            accounts[accountnum].Deposit(cash);
                            break;
                            
                        case 2:
                            
                            System.out.println("\nEnter how much you will withdraw");
                            cash = accounts[accountnum].Withdraw(scan.nextDouble());
                            break;
                            
                        case 3:
                            
                            accounts[accountnum].CheckBalance();
                            break;
                            
                        case 4:
                            
                            accounts[accountnum].AccountDetails();
                            
                            break;
                        case 5:
                            
                            System.out.println("\nEnter New Password");
                            inputStr = scan.next();
                            accounts[accountnum].setPassword(inputStr);
                            
                            break;
                        case 6:
                            
                            System.out.println("\nLogged out\n");
                            accountnum = -1;
                            
                            break;
                        default:
                            break;
                    }
                }    
            }   
        }  
    }  
}
