import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int point = 0;
            int sum = rollDice(random);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You rolled a " + sum + ". Craps! You crapped out.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You rolled a " + sum + ". Natural! You win!");
            } else {
                point = sum;
                System.out.println("You rolled a " + sum + ". This is your point.");

                while (true) {
                    sum = rollDice(random);
                    System.out.println("You rolled a " + sum + ".");

                    if (sum == point) {
                        System.out.println("Made point of " + point + "! You win!");
                        break;
                    } else if (sum == 7) {
                        System.out.println("Got a 7! You lose.");
                        break;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1; // Roll first die (1-6)
        int die2 = random.nextInt(6) + 1; // Roll second die (1-6)
        int sum = die1 + die2; // Calculate sum
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }
}
