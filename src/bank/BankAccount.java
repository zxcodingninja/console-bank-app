package bank;

public class BankAccount {


    private String firstName;
    private String lastName;
    private double balance;
    private double rate;
    private String accountType;
    private double monthlyFee;
    private char accountTier;


    public BankAccount(String firstName, String lastName, double initialBalance, String accountType, double rate, double monthlyFee, char accountTier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.rate = rate;
        this.monthlyFee = monthlyFee;
        this.accountTier = accountTier;

    }

    public void deposit(double amount) {
        this.balance += amount;

        System.out.println("Deposited: $" + amount + ". New balance: $" + this.balance);
    }

    public boolean withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("[ERROR] Insufficient funds!");
            return false;
        } else {
            this.balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        }

    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public char getAccountTier() {
        return accountTier;
    }

    public void setAccountTier(char tier) {
        this.accountTier = tier;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
