import java.util.Scanner;
public class RockPaperScissorsLizardSpock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * RockPaperScissorsLizardSpock.java
		 * Author: Setul Patel
		 * Submission Date: 9-20-2013
		 * 
		 * Prupose: to create a program that plays Rock Paper Scissors Lizard Spock.
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
	String answer;
	String round1;
	String round2;
	String round3;
	String computer;
	int compscore = 0;
	int userscore = 0;
	
	System.out.print("Would you like to play Rock Paper Scissors Lizard Spock? (y/n)   ");
	answer = keyboard.next();
	System.out.println();
	computer = RockPaperScissorsLizardSpockComputerPlayer.getChoice();
	
	if (answer.substring(0,1).equalsIgnoreCase("y"))
		{System.out.print(
				"Round 1\n"+
		        "Which gesture would you like to choose . . .\n"+
				"  1)  rock\n"+
		        "  2)  paper\n"+
				"  3)  scissors\n"+
		        "  4)  lizard\n"+
				"  5)  spock\n");
		System.out.print("Please enter your choice (1-5): ");
		round1 = keyboard.next();		
		//System.out.print("The computer player chooses " + computer + ". \n");
		
		if (round1.substring(0,1).equals("1"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("rock"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			 if (computer.equals("paper"))
			    {System.out.println("Paper covers Rock.\nThe computer player wins a point.");
			 	//System.out.println("The computer player wins a point.");
			 	compscore++;}
			 if (computer.equals("scissors"))   
				{System.out.println("Rock smashes Scissors.\nCongratulations! You win a point.");
			 	//System.out.println("Congratulations! You win a point.");
			 	userscore++;}
			 if (computer.equals("lizard"))
				{System.out.println("Rock crushes Lizard.\nCongratulations! You win a point.");
			 	//System.out.println("Congratulations! You win a point.");
			 	userscore++;}
			 if (computer.equals("spock"))
				{System.out.println("Spock vaporizes Rock.\nThe computer player wins a point.");
			 	//System.out.println("The computer player wins a point.");
			 	compscore++;}}
		
		else if (round1.substring(0,1).equals("2"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("paper"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("rock"))
				{System.out.println("Paper covers Rock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("scissors"))
				{System.out.println("Scissors cuts Papers.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("lizard"))
				{System.out.println("Lizard eats Papers.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("spock"))
				{System.out.println("Paper disproves Spock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else if (round1.substring(0,1).equals("3"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("scissors"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("paper"))
				{System.out.println("Scissors cuts Papers.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("rock"))
				{System.out.println("Rock crushes Scissors.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("lizard"))
				{System.out.println("Scissors decapitates Lizard.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("spock"))
				{System.out.println("Spock smashes Scissors.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}}
		
		else if (round1.substring(0,1).equals("4"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("lizard"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("scissors"))
				{System.out.println("Scissors decapitates Lizard.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("paper"))
				{System.out.println("Lizard eats paper.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("rock"))
				{System.out.println("Rock crushes Lizard.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("spock"))
				{System.out.println("Lizard poisons Spock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else if (round1.substring(0,1).equals("5"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("spock"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("lizard"))
				{System.out.println("Lizard poisons Spock.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("scissors"))
				{System.out.println("Spock smashes Scissors.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("paper"))
				{System.out.println("Paper disproves Spock.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("rock"))
				{System.out.println("Spock vaporizes Rock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else 
			{System.out.println("The input you entered is invalid.");
		System.out.print(
				"Round 1\n"+
		        "Which gesture would you like to choose . . .\n"+
				"  1)  rock\n"+
		        "  2)  paper\n"+
				"  3)  scissors\n"+
		        "  4)  lizard\n"+
				"  5)  spock\n");
		System.out.print("Please enter your choice (1-5): ");
		round1 = keyboard.next();		
		//System.out.print("The computer player chooses " + computer + ". \n");
		
	    if (round1.substring(0,1).equals("1"))
		{System.out.print("The computer player chooses " + computer + ". \n");
	    	if (computer.equals("rock"))
			{System.out.println("You tied with the computer.\nNo points awarded.");}
			//System.out.println("No points awarded.");
		 if (computer.equals("paper"))
		    {System.out.println("Paper covers Rock.\nThe computer player wins a point.");
		 	//System.out.println("The computer player wins a point.");
		 	compscore++;}
		 if (computer.equals("scissors"))   
			{System.out.println("Rock smashes Scissors.\nCongratulations! You win a point.");
		 	//System.out.println("Congratulations! You win a point.");
		 	userscore++;}
		 if (computer.equals("lizard"))
			{System.out.println("Rock crushes Lizard.\nCongratulations! You win a point.");
		 	//System.out.println("Congratulations! You win a point.");
		 	userscore++;}
		 if (computer.equals("spock"))
			{System.out.println("Spock vaporizes Rock.\nThe computer player wins a point.");
		 	//System.out.println("The computer player wins a point.");
		 	compscore++;}}
	
	else if (round1.substring(0,1).equals("2"))
		{System.out.print("The computer player chooses " + computer + ". \n");
		if (computer.equals("paper"))
			{System.out.println("You tied with the computer.\nNo points awarded.");}
			//System.out.println("No points awarded.");
		if (computer.equals("rock"))
			{System.out.println("Paper covers Rock.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}
		if (computer.equals("scissors"))
			{System.out.println("Scissors cuts Papers.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("lizard"))
			{System.out.println("Lizard eats Papers.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("spock"))
			{System.out.println("Paper disproves Spock.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}}
	
	else if (round1.substring(0,1).equals("3"))
		{System.out.print("The computer player chooses " + computer + ". \n");
		if (computer.equals("scissors"))
			{System.out.println("You tied with the computer.\nNo points awarded.");}
			//System.out.println("No points awarded.");
		if (computer.equals("paper"))
			{System.out.println("Scissors cuts Papers.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}
		if (computer.equals("rock"))
			{System.out.println("Rock crushes Scissors.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("lizard"))
			{System.out.println("Scissors decapitates Lizard.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}
		if (computer.equals("spock"))
			{System.out.println("Spock smashes Scissors.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}}
	
	else if (round1.substring(0,1).equals("4"))
		{System.out.print("The computer player chooses " + computer + ". \n");
		if (computer.equals("lizard"))
			{System.out.println("You tied with the computer.\nNo points awarded.");}
			//System.out.println("No points awarded.");
		if (computer.equals("scissors"))
			{System.out.println("Scissors decapitates Lizard.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("paper"))
			{System.out.println("Lizard eats paper.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}
		if (computer.equals("rock"))
			{System.out.println("Rock crushes Lizard.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("spock"))
			{System.out.println("Lizard poisons Spock.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}}
	
	else if (round1.substring(0,1).equals("5"))
		{System.out.print("The computer player chooses " + computer + ". \n");
		if (computer.equals("spock"))
			{System.out.println("You tied with the computer.\nNo points awarded.");}
			//System.out.println("No points awarded.");
		if (computer.equals("lizard"))
			{System.out.println("Lizard poisons Spock.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("scissors"))
			{System.out.println("Spock smashes Scissors.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}
		if (computer.equals("paper"))
			{System.out.println("Paper disproves Spock.\nThe computer player wins a point.");
			//System.out.println("The computer player wins a point.");
			compscore++;}
		if (computer.equals("rock"))
			{System.out.println("Spock vaporizes Rock.\nCongratulations! You won a point.");
			//System.out.println("Congratulations! You won a point.");
			userscore++;}}
	
	else 
		{System.out.println("You entered too many invalid inputs.\nGood Bye!");
		System.exit(0);}}
		
		System.out.println();
		System.out.println();
		System.out.print(
				"Round 2\n"+
		        "Which gesture would you like to choose . . .\n"+
				"  1)  rock\n"+
		        "  2)  paper\n"+
				"  3)  scissors\n"+
		        "  4)  lizard\n"+
				"  5)  spock\n");
		System.out.print("Please enter your choice (1-5): ");
		round2 = keyboard.next();		
		//System.out.print("The computer player chooses " + computer + ". \n");
		
		if (round2.substring(0,1).equals("1"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("rock"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			 if (computer.equals("paper"))
			    {System.out.println("Paper covers Rock.\nThe computer player wins a point.");
			 	//System.out.println("The computer player wins a point.");
			 	compscore++;}
			 if (computer.equals("scissors"))   
				{System.out.println("Rock smashes Scissors.\nCongratulations! You win a point.");
			 	//System.out.println("Congratulations! You win a point.");
			 	userscore++;}
			 if (computer.equals("lizard"))
				{System.out.println("Rock crushes Lizard.\nCongratulations! You win a point.");
			 	//System.out.println("Congratulations! You win a point.");
			 	userscore++;}
			 if (computer.equals("spock"))
				{System.out.println("Spock vaporizes Rock.\nThe computer player wins a point.");
			 	//System.out.println("The computer player wins a point.");
			 	compscore++;}}
		
		else if (round2.substring(0,1).equals("2"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("paper"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("rock"))
				{System.out.println("Paper covers Rock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("scissors"))
				{System.out.println("Scissors cuts Papers.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("lizard"))
				{System.out.println("Lizard eats Papers.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("spock"))
				{System.out.println("Paper disproves Spock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else if (round2.substring(0,1).equals("3"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("scissors"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("paper"))
				{System.out.println("Scissors cuts Papers.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("rock"))
				{System.out.println("Rock crushes Scissors.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("lizard"))
				{System.out.println("Scissors decapitates Lizard.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("spock"))
				{System.out.println("Spock smashes Scissors.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}}
		
		else if (round2.substring(0,1).equals("4"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("lizard"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("scissors"))
				{System.out.println("Scissors decapitates Lizard.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("paper"))
				{System.out.println("Lizard eats paper.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("rock"))
				{System.out.println("Rock crushes Lizard.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("spock"))
				{System.out.println("Lizard poisons Spock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else if (round2.substring(0,1).equals("5"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("spock"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("lizard"))
				{System.out.println("Lizard poisons Spock.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("scissors"))
				{System.out.println("Spock smashes Scissors.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("paper"))
				{System.out.println("Paper disproves Spock.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("rock"))
				{System.out.println("Spock vaporizes Rock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		else 
			{System.out.println("The input you entered is invalid.");
			System.out.print(
					"Round 2\n"+
			        "Which gesture would you like to choose . . .\n"+
					"  1)  rock\n"+
			        "  2)  paper\n"+
					"  3)  scissors\n"+
			        "  4)  lizard\n"+
					"  5)  spock\n");
			System.out.print("Please enter your choice (1-5): ");
			round2 = keyboard.next();		
			//System.out.print("The computer player chooses " + computer + ". \n");
			
			if (round2.substring(0,1).equals("1"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("rock"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				 if (computer.equals("paper"))
				    {System.out.println("Paper covers Rock.\nThe computer player wins a point.");
				 	//System.out.println("The computer player wins a point.");
				 	compscore++;}
				 if (computer.equals("scissors"))   
					{System.out.println("Rock smashes Scissors.\nCongratulations! You win a point.");
				 	//System.out.println("Congratulations! You win a point.");
				 	userscore++;}
				 if (computer.equals("lizard"))
					{System.out.println("Rock crushes Lizard.\nCongratulations! You win a point.");
				 	//System.out.println("Congratulations! You win a point.");
				 	userscore++;}
				 if (computer.equals("spock"))
					{System.out.println("Spock vaporizes Rock.\nThe computer player wins a point.");
				 	//System.out.println("The computer player wins a point.");
				 	compscore++;}}
			
			else if (round2.substring(0,1).equals("2"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("paper"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("rock"))
					{System.out.println("Paper covers Rock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("scissors"))
					{System.out.println("Scissors cuts Papers.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("lizard"))
					{System.out.println("Lizard eats Papers.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("spock"))
					{System.out.println("Paper disproves Spock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}}
			
			else if (round2.substring(0,1).equals("3"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("scissors"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("paper"))
					{System.out.println("Scissors cuts Papers.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("rock"))
					{System.out.println("Rock crushes Scissors.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("lizard"))
					{System.out.println("Scissors decapitates Lizard.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("spock"))
					{System.out.println("Spock smashes Scissors.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}}
			
			else if (round2.substring(0,1).equals("4"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("lizard"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("scissors"))
					{System.out.println("Scissors decapitates Lizard.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("paper"))
					{System.out.println("Lizard eats paper.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("rock"))
					{System.out.println("Rock crushes Lizard.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("spock"))
					{System.out.println("Lizard poisons Spock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}}
			
			else if (round2.substring(0,1).equals("5"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("spock"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("lizard"))
					{System.out.println("Lizard poisons Spock.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("scissors"))
					{System.out.println("Spock smashes Scissors.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("paper"))
					{System.out.println("Paper disproves Spock.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("rock"))
					{System.out.println("Spock vaporizes Rock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}}
			else 
				{System.out.println("The entered too many invalid inputs.\nGood Bye!");
				System.exit(0);}}
		
		System.out.println();
		System.out.println();
		System.out.print(
				"Round 3\n"+
		        "Which gesture would you like to choose . . .\n"+
				"  1)  rock\n"+
		        "  2)  paper\n"+
				"  3)  scissors\n"+
		        "  4)  lizard\n"+
				"  5)  spock\n");
		System.out.print("Please enter your choice (1-5): ");
		round3 = keyboard.next();		
		//System.out.print("The computer player chooses " + computer + ". \n");
		
		if (round3.substring(0,1).equals("1"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("rock"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			 if (computer.equals("paper"))
			    {System.out.println("Paper covers Rock.\nThe computer player wins a point.");
			 	//System.out.println("The computer player wins a point.");
			 	compscore++;}
			 if (computer.equals("scissors"))   
				{System.out.println("Rock smashes Scissors.\nCongratulations! You win a point.");
			 	//System.out.println("Congratulations! You win a point.");
			 	userscore++;}
			 if (computer.equals("lizard"))
				{System.out.println("Rock crushes Lizard.\nCongratulations! You win a point.");
			 	//System.out.println("Congratulations! You win a point.");
			 	userscore++;}
			 if (computer.equals("spock"))
				{System.out.println("Spock vaporizes Rock.\nThe computer player wins a point.");
			 	//System.out.println("The computer player wins a point.");
			 	compscore++;}}
		
		else if (round3.substring(0,1).equals("2"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("paper"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("rock"))
				{System.out.println("Paper covers Rock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("scissors"))
				{System.out.println("Scissors cuts Papers.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("lizard"))
				{System.out.println("Lizard eats Papers.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("spock"))
				{System.out.println("Paper disproves Spock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else if (round3.substring(0,1).equals("3"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("scissors"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("paper"))
				{System.out.println("Scissors cuts Papers.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("rock"))
				{System.out.println("Rock crushes Scissors.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("lizard"))
				{System.out.println("Scissors decapitates Lizard.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("spock"))
				{System.out.println("Spock smashes Scissors.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}}
		
		else if (round3.substring(0,1).equals("4"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("lizard"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("scissors"))
				{System.out.println("Scissors decapitates Lizard.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("paper"))
				{System.out.println("Lizard eats paper.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("rock"))
				{System.out.println("Rock crushes Lizard.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("spock"))
				{System.out.println("Lizard poisons Spock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		
		else if (round3.substring(0,1).equals("5"))
			{System.out.print("The computer player chooses " + computer + ". \n");
			if (computer.equals("spock"))
				{System.out.println("You tied with the computer.\nNo points awarded.");}
				//System.out.println("No points awarded.");
			if (computer.equals("lizard"))
				{System.out.println("Lizard poisons Spock.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("scissors"))
				{System.out.println("Spock smashes Scissors.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}
			if (computer.equals("paper"))
				{System.out.println("Paper disproves Spock.\nThe computer player wins a point.");
				//System.out.println("The computer player wins a point.");
				compscore++;}
			if (computer.equals("rock"))
				{System.out.println("Spock vaporizes Rock.\nCongratulations! You won a point.");
				//System.out.println("Congratulations! You won a point.");
				userscore++;}}
		else 
			{System.out.println("The input you entered is invalid");
			System.out.print(
					"Round 3\n"+
			        "Which gesture would you like to choose . . .\n"+
					"  1)  rock\n"+
			        "  2)  paper\n"+
					"  3)  scissors\n"+
			        "  4)  lizard\n"+
					"  5)  spock\n");
			System.out.print("Please enter your choice (1-5): ");
			round3 = keyboard.next();		
			//System.out.print("The computer player chooses " + computer + ". \n");
			
			if (round3.substring(0,1).equals("1"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("rock"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				 if (computer.equals("paper"))
				    {System.out.println("Paper covers Rock.\nThe computer player wins a point.");
				 	//System.out.println("The computer player wins a point.");
				 	compscore++;}
				 if (computer.equals("scissors"))   
					{System.out.println("Rock smashes Scissors.\nCongratulations! You win a point.");
				 	//System.out.println("Congratulations! You win a point.");
				 	userscore++;}
				 if (computer.equals("lizard"))
					{System.out.println("Rock crushes Lizard.\nCongratulations! You win a point.");
				 	//System.out.println("Congratulations! You win a point.");
				 	userscore++;}
				 if (computer.equals("spock"))
					{System.out.println("Spock vaporizes Rock.\nThe computer player wins a point.");
				 	//System.out.println("The computer player wins a point.");
				 	compscore++;}}
			
			else if (round3.substring(0,1).equals("2"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("paper"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("rock"))
					{System.out.println("Paper covers Rock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("scissors"))
					{System.out.println("Scissors cuts Papers.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("lizard"))
					{System.out.println("Lizard eats Papers.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("spock"))
					{System.out.println("Paper disproves Spock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}}
			
			else if (round3.substring(0,1).equals("3"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("scissors"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("paper"))
					{System.out.println("Scissors cuts Papers.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("rock"))
					{System.out.println("Rock crushes Scissors.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("lizard"))
					{System.out.println("Scissors decapitates Lizard.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("spock"))
					{System.out.println("Spock smashes Scissors.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}}
			
			else if (round3.substring(0,1).equals("4"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("lizard"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("scissors"))
					{System.out.println("Scissors decapitates Lizard.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("paper"))
					{System.out.println("Lizard eats paper.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("rock"))
					{System.out.println("Rock crushes Lizard.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("spock"))
					{System.out.println("Lizard poisons Spock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}}
			
			else if (round3.substring(0,1).equals("5"))
				{System.out.print("The computer player chooses " + computer + ". \n");
				if (computer.equals("spock"))
					{System.out.println("You tied with the computer.\nNo points awarded.");}
					//System.out.println("No points awarded.");
				if (computer.equals("lizard"))
					{System.out.println("Lizard poisons Spock.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("scissors"))
					{System.out.println("Spock smashes Scissors.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}
				if (computer.equals("paper"))
					{System.out.println("Paper disproves Spock.\nThe computer player wins a point.");
					//System.out.println("The computer player wins a point.");
					compscore++;}
				if (computer.equals("rock"))
					{System.out.println("Spock vaporizes Rock.\nCongratulations! You won a point.");
					//System.out.println("Congratulations! You won a point.");
					userscore++;}}
			else 
				{System.out.println("The entered too many invalid inputs.\nGood Bye!");
				System.exit(0);
				}
			}
		
		System.out.println();
		System.out.println("Game Over");
		System.out.println("Your final score is " + userscore);
		System.out.println("The computer player's final score is " + compscore);
		
		if (userscore > compscore)
			{System.out.println("Congratulations! You won against the computer player.\nGood Bye!");}
		else 
			{System.out.println("You lost against the computer player.\nGood Bye!");}
	System.exit(0);}
	
	else if (answer.equalsIgnoreCase("n"))
		{  System.out.println("Goodbye!");
		   System.exit(0);
		}
		
	else
		{  System.out.println("The input you entered is invalid");
		}
		
	
	
	
	
	
	}

}
