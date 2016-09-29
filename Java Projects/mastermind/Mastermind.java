import java.util.Scanner;
public class Mastermind {

	public static void main(String[] args) {
		/*
		 * Mastermind.java
		 * Author: Setul Patel
		 * Submission Date: 10-11-2013
		 * 
		 * Purpose: to create a game of mastermind through using loops 
		 * and things that we have previously learned.
		 * 
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
		
		Scanner input = new Scanner(System.in);
		
		//All the variables
		String answer;
		String level="";
		int secretCode = 0;
		int guess;
		int max = 0;
		int incorrect= 0;
		int secretdigits = 0;
		int correct = 0;
		int sum= 0;
		double earned;
		double toplay = 0;
		double balance = 0;
		final double MIN_BET= 2.00;
		boolean enough = false;
		boolean correct1 = false;
		boolean bet1 = false;
		boolean playing = true;
		boolean playAgain= true;
		boolean testingmode = true;
		
		//Program Begins
		System.out.print("Would you like to play Mastermind (Yes/No)?\t");
		answer = input.next();
		
		//Answer whether they want to play or not
		if (answer.length() >=2 && answer.substring(0,2).equalsIgnoreCase("No")) 
		{
			System.out.println("Bye, See you next time.");
			System.exit(0);
		}
		else 
		{ 
			//first loop telling how much money they have
			while (enough == false) 
			{
				System.out.println("Enter the amount of money you currently have: ");
				balance= input.nextDouble();
				
				while (playAgain == true) //telling whether they have enough money or not
				{
					if (balance >= MIN_BET) 
					{
						enough = true;
					}
					else 
					{
						System.out.println("Sorry, you should have at least 2.00 dollars to play the game. Bye!");
						System.exit(0);
					}
					if (enough == true) 
					{
						while (correct1 == false) 
						{
							//entering the level of difficulty
							System.out.println("Please enter the level of difficulty (beginner, intermediate, advanced): ");
							level = "";
							level = input.next();
							
							if (level.equalsIgnoreCase("beginner") || level.equalsIgnoreCase("intermediate") || level.equalsIgnoreCase("advanced")) 
							{
								correct1 = true;
							}
							else 
							{
								System.out.println("Sorry, this is not a correct level.");
							}
						}
							while (bet1 == false) 
							{
								//amount of money they want to bet
								System.out.println("Enter the amount of money you want to bet: ");
								toplay = input.nextDouble();
								if (toplay > balance) 
								{
									System.out.println("Sorry, you cannot bet more money than you have. ");
								}
								if (toplay < MIN_BET) 
								{
									System.out.println("Sorry, the minimum amount of money to bet is 2.00 dollars");
								}
								if (toplay >= MIN_BET && toplay <= balance) 
								{
									bet1 = true;
								}
							}
							
							//generating the secret code
							if (level.equalsIgnoreCase("beginner")) 
							{
								secretdigits = 3;
								max = 30;
								secretCode = (int)(Math.random() * 900) +100;
							}
							if (level.equalsIgnoreCase("intermediate")) 
							{
								secretdigits = 4;
								max = 20;
								secretCode = (int)(Math.random() * 9000) +1000;
							}
							if (level.equalsIgnoreCase("advanced")) 
							{
								secretdigits = 5;
								max = 10;
								secretCode = (int)(Math.random() * 90000) +10000;
							}
							
							playing = true;
							
							//playing of the game start, starting with the testing mode
							while (playing == true) 
							{
								if (testingmode = true) 
								{
									System.out.println("(Testing Mode - the 3 digits number: " + secretCode + ")");
								}
								
								System.out.println("Please guess the " + secretdigits + " digits number: ");
								guess = 0;
								guess = input.nextInt();
								
								if (level.equalsIgnoreCase("beginner")) 
								{
									if(guess - 1000 >= 0) 
									{
										System.out.println("The guess you have entered is ill-formed. ");
									}
									if(guess - 99 <= 0) 
									{
										System.out.println("The guess you have entered is ill-formed. ");
									}
									if(guess-1000 <=0 && guess-99 > 0) 
									{
										correct= 0;
										sum = 0;
										if (secretCode/100 == guess/100) 
										{
											correct++;
											sum += secretCode/100;
										}
										if (secretCode%100/10 == guess%100/10) 
										{
											correct++;
											sum += secretCode%100/10;
										}	
										if (secretCode%10 == guess%10) 
										{
											correct++;
											sum += secretCode%10/1;
										}
										
										System.out.println("Number of correct digits: "+correct);
										System.out.println("Sum: " +sum);
									}
								}
								
								if (level.equalsIgnoreCase("intermediate")) 
								{
									if(guess - 10000 >= 0)  
									{
										System.out.println("The guess you have entered is ill-formed. ");
									}
									if(guess - 999 <= 0) 
									{
										System.out.println("The guess you have entered is ill-formed. ");
									}							
									if(guess-10000 <=0 && guess-999 > 0) 
									{
										correct= 0;
										sum = 0;
										if (secretCode/1000 == guess/1000) 
										{
											correct++;
											sum += secretCode/1000;
										}
										if (secretCode%1000/100 == guess%1000/100) 
										{
											correct++;
											sum += secretCode%1000/100;
										}
										if (secretCode%100/10 == guess%100/10) 
										{
											correct++;
											sum += secretCode%100/10;
										}
										if (secretCode%10/1 == guess%10/1) 
										{
											correct++;
											sum += secretCode%10/1;
										}
										
										System.out.println("Number of correct digits: "+correct);
										System.out.println("Sum: " +sum);
									}
								}
								
								if (level.equalsIgnoreCase("advanced")) 
								{
									if(guess - 100000 >= 0)  
									{
										System.out.println("The guess you have entered is ill-formed. ");
									}
									if(guess - 9999 <= 0) 
									{
										System.out.println("The guess you have entered is ill-formed. ");
									}
									if(guess-100000 <= 0 && guess-9999 > 0) 
									{
										correct= 0;
										sum = 0;
										if (secretCode/10000 == guess/10000) 
										{
											correct++;
											sum += secretCode/10000;									
										}
										if (secretCode%10000/1000 == guess%10000/1000) 
										{
											correct++;
											sum += secretCode%10000/1000;
										}
										if (secretCode%1000/100 == guess%1000/100) 
										{
											correct++;
											sum += secretCode%1000/100;
										}
										if (secretCode%100/10 == guess%100/10) 
										{
											correct++;
											sum += secretCode%100/10;
										}
										if (secretCode%10/1 == guess%10/1) 
										{
											correct++;
											sum += secretCode%10/1;
										}
										
										System.out.println("Number of correct digits: "+correct);
										System.out.println("Sum: " +sum);
										
									}
								}

								if (incorrect == max) 
								{
									System.out.println("Sorry, you lost!!!");
									System.out.println("You have guessed "+ incorrect + " times.");
									System.out.println("The secret number was " +secretCode);
									System.out.println("You have lost " + toplay +" dollars.");
									balance = balance-toplay;
									System.out.println("Your balance is now " + balance +" dollars.");
									
									System.out.println("Would you like to play again (yes/no)?");
									answer = input.nextLine();
									answer = input.nextLine();
									if (answer.length() >=2 && answer.substring(0,2).equalsIgnoreCase("No")) 
									{
										
										playAgain= false;
										System.out.println("Bye, See you next time");
										System.exit(0);
									}
									if (answer.length() >=3 && answer.substring(0,3).equalsIgnoreCase("Yes")) 
									{
										playAgain=true;
										if (balance >= MIN_BET) 
										{
											enough= true;
											correct1 = false;
											bet1 = false;
											incorrect= 0;
											toplay = 0;
										}
										else 
										{
											enough = false;
										}
									}
								}
								if (correct == secretdigits) 
								{
									earned = (toplay * secretdigits * (max - incorrect))/max;
									balance = earned+balance;
									playing = false;
									
									System.out.println("You Won!!!");
									System.out.println("You have had " + incorrect +" wrong guesses. You have earned " + earned + " dollars. Your balance is now " + balance + " dollars. ");
									System.out.println("Would you like to play again (yes/no)?");
									
									answer="";
									answer = input.next();
									
									if (answer.length() >=2 && answer.substring(0,2).equalsIgnoreCase("No")) 
									{
										playAgain= false;
										System.out.println("Bye, See you next time");
										System.exit(0);
									}
									else 
									{
										playAgain=true;
										
										if (balance >= MIN_BET) 
										{
											enough= true;
											correct1 = false;
											bet1 = false;
											incorrect = 0;
											toplay = 0;
										}
										else 
										{
											enough = false;
										}
									}
								}
							}
					}					
				}
			}
		}
	}

}

				

