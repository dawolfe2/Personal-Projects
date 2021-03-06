
package bank;

import java.util.Scanner;


 
 /* @author Daniel Wolfe
    Bank project that allows user to interact with bank database
    functionality of ---
*/
 
public class Bank {

    private final String location;
    private final int openingTime;
    private final int closingTime;
    private String owner;
   
    public Bank(String location, int openingTime, int closingTime, String owner){
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.owner = owner;
    }
    
    
    public static void main(String[] args) {
        
        Bank bank1 = new Bank("somewhere",600,1900, "Tom Anderson");
        Account johnAccount = new Account("john245", "johniscool234", "John", "Jones", 25);

    }
      
}
