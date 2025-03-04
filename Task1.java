import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        
        System.out.println(" Welcome to the Number Guessing Game ");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; // Generate number between 1-100
            int attempts = 0;
            int maxAttempts = 5; // Limit attempts
            boolean guessedCorrectly = false;
            
            System.out.println("\nGuess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts! The number was: " + targetNumber);
            }

            // Ask if the player wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}