import java.util.Scanner;
public class NetPaySummer {

	public static final double FEDERAL_TAX_PERCENT = 10.00;
	public static final double STATE_TAX_PERCENT = 4.5;
	public static final double SS_PERCENT = 6.2;
	public static final double MEDICARE_PERCENT = 1.45;
	public static final double PAY_PER_HOUR = 7.25;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int hoursPerWeek;
		double grossPay;
		double netPay;
		double federalTax;
		double stateTax;
		double medicare;
		double socialSecurity;
		
		hoursPerWeek = 40;
		grossPay = hoursPerWeek * PAY_PER_HOUR;
		federalTax = ((grossPay * FEDERAL_TAX_PERCENT)/100);
		stateTax = ((grossPay * STATE_TAX_PERCENT)/ 100);
		socialSecurity = ((grossPay * SS_PERCENT)/100);
		medicare = ((grossPay * MEDICARE_PERCENT)/100);
		netPay = (grossPay - (federalTax + stateTax + medicare + socialSecurity));
		
		
		System.out.println("Hours per week: " + "\t" + hoursPerWeek);
		
		
		
		
		
		
	}

}
