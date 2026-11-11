package bank;

import java.util.Locale;
import java.util.Scanner;

public class BankApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double bonusThreshold = 5000.0;
        final double welcomeBonus = 250.0;
        final double minDeposit = 100.0;
        double rate;

        System.out.println("=== Java Bank: Account Opening ===");

        scanner.useLocale(Locale.US);

        System.out.println("What's your first name? ");
        String firstName = scanner.next();

        System.out.println("What's your last name? ");
        String lastName = scanner.next();

        System.out.println("What's your initial deposit? ");
        double deposit = scanner.nextDouble();

        String accountType;
        char accountTier;
        double monthlyFee = 0;


        BankAccount account;

        if (deposit >= minDeposit) {


            if (deposit < 1000) {
                accountTier = 'B';
                rate = 3.0;
            } else if (deposit < 5000) {
                accountTier = 'S';
                rate = 5.0;
            } else if (deposit < 10000) {
                accountTier = 'G';
                rate = 7.5;
            } else {
                accountTier = 'P';
                rate = 10.0;
            }
            if (deposit >= bonusThreshold) {
                deposit += welcomeBonus;
                System.out.println("[BONUS APPLIED] VIP status unlocked! $" + welcomeBonus + " bonus added to your deposit.");
            }

            String accountTierName = switch (accountTier) {
                case 'B' -> "Bronze";
                case 'S' -> "Silver";
                case 'G' -> "Gold";
                case 'P' -> "Platinum";
                default -> "Your Account Tier is not set yet. Please contact our support";
            };


            System.out.println("Choose account type (SAVINGS / CHECKING / STUDENT)");
            accountType = scanner.next().toUpperCase();


            switch (accountType) {

                case "SAVINGS":
                    break;
                case "CHECKING":
                    rate = 0.0;
                    monthlyFee = 5.0;
                    break;
                case "STUDENT":
                    rate += 1.0;
                    break;
                default:
                    System.out.println("Invalid value. Please choose one from the above");
                    scanner.close();
                    return;
            }
            account = new BankAccount(firstName, lastName, deposit, accountType, rate, monthlyFee, accountTier);

            double income = account.calculateAnnualProfit();
            double balanceInOneYear = account.calculateBalanceInOneYear();

            printAccountSummary(firstName, lastName, deposit, rate, income, balanceInOneYear, accountTierName, accountTier, accountType, monthlyFee);

        } else {
            double shortAmount = minDeposit - deposit;
            System.out.println("[ERROR] Account opening rejected. Minimum deposit is $" + minDeposit + ". "
                    + "You are $" + shortAmount + " short of the required amount.");
            scanner.close();
            return;
        }

        int action;


        do {

            printMenu();
            action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Your current Balance is: $" + account.getBalance());
                    break;
                case 3:
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Enter number of years to project: ");
                    int years = scanner.nextInt();
                    calculateInvestmentProjection(account.getBalance(), account.getRate(), years);
                    break;
                case 5:
                    System.out.println("Enter your credit score (300-850)");
                    int score = scanner.nextInt();
                    if (isEligibleForLoan(account.getBalance(), score)) {
                        account.deposit(5000.0);
                        System.out.println("[APPROVED] Congratulations! Loan of $5000.0 has been credited to your account.");
                        System.out.println("Your current balance: $" + account.getBalance());
                    } else {
                        System.out.println("[DECLINED] Loan application denied. Balance must be >= $2,000 and credit score >= 650");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for banking with us. Goodbye!");
                    break;
                default:
                    System.out.println("[ERROR] Invalid option! Please choose between 1 and 6.");
                    break;
            }

        } while (action != 6);


        scanner.close();
    }

    public static void printMenu() {
        System.out.println("--- Operations Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Investment Projections (Compound Interest)");
        System.out.println("5. Apply for Loan");
        System.out.println("6. Exit");
        System.out.println("Choose an option (1-6): ");

    }

    public static void printAccountSummary(String firstName, String lastName, double deposit, double rate, double income, double balanceInOneYear, String accountTierName, char accountTier, String accountType, double monthlyFee) {
        System.out.println("--- Account Summary---");
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Initial Deposit: " + deposit);
        System.out.println("Annual rate: " + rate);
        System.out.println("Expected Annual Profit: " + income);
        System.out.println("Projected Balance (1 Year): " + balanceInOneYear);
        System.out.println("Tier: " + accountTierName + " (" + accountTier + ")");
        System.out.println("Account Type: " + accountType);
        System.out.println("Monthly Fee: $" + monthlyFee);
    }

    public static void calculateInvestmentProjection(double projectedBalance, double rate, int years) {
        for (int i = 0; i < years; i++) {
            double income = projectedBalance * (rate / 100);
            projectedBalance += income;
            System.out.println("Year " + (i + 1) + ": $" + projectedBalance);
        }
    }


    public static boolean isEligibleForLoan(double currentBalance, int creditScore) {
        return currentBalance >= 2000.0 && creditScore >= 650;
    }

}
