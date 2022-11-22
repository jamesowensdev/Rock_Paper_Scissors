package p1;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
	
	// declaring constant for random class to define assign random numbers to rock, paper, scissors
	
	public static final int MAX_NUMBER = 3;

	public static void main(String[] args) {
		// allows for number of rounds to be altered
		int roundNumber = 5;
		int drawCount = 0;
		int winCount = 0;
		int lossCount = 0;

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= roundNumber; i++) {
			// Printing the round number
			System.out.println("**********\nRound " + i + "\n**********");
			System.out.println("Enter Rock, Paper or Scissors");

			String playerChoice = null;
			int playerNum = 0;

			// scanning for player choice, allocating to an integer for comparing with random input later.
			
			playerChoice = scanner.next();
			// converting to lower case so any variation of capitalisation on input is all read the same and allocated correct integer value
			playerChoice = playerChoice.toLowerCase(); 
			if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
				System.out.println("Unrecognised choice, please try again\n");
				i--;
				continue;
				// if the player input is anything other than rock, paper, scissors, throws an error and restarts the round
			} else if (playerChoice.equals("rock")) {
				System.out.println("You Played: Rock");
				playerNum = 1;
			} else if (playerChoice.equals("paper")) {
				System.out.println("You Played: Paper");
				playerNum = 2;
			} else if (playerChoice.equals("scissors")) {
				System.out.println("You Played: Scissors");
				playerNum = 3;
			}

			// allocating computer choice with random number
			int computerChoice = random.nextInt(MAX_NUMBER) + 1;

			// Using switch statement to assign random number to rock, paper or scissors
			switch (computerChoice) {
			case 1:
				System.out.println("Computer Played: Rock");
				break;
			case 2:
				System.out.println("Computer Played: Paper");
				break;
			case 3:
				System.out.println("Computer Played: Scissors");
				break;
			default:
				System.out.println("Error!");
			}

			// if else function for all outcome combinations,
			if (playerNum == computerChoice) {
				System.out.println("Result: Draw");
				drawCount++;

			} else if (playerNum == 1 && computerChoice == 2) {
				System.out.println("Result: Computer Wins");
				lossCount++;
			} else if (playerNum == 2 && computerChoice == 3) {
				System.out.println("Result: Computer Wins");
				lossCount++;
			} else if (playerNum == 3 && computerChoice == 1) {
				System.out.println("Result: Computer Wins");
				lossCount++;
			} else if (playerNum == 1 && computerChoice == 3) {
				System.out.println("Result: Player Wins");
				winCount++;
			} else if (playerNum == 2 && computerChoice == 1) {
				System.out.println("Result: Player Wins");
				winCount++;
			} else if (playerNum == 3 && computerChoice == 2) {
				System.out.println("Result: Player Wins");
				winCount++;
			}

		}
		scanner.close();

		float winPercentage, lossPercentage, drawPercentage;
		winPercentage = winCount * 100 / roundNumber;
		lossPercentage = lossCount * 100 / roundNumber;
		drawPercentage = drawCount * 100 / roundNumber;

		System.out.println("\nFinal Results");
		System.out.println("Rounds Played: " + roundNumber);
		System.out.println("Win Count: " + winPercentage + "%");
		System.out.println("Loss Percentage: " + lossPercentage + "%");
		System.out.println("Draw Percentage: " + drawPercentage + "%");
		System.out.println("\nThanks For Playing!");
	}

}
