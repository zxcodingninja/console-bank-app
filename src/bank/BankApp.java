package bank;

import java.util.Locale;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        System.out.println("=== Java Bank: Account Opening ===");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("What's your first name? ");
        String firstName = scanner.next();

        System.out.print("What's your last name? ");
        String lastName = scanner.next();

        System.out.print("What's your initial deposit? ");
        double deposit = scanner.nextDouble();

        System.out.print("What's your annual interest rate on the account ");
        double rate = scanner.nextDouble();

        scanner.close();

        double income = deposit * (rate / 100);
        double balanceInOneYear = deposit + income;

        System.out.println("--- Account Summary---");
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Initial Deposit: " + deposit);
        System.out.println("Annual rate: "+ rate);
        System.out.println("Expected Annual Profit: " + income);
        System.out.println("Projected Balance (1 Year): "+ balanceInOneYear);
    }
}
