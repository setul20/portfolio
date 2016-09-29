
import java.util.Scanner;
public class NetPay {
	
	public static final double FEDERAL_TAX_PERCENT = 10.00;
	public static final double STATE_TAX_PERCENT = 4.5;
	public static final double SS_PERCENT = 6.2;
	public static final double MEDICARE_PERCENT = 1.45;
	public static final double PAY_PER_HOUR = 7.25;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * NetPay.java
		 * Author: Setul Patel
		 * Submission Date: 8-30-2013
		 * 
		 * Prupose: to compute a person�s gross and net pay based on their hourly wage, hours
		 * worked, and several withholdings.
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
		
	int hoursPerWeek;
	double grossPay;
	double netPay;
	double federalTax;
	double stateTax;
	double medicare;
	double socialSecurity;
	
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter the number of Hours Per Week:");
	hoursPerWeek = keyboard.nextInt();
	grossPay = hoursPerWeek * PAY_PER_HOUR;
	federalTax = (grossPay * FEDERAL_TAX_PERCENT)/ 100;
	stateTax = (grossPay * STATE_TAX_PERCENT)/ 100;
	socialSecurity = (grossPay * SS_PERCENT)/ 100;
	medicare = (grossPay * MEDICARE_PERCENT)/ 100;
	netPay = grossPay - (federalTax + stateTax + medicare + socialSecurity);
	
	System.out.println("Hours Per Week: " + "\t" + hoursPerWeek );
	System.out.println("Gross Pay: " + "\t" + "\t" + grossPay );	
	System.out.println("Net Pay: " + "\t" + "\t" + netPay);
	System.out.println("");
	System.out.println("Deduction");
	System.out.println("Federal Tax: " + "\t" + "\t" + federalTax );
	System.out.println("State Tax: " + "\t" + "\t" + stateTax);
	System.out.println("Social Security: " + "\t" + socialSecurity);
	medicare = Math.round(medicare * 100);
	medicare = medicare/100;
	System.out.println("Medicare: " + "\t" + "\t" + medicare);
	
	
	
	}

}
