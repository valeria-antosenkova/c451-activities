/*
a program that plays Lucky Sevens. The rules of the game are:
Each round, the program rolls a virtual pair of dice for the user.
If the sum of the two dice is equal to 7, the player wins $4; otherwise, the player loses $1.

 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class LuckySevens {
    public static void main(String[] args) {
        int dice1 = 0;
        int dice2 = 0;
        int sum = 0;
        int maxBalance = 0;
        int optimalRolls = 0;

        int money = 0;
        int totalRolls = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many dollars do you have: ");
        money = scanner.nextInt();

        maxBalance = money;

        while (money > 0) {
            dice1 = ThreadLocalRandom.current().nextInt(1, 7);
            dice2 = ThreadLocalRandom.current().nextInt(1, 7);


            if ((dice1 + (dice2) == 7)) {
                money += 4;
                totalRolls++;
                // set a new max balance if it's achieved
                if (money > maxBalance) {
                    maxBalance = money;
                    optimalRolls = totalRolls;                }
            } else {
                money -= 1;
                totalRolls++;

            }
        }
        System.out.println("You are broke after " + totalRolls + " rolls");
        System.out.println("You should have quit after " + optimalRolls + " rolls when you had " + maxBalance + " dollars");

    }
}
