/*
		 * CreditCardPayOff.java
		 * Author: Setul Patel
		 * Submission Date: 11-15-2013
		 * 
		 * Purpose: to find the sums of number equaling to some amount using 2 dimensional arrays.
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
public class FindTheSums {
	
	public static String arrayToString (int [][] a)
	{
		String result = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (j + 1 == a[i].length)
					result += (a[i][j]);
				else
					result += (a[i][j] + " ");
			}
			if (i+1 != a.length)
				result += ("\n");
		}
		return result;
	}
	
	public static int [][] horizontalSums (int[][] a, int sumToFind)
	{
		int sum = 0;
		int counter = 0;
		int[][] result;
		result = new int[a.length][a[0].length];
		for (int r = 0; r < result.length; r++) {
			for (int c = 0; c < result[0].length; c++) {
				result[r][c] = 0;
			}
		}
		for (int row = 0; row < a.length; row++)
		{
			boolean repeat = true;
			int k = 0;
			while ( repeat == true) {
				for (int col = k; col < a[row].length; col++)
				{
					sum += a[row][col];
					counter++;
					//if (sum > sumToFind) {
						//sum = 0;
						//break;
					//}
					if (sum == sumToFind) 
					{
						for (int x = 0; x < counter; x++) {
							result[row][x+k] = a[row][x+k];
						}
						counter = 0;
						sum = 0;
					}
				}
				sum = 0;
				counter = 0;
				k++;
				if (k == a[row].length - 1) {repeat = false;}
			}
			sum = 0;
			counter = 0;
		}
		return result;
	}
	
	public static int [][] verticalSums (int [][] a, int sumToFind) {
		int sum = 0;
		int counter = 0;
		int[][] result;
		result = new int[a.length][a[0].length];
		for (int r = 0; r < result.length; r++) {
			for (int c = 0; c < result[0].length; c++) {
				result[r][c] = 0;
			}
		}
		
		for (int col = 0; col < a[0].length; col++) {
			int j = 0;
			boolean repeat2 = true;
			while (repeat2 == true) {
				for (int row = j; row < a.length; row++) {
					sum += a[row][col];
					counter++;
					if (sum == sumToFind) 
					{
						for (int x = 0; x < counter; x++) {
							result[x+j][col] = a[x+j][col];
						}
						counter = 0;
						sum = 0;
					}
				}
				sum = 0;
				counter = 0;
				j++;
				if (j == a.length - 1) {repeat2 = false;}
			}
			sum = 0;
			counter = 0;

		}
		return result;
	}
}
