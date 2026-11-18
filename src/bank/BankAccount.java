package bank;

import org.w3c.dom.ls.LSOutput;

public class BankAccount {


    private String firstName;
    private String lastName;
    private double balance;
    private double rate;
    private String accountType;
    private double monthlyFee;
    private char accountTier;
    private final double[] transactionHistory = new double[5];
    private int transactionCount = 0;


    public BankAccount(String firstName, String lastName, double initialBalance, String accountType, double rate, double monthlyFee, char accountTier) {
        this.firstName = formatName(firstName);
        this.lastName = formatName(lastName);
        this.balance = initialBalance;
        this.accountType = accountType;
        this.rate = rate;
        this.monthlyFee = monthlyFee;
        this.accountTier = accountTier;

    }

    private String formatName(String name) {
        String trimmedName = name.trim().toLowerCase();
        if (trimmedName.isEmpty()) return "";
        return trimmedName.substring(0, 1).toUpperCase() + trimmedName.substring(1);
    }

    public void deposit(double amount) {
        this.balance += amount;

        System.out.println("Deposited: $" + amount + ". New balance: $" + this.balance);
        recordTransaction(+amount);
    }

    public boolean withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("[ERROR] Insufficient funds!");
            return false;
        } else {
            this.balance -= amount;
            System.out.println("Withdrew: $" + amount);
            recordTransaction(-amount);
            return true;
        }

    }

    public void printTransactionHistory() {
        if (transactionCount == 0) {
            System.out.println("No transactions yet.");

        } else {
            System.out.println("--- Recent Transactions ---");
            int operationNumber = 1;
            for (int i = transactionCount - 1; i >= 0; i--) {
                System.out.println(String.format("%d. $%.2f", operationNumber, transactionHistory[i]));
                operationNumber++;
            }
        }
    }

    private void recordTransaction(double amount) {
        if (transactionCount < transactionHistory.length) {
            transactionHistory[transactionCount] = amount;
            transactionCount++;
        }
    }

    public String getInitials() {

        if (firstName != null && lastName != null && !firstName.isEmpty() && !lastName.isEmpty()) {
            return String.format("%c.%c.", firstName.charAt(0), lastName.charAt(0));
        } else return " ";
    }

    public double calculateAnnualProfit() {
        return this.balance * (this.rate / 100) - (12 * this.monthlyFee);
    }


    public double calculateBalanceInOneYear() {
        return this.balance + calculateAnnualProfit();
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
