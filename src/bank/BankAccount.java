package bank;

public class BankAccount {



    private String firstName;
    private String lastName;
    private double balance;
    private double interestRate;
    private String accountType;
    private double monthlyFee;
    private char tier;

    public void deposit(double amount) {
        this.balance += amount;

        System.out.println("Deposited: $" + amount + ". New balance: $"+ this.balance);
    }

    public boolean withdraw(double amount) {
        if(amount > this.balance) {
            System.out.println("[ERROR] Insufficient funds!");
            return false;
        } else  {
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

    public char getTier() {
        return tier;
    }

    public void setTier(char tier) {
        this.tier = tier;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
