import java.util.Scanner;  //importing the Scanner Class
public class CreditCardPayOff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * CreditCardPayOff.java
		 * Author: Setul Patel
		 * Submission Date: 9-6-2013
		 * 
		 * Prupose: to calculate months needed to payoff credit card bills.
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
	
		//overpayment = ((needed * monthly) - amount)
		//overpayment = Math.abs(overpayment)
		//overpayment is the raw value multiplied by monthly payment
		//then you subtract the total amount that you calculated from the int for months needed
		//take the absolute value of that value and that is your overpayment!!!
		
	double principal;  //declaring all the variables needed
	double annual;
	double monthly;
	double needed;
	int needed1;
	double amount;
	double interest;
	double overpayment;
	
	Scanner keyboard = new Scanner(System.in);    //letting the user put in principal value
	System.out.print("Principal: \t \t \t");
	principal = keyboard.nextDouble();
	
	System.out.print("Annual Interest Rate (%): \t");   //letting the user put the interest rate
	annual = keyboard.nextDouble();
	
	System.out.print("Monthly Payment: \t \t");   //letting the user put the monthly payment
	monthly = keyboard.nextDouble();
	
	System.out.println();    //empty space
	
	needed = (Math.log(monthly)-Math.log(monthly-(annual/1200.0)*principal))/(Math.log((annual/1200.0)+1));
	//the big formula to calculate the months needed to pay off
	needed1 = (int)Math.ceil(needed);   //casting the raw value to int
	System.out.println("Months Needed To Pay Off: \t" + needed1);   //printing the int value out as months needed
	
	amount = needed1 * monthly;  //calculating total amount paid
	System.out.println("Total Amount Paid: \t \t" + "$" + amount); //printing out the total amount paid
	
	interest = principal - amount;   //calculating total interest paid
	interest = Math.abs(interest);
	interest = Math.round(interest*100);
	interest = interest/100;
	System.out.println("Total Interest Paid: \t \t" + "$" + interest);  //printing the total interest paid
	
	overpayment = ((needed * monthly) - amount); //calculating the overpayment
	overpayment = Math.abs(overpayment);
	overpayment = Math.round(overpayment * 100);
	overpayment = overpayment/100;
	System.out.println("Overpayment: \t \t \t" + "$" + overpayment); //printing the overpayment
	
		
		
		
	}

}
