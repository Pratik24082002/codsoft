import java.util.Random;
import java.util.Scanner;

public class GuessingGame1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attempts = 10; // the number of attempts you want
        int score = 0;

        System.out.println("Welcome to the Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guess;
            int attemptCount = 0;

            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (true) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attemptCount++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score += attempts - attemptCount + 1;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                if (attemptCount >= attempts) {
                    System.out.println("You've used all your attempts. The correct number was: " + targetNumber);
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Your total score is: " + score+ " out of 10");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
