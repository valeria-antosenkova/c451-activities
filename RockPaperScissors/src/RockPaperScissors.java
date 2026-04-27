import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean continueGame = true;

        // main loop that allows multiple games
        while (continueGame) {

            int userWins = 0;
            int computerWins = 0;
            int ties = 0;

            System.out.println("Welcome to Rock Paper Scissors!");

            int numRounds = getNumRounds(sc);

            // play n number of rounds
            for (int round = 1; round <= numRounds; round++) {

                int result = playRound(sc, random, round);

                if (result == 0) ties++;
                else if (result == 1) userWins++;
                else computerWins++;
            }

            // display the results of the whole game
            printFinalResults(userWins, computerWins, ties);

            continueGame = askPlayAgain(sc);
        }

        sc.close();
    }

    /**
     * Prompts the user for a valid number of rounds (1–10).
     * Loops until a valid value is entered.
     * @param sc the Scanner used to read user input
     * @return a validated round count between 1 and 10
     */
    public static int getNumRounds(Scanner sc) {
        System.out.print("How many rounds (1–10)? ");
        int n = sc.nextInt();

        while (n < 1 || n > 10) {
            System.out.println("Invalid input! Enter a number between 1 and 10.");
            System.out.print("How many rounds (1–10)? ");
            n = sc.nextInt();
        }

        return n;
    }

    /**
     * Asks the user whether they want to play again.
     * @param sc the Scanner used to read user input
     * @return true if the user wants to play again, false otherwise
     */
    public static boolean askPlayAgain(Scanner sc) {
        sc.nextLine(); // clear leftover newline from nextInt()
        System.out.print("\nPlay again? (Yes/No): ");
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else if (input.equalsIgnoreCase("no")) {
            System.out.println("--- Goodbye! ---");
            return false;
        } else {
            System.out.println("Invalid input!");
            return false;
        }
    }

    /**
     * Plays one round of the game.
     * @param sc the Scanner used to read user input
     * @param random the Rand   om object used to generate the computer's choice
     * @param round the current round number
     * @return 1 if user wins, -1 if computer wins, 0 if tie
     */
    public static int playRound(Scanner sc, Random random, int round) {

        System.out.println("\nRound " + round);

        int userChoice = getUserChoice(sc);
        int computerChoice = random.nextInt(3) + 1;
        String computerChoiceName = getChoiceName(computerChoice);

        int result = determineWinner(userChoice, computerChoice);

        if (result == 0) {
            System.out.println("It's a tie! Computer picked: " + computerChoiceName);
        } else if (result == 1) {
            System.out.println("You win this round! Computer picked: " + computerChoiceName);
        } else {
            System.out.println("Computer wins this round! (It picked " + computerChoiceName + ")");
        }

        return result;
    }

    /**
     * Gets a valid user choice (1–3).
     * @param sc the Scanner used to read user input
     * @return the user's validated choice
     */
    public static int getUserChoice(Scanner sc) {
        System.out.print("1 = Rock, 2 = Paper, 3 = Scissors: ");
        int choice = sc.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.println("Invalid input!");
            System.out.print("1 = Rock, 2 = Paper, 3 = Scissors: ");
            choice = sc.nextInt();
        }

        return choice;
    }

    /**
     * Converts a numeric choice into a readable string.
     * @param choice the numeric choice: 1, 2, or 3
     * @return "Rock", "Paper", or "Scissors"
     */
    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1: return "Rock";
            case 2: return "Paper";
            case 3: return "Scissors";
            default: return "Invalid";
        }
    }

    /**
     * Determines the winner of a round.
     * @param user the user's numeric choice (1–3)
     * @param computer the computer's numeric choice (1–3)
     * @return 1 if user wins, -1 if computer wins, 0 if tie
     */
    public static int determineWinner(int user, int computer) {
        if (user == computer) return 0;

        if ((user == 1 && computer == 3) ||
                (user == 2 && computer == 1) ||
                (user == 3 && computer == 2)) {
            return 1;
        }

        return -1;
    }

    /**
     * Prints the final results after all rounds are completed.
     * @param userWins number of rounds the user won
     * @param computerWins number of rounds the computer won
     * @param ties number of tied rounds
     */
    public static void printFinalResults(int userWins, int computerWins, int ties) {

        System.out.println("\nFinal Score:");
        System.out.println("You (wins): " + userWins);
        System.out.println("Computer (wins): " + computerWins);
        System.out.println("Ties: " + ties);

        if (userWins > computerWins) {
            System.out.println("You win the game!");
        } else if (computerWins > userWins) {
            System.out.println("Computer wins the game!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}