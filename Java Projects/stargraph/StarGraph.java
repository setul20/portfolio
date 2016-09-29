import java.util.Scanner;
public class StarGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * StarGraph.java
		 * Author: Setul Patel
		 * Submission Date: 10-11-2013
		 * 
		 * Prupose: to create nested loops and learn how to use 1-dimentional arrays.
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
		int number;
		double xmin;
		double increment;
		double condition;
		
		System.out.print("Please enter the number of x values to process: ");
		number = keyboard.nextInt();
		
		if (number > 0)
		{
			System.out.print("Enter a minimum value for x: ");
			xmin = keyboard.nextDouble();
			
			System.out.print("Enter the amount to increment x: ");
			increment = keyboard.nextDouble();
			System.out.println();
			
			if (increment >0)
			{
				double[] xvalues = new double [number];
				double[] yvalues = new double [number];
				
				//xvalues[0] = xmin;
				System.out.println("Values");
				for (int i = 0; i < number; i++)
				{
					xvalues[i] = xmin + (increment * i);
					yvalues[i] = 20 * Math.abs(Math.sin(xvalues[i]));
					
					System.out.printf("x: %.3f, y: %.3f %n", xvalues[i], yvalues[i]);
					
					
				}
				
				System.out.println();
				System.out.println("Graph");
				
				for (int y = 0; y < number; y++)
				{
					System.out.print(":");
					for (int x = 1; x < yvalues[y]; x++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
				
				
				
			}
			else 
			{
				System.out.println("The increment must be a decimal number greater than 0.");
			}
		}
		else
		{
			System.out.println("The number of x values must be an integer greater than 0.");
		}
		
		
		
		
		

	}

}
