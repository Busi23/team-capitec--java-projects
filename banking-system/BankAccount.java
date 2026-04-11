import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    // Private fields - only accessible within this class
    // It protects the data from being directly changed from outside the class
    private String accountNumber;
    private String ownerName;
    private double balance;
    // Using Transaction objects instead of Strings for proper type representation
    private List<Transaction> transactions;

    // Public constructor - allows subclasses and other classes to create a BankAccount object with the required details
    public BankAccount(String accountNumber, String ownerName, double balance) {
        // 'this' refers to the current object's fields
        // We use it to distinguish between the field and the parameter which have the same name
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        // ArrayList initialized in constructor as required
        this.transactions = new ArrayList<>();
    }

    /* Public getters - since fields are private, 
    these methods are the only way outside classes can READ the field values*/
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }
    // Returning List of Transaction objects
    public List<Transaction> getTransactions() { return transactions; }

    // Protected method - only accessible within this class and its subclasses no transaction recording here, just deducts the amount from balance
    protected void deductFromBalance(double amount) {
        balance -= amount;
    }

  /* Abstract method - has no body/implementation here
     Every subclass MUST provide their own version of withdraw() because each account
     type may have different rules
     'throws' throws InsufficientFundsException if balance is too low */
    public abstract void withdraw(double amount) throws InsufficientFundsException;
}
