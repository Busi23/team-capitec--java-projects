import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    // Private fields - only accessible within this class
    // This is called encapsulation, it protects the data from being
    // directly changed from outside the class
    private String accountNumber;
    private String ownerName;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    // Public constructor - allows subclasses and other classes to
    // create a BankAccount object with the required details
    public BankAccount(String accountNumber, String ownerName, double balance) {
        // This refers to the current object's fields
        // We use it to distinguish between the field and the parameter
        // which have the same name
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Public getters - since fields are private, these methods are the
    // only way outside classes can READ the field values (read-only access)
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }
    public List<String> getTransactions() { return transactions; }

    // Public method - allows controlled modification of balance
    // Instead of letting anyone change balance directly, this method
    // ensures every deduction is also recorded in transactions
    public void deductFromBalance(double amount) {
        balance -= amount;
        transactions.add("Deducted: " + amount);
    }

    /* Abstract method - has no body/implementation here
     Every subclass  MUST provide their own version of withdraw() because each account
    type may have different rules*/
    public abstract void withdraw(double amount);
}