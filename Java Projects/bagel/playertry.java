import java.util.Scanner;


public class Player {

	private String name;
	private int fastestWin;
	private int gameCompleted;
	Scanner keyboard = new Scanner(System.in);
	
	public String askForGuess()
	{
		System.out.print("Enter you guess: ");
		String guess = keyboard.next();
		return guess;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getFastestWin()
	{
		return fastestWin;
	}
	
	public int getGamesCompleted()
	{
		return gameCompleted;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void updateStats(int numberOfMovesTakenToWin)
	{
		
	}
	
	
	
}
