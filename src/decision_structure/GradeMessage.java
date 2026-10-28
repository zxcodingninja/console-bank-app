package decision_structure;

import java.util.Scanner;

public class GradeMessage {
    public static void main(String[] args) {
        System.out.println("Enter your letter grade");

        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();
        scanner.close();

        String message;

        switch(grade) {
            case "A":
                message = "Excellent Job";
                break;
            case "B":
                message = "Good Job!";
                break;
            case "C":
                message = "Keep trying :)";
                break;
            case "D":
                message = "You need to work a bit harder";
                break;
            case "F":
                message = "Uh oh";
                break;

            default:
                message = "Error. Invalid grade";
                break;
        }

        System.out.println(message);

    }
}
