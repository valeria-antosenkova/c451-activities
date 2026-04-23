import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        double startingBalance = 0.0;
        double currentBalance = 0.0;
        double annualRate = 0.0;
        int years = 0;
        double earnings = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("How much do you want to invest? ");
        startingBalance = scanner.nextDouble();

        System.out.print("How many years? ");
        years = scanner.nextInt();

        System.out.print("Your annual rate? ");
        annualRate = scanner.nextDouble();
        annualRate = annualRate / 100;
        double quarterlyRate = annualRate / 4;

        currentBalance = startingBalance;

        System.out.println("Calculating...\n");
        for (int i = 1; i <= years; i++) {
            double yearStart = currentBalance;   // starting balance at start of year

            // compound interest 4 times
            for (int j = 1; j <= 4; j++) {
                currentBalance = yearStart * (1 + quarterlyRate);

            }

            earnings = currentBalance - yearStart;
            System.out.println("Year " + i + ":");
            System.out.println("  Began with:  $" + String.format("%.2f", yearStart));
            System.out.println("  Earned:      $" + String.format("%.2f", earnings));
            System.out.println("  Ended with:  $" + String.format("%.2f", currentBalance));
            System.out.println();
        }

        System.out.println("Final Balance is $" + String.format("%.2f", currentBalance));    }
}
