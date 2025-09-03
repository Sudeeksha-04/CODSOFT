import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random(); //randon object to generate the randon numbers.

        String playAgain = "yes";
        int roundWin = 0;
        int totRound = 0;

        while (playAgain.equalsIgnoreCase("yes")) { //loop for the game as long as the the user typed "yes".    
            int generatedNumber = random.nextInt(10) + 1; // this will give 0 to 9, thats why =1 for getting 1 to 10

            System.out.print("Guess a number between 1 and 10: ");
            while (!sc.hasNextInt()) { //validates input 
                System.out.print("Invalid input. Please enter a number between 1 and 10: ");
                sc.next(); //discards invalid input
            }
            int userGuess = sc.nextInt(); //after validation, read the users guess.

            while (userGuess < 1 || userGuess > 10) {
                System.out.print("Not in range. Enter a number between 1 and 10: ");
                userGuess = sc.nextInt();
            }

            if (userGuess == generatedNumber) {
                System.out.println("You guessed it right!");
                roundWin++;
            } else {
                System.out.println("Wrong! The correct number was " + generatedNumber);
                if (userGuess < generatedNumber) {
                    System.out.println("Clue: Try a higher number.");
                } else {
                    System.out.println("Clue: Try a lower number.");
                }
            }

            totRound++; //increment the count of rounds

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().trim().toLowerCase(); //trims the whitespaces and converts to lowercase for the consistency

            while (!playAgain.equals("yes") && !playAgain.equals("no")) {
                System.out.print("Please enter 'yes' or 'no': ");
                playAgain = sc.next().trim().toLowerCase();
            }
        }

        System.out.println("Game Over!");
        System.out.println("Rounds played by you: " + totRound);
        System.out.println("Rounds you have won: " + roundWin);

        sc.close();
    }
}
