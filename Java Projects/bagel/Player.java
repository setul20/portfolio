/*
		 * Bagels.java
		 * Author: Setul Patel
		 * Submission Date: 11-1-2013
		 * 
		 * Purpose: class keeping all the information about the player.
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

public class Player {
	
	//Instance Variables in this class
	private String name;
	private static int fastestWin = (2^31)-1;
	private static int gamesCompleted; 
	private Scanner myScanner = new Scanner(System.in);
	
	//method asking them for a guess
	public String askForGuess()
	{
		String guess; 
		System.out.println("Enter your guess:");
		return guess = myScanner.next();
	}
	
	//method to retrieve name
	public String getName()
	{
		return name;
	}
	
	//method to keep track of the fastest win
	public int getFastestWin()
	{
		return fastestWin;
	}
	
	//method keeping track of how many games completed
	public int getGamesCompleted()
	{
		return gamesCompleted;
	}
	
	//method setting name
	public void setName(String name)
	{ 
		if (name != null) 
		{
			this.name = name;
		}
	}
	
	//method keeping track of the stats.
	public void updateStats(int numberOfMovesTakenToWin)
	{
		gamesCompleted++;
		if (numberOfMovesTakenToWin < fastestWin) 
		{
			fastestWin = numberOfMovesTakenToWin;
		}
		if (numberOfMovesTakenToWin == -1) 
		{
			fastestWin = (2^31)-1;
			gamesCompleted = 0;
		}
	}
}
