import java.util.Scanner;
public class Bagels {

	public static void main(String[] args) {

		Player player1 = new Player();
		Engine engine1 = new Engine();
		
		int numDigits;
		String name;
		boolean maingame = true;
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome");
		
		
		
		
		System.out.print("Enter the number of digits to use: ");
		numDigits = keyboard.nextInt();
		engine1.setNumDigits(numDigits);
		System.out.print("Enters the player's name: ");
		name = keyboard.next();
		player1.setName(name);
		
		while (maingame == true)
		{
			
		}
		
		
		
		
		
	}

}
