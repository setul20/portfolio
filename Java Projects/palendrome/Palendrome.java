import java.util.Scanner;
public class Palendrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Palindrome.java
		 * Author: Setul Patel
		 * Submission Date: 9-27-2013
		 * 
		 * Prupose: to learn how to use the loop and modula.
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
		
	Scanner keyboard = new Scanner(System.in);
	
	int number, remainder, finish, number1, sum, count;
	finish = 0;
	sum = 0;
	count = 0;
	
	
	System.out.print("Please enter an integer > 0: ");
	number = keyboard.nextInt();
	number1 = number;
	
	if (number > 0)
		{
			while (number != 0)
			{
				remainder = number%10;
				number = number/10;
				finish = finish * 10 + remainder;
			}
			
			if (number1 == finish)
			{
				System.out.println("The integer "+ number1 + " is a palindrome.");
				
				while (count <= number1)
				{
					sum = sum + count++;
				}
				System.out.println("The sum of the numbers from 1 to " + number1 + " is " + sum);
			}
			else 
			{
				System.out.println("The integer "+ number1 + " is not a palindrome.");
			}
			
			
		}
	
	else 
	{
		System.out.println("Sorry, you must enter an integer greater than zero.");
		System.exit(0);
	}
	
	}

}
