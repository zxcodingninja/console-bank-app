package bank;

public class SavingsAccount extends BankAccount{
    private double minimumBalance;


    public SavingsAccount(String firstName, String lastName, double initialBalance, String accountType, double rate, double monthlyFee, char accountTier, double minimumBalance) {
        super(firstName, lastName, initialBalance, accountType, rate, monthlyFee, accountTier);
        this.minimumBalance = minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }


    public double getMinimumBalance() {
        return minimumBalance;
    }
}
