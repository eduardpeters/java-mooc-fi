
public class YourFirstAccount {

    public static void main(String[] args) {
        // Write your program here
        Account myAccount = new Account("My Account", 100.0);
        
        myAccount.deposit(20.0);
        
        System.out.println(myAccount);
    }
}
