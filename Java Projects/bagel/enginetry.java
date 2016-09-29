
public class Engine {
	
	private int numDigits;
	private int secretNumber;
	
	
	public int[] convertNumToDigitArray(String number)
	{
		
	}
	
	public int getNumDigits()
	{
		return numDigits;
	}
	
	public int[] getSecretNumber()
	{
		
	}
	
	public void generateNewSecret()
	{
		if (numDigits == 2)
		{
			this.secretNumber = (int)(Math.random() * 90) +10;
		}
		if (numDigits ==3)
		{
			this.secretNumber = (int)(Math.random() * 900) +100;
		}
	}
	
	public void setNumDigits(int numDigits)
	{
		this.numDigits = numDigits;
	}
	
	

}
