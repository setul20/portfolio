		/*
		 * Bagels.java
		 * Author: Setul Patel
		 * Submission Date: 11-1-2013
		 * 
		 * Purpose: the driving program that runs the game.
		 * 
		 * Statement of Academic Honesty:
		 * 
		 * The following code represents my own work. I have neither
		 * received nor given inappropriate assistance. I have not copied
		 * or modified code from any source other than the course webpage
		 * or the course textbook. I recognize that any unauthorized
		 * assistance or plagiarism will be handled in accordance with
		 * the University of Georgia's Academic Honesty Policy and the
		 * policies of this course. I recognize that my work is based
		 * on an assignment created by the Department of Computer
		 * Science at the University of Georgia. Any publishing
		 * or posting of source code for this project is strictly
		 * prohibited unless you have written consent from the Department
		 * of Computer Science at the University of Georgia.
		 */
import java.util.Scanner;
public class Bagels {

	public static void main(String[] args) {
		
		//variables needed
		String action;
		
		//welcoming them to the program
		System.out.println("Welcome!");

		//first while statement to get the game going.
		while (true) 
		{
			//creating objects of both classes.
			Player p = new Player();
			Engine e = new Engine();
			
			//declare scanner
			Scanner myScanner = new Scanner(System.in);
			
			//get the number of digits they want to play with.
			System.out.print("Enter the number of digits to use: ");
			int numDigits = myScanner.nextInt();
			e.setNumDigits(numDigits);

			//get their name
			System.out.print("Enter the player's name: ");
			String name = myScanner.next();
			p.setName(name);

			//while statement to start the game.
			while (true) 
			{
				int numberOfMovesTakenToWin = 0;
				
				System.out.println("Starting game #" + (1 + p.getGamesCompleted()));
				String guess = p.askForGuess();
				numberOfMovesTakenToWin++;
				e.generateNewSecret();

				//while statement to validate the guess
				while (!(Validator.validateGuess(e.getSecretNumber(), e.convertNumToDigitArray(guess), numDigits))) 
				{
					guess = p.askForGuess();
					numberOfMovesTakenToWin++;
				}
				
				//displaying the stats.
				System.out.println("Congratulations! You won in " + numberOfMovesTakenToWin + " moves.");
				p.updateStats(numberOfMovesTakenToWin);
				System.out.println("");
				System.out.println("Statistics for " + name + ":");
				System.out.println("Games completed: " + p.getGamesCompleted());
				System.out.println("Number of Digits: " + numDigits);
				System.out.println("Fastest win: " + numberOfMovesTakenToWin);
				System.out.println("p - Play again\nr - Reset game\nq - Quit");
				System.out.println("What would you like to do?");
				
				action = myScanner.next();
				
				//asking them for what they want to do next.
				if (action.equalsIgnoreCase("p")) 
				{
					continue;
				} 
				else if (action.equalsIgnoreCase("r")) 
				{
					p.updateStats(-1);
					break;
				} 
				else if (action.equalsIgnoreCase("q")) 
				{
					System.exit(0);
				}
			}

		}

	}

}
