/*
		 * Engine.java
		 * Author: Setul Patel
		 * Submission Date: 11-1-2013
		 * 
		 * Purpose: class keeping all the information needed to run the program.
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


import java.util.Random;

public class Engine {
	
	//Instance Variables in this class
	private int numDigits;
	int[] secretNumber;
	private Random randomNumberGenerator;
	
	//converting secret number to array
	public int[] convertNumToDigitArray(String a)
	{
		int[] numbers = new int[a.length()]; 
		
		for (int i = 0; i < a.length(); i++) 
		{
			numbers[i] = Integer.parseInt(a.substring(i, i+1));
		}
		return numbers;
	}
	
	//method getting number of digits they want to play with.
	public int getNumDigits()
	{
		return numDigits;
	}
	
	//method getting the secret number in a array
	public int[] getSecretNumber()
	{
		return secretNumber;
	}
	
	//generating a secret number
	public void generateNewSecret()
	{ 
		this.secretNumber = new int[numDigits];
		
		for (int i = 0; i < numDigits; i++) 
		{
			this.secretNumber[i] = (int)(Math.random()*9+1);
		}
	}
	
	//method setting number of digits they want to play with.
	public void setNumDigits(int numDigits)
	{
			this.numDigits = numDigits;
	}
	
}
