/*
a program that receives an integer value from a user and then calculates
and prints out a list that includes all of the factors of that number,
whether or not the number is perfect, and whether or not the number is prime.
 */

import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {
        int input = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the integer: ");
        input = sc.nextInt();

        if (isPerfect(input)) {
            System.out.println(input + " is a Perfect number");
        }
        else {
            System.out.println(input + " is not a Perfect number");

        }

        if (isPrime(input)) {
            System.out.println(input + " is a Prime number");
        }
        else {
            System.out.println(input + " is not a Prime number");
        }




    }

    public static boolean isPerfect(int number){
        int sum = 0;

        if (number == 1){
            return false;
        }

        for  (int i = 1; i <= number; i++){
            if (number % i == 0){
                sum += i;
            }
        }
        if (sum == number){
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean isPrime(int number){
        if (number <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < number; i++)
            if (number % i == 0)
                return false;

        // if only divisible by itself and 1
        return true;
    }
}
