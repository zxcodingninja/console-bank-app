package bank;

import java.util.Locale;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        final double bonusThreshold = 5000.0;
        final double welcomeBonus = 250.0;
        final double minDeposit = 100.0;

        System.out.println("=== Java Bank: Account Opening ===");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("What's your first name? ");
        String firstName = scanner.next();

        System.out.println("What's your last name? ");
        String lastName = scanner.next();

        System.out.println("What's your initial deposit? ");
        double deposit = scanner.nextDouble();


        if (deposit >= minDeposit) {

            char accountTier;

            double rate;
            double monthlyFee = 0;

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
                case 'S' -> "Silver"
                case 'G' -> "Gold";
                case 'P' -> "Platinum";
                default -> "Your Account Tier is not set yet. Please contact our support";
            };


            System.out.println("Choose account type (SAVINGS / CHECKING / STUDENT)");
            String accountType = scanner.next().toUpperCase();


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

            double income = deposit * (rate / 100) - (12 * monthlyFee);
            double balanceInOneYear = deposit + income;
            System.out.println("--- Account Summary---");
            System.out.println("Account Holder: " + firstName + " " + lastName);
            System.out.println("Initial Deposit: " + deposit);
            System.out.println("Annual rate: " + rate);
            System.out.println("Expected Annual Profit: " + income);
            System.out.println("Projected Balance (1 Year): " + balanceInOneYear);
            System.out.println("Tier: " + accountTierName + " (" + accountTier + ")");
            System.out.println("Account Type: " + accountType);
            System.out.println("Monthly Fee: $" + monthlyFee);

        } else {
            double shortAmount = minDeposit - deposit;
            System.out.println("[ERROR] Account opening rejected. Minimum deposit is $" + minDeposit + ". "
                    + "You are $" + shortAmount + " short of the required amount.");
        }


        scanner.close();
    }
}
