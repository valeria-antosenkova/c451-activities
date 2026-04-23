import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continueGame = true;

        // main loop that allows to run games until user decides to stop
        while (continueGame) {

            int userWins = 0;
            int computerWins = 0;
            int ties = 0;

            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.print("How many rounds (1–10)? ");
            int numRounds = sc.nextInt();

            if (numRounds < 1 || numRounds > 10) {
                System.out.println("Invalid input!");
                return;
            }

            for (int round = 1; round <= numRounds; round++) {

                System.out.println("\nRound " + round);
                System.out.print("1 = Rock, 2 = Paper, 3 = Scissors: ");

                int userChoice = sc.nextInt();

                // keep prompting the user for correct option
                // if user picks an option outside of range
                while (userChoice < 1 || userChoice > 3) {
                    System.out.println("Invalid input!");
                    System.out.print("1 = Rock, 2 = Paper, 3 = Scissors: ");
                    userChoice = sc.nextInt();
                }

                String userChoiceName = "";
                String computerChoiceName = "";

                // get a random number between 1 and 3
                Random random = new Random();
                int computerChoice = random.nextInt(3) + 1; // between 1 and 3
                // get a string name of the move
                computerChoiceName = getChoiceName(computerChoice);

                // depending on the user-computer choices determine who wins the round
                int result = determineWinner(userChoice, computerChoice);

                if (result == 0) {
                    System.out.println("It's a tie!");
                    System.out.println("Computer picked: " + computerChoiceName);
                    ties++;
                } else if (result == 1) {
                    System.out.println("You win this round!");
                    userWins++;
                } else {
                    System.out.println("Computer wins this round! (It picked " + computerChoiceName + ")");
                    computerWins++;
                }
            }

            // print final result
            printFinalResults(userWins, computerWins, ties);

            // clear any potential leftovers in the buffer before we continue with a new game
            sc.nextLine();


            // check if user wants to play again
            System.out.print("\nPlay again? (Yes/No): ");
            String playAgain = sc.nextLine();

            if (playAgain.equalsIgnoreCase("No")) {
                continueGame = false;
                System.out.println("--- Goodbye! ---");
            }
        }

        sc.close();
    }

    /**
     * Converts numeric choice into a readable text string.
     */
    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid";
        }
    }

    /**
     * Determines the winner of a round.
     * @return 1 if user wins, -1 if computer wins, 0 if tie
     */
    public static int determineWinner(int user, int computer) {
        if (user == computer) return 0;

        if ((user == 1 && computer == 3) ||
                (user == 2 && computer == 1) ||
                (user == 3 && computer == 2)) {
            return 1; // user wins
        }

        return -1; // computer wins
    }

    /**
     * Prints the final results after all rounds are completed.
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
// test
