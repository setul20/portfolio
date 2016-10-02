import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class transducer 
{
	
	private static String states;
	private static String inputalphabet;
	private static String outputalphabet;
	private static String startstate;
	
	public static void printtransducer()
	{
		states = "1, 2, 3, 4, 5, 6";
		inputalphabet = "a-z, zz, xx, 0-9";
		outputalphabet = "a-z, 0-9";
		startstate = "1";
		
		System.out.println("States: "+ states);
		System.out.println("Input Alphabet: " + inputalphabet);
		System.out.println("Output Alphabet: " + outputalphabet);
		System.out.println("Start State: " + startstate);
		
	}
	
	public static void gib2eng() throws IOException
	{
		try {
			FileReader inputstream = new FileReader("gibberish.txt");
			FileWriter outputstream = new FileWriter("english.txt");
			char [] temp = new char[1000];
			
			char test;
			if ((test = (char) inputstream.read(temp,0,1000)) != -1)
			{
				System.out.println(temp);
				for (int i = 0; i <= 526; i++)
				{

					if (temp[i] == 'x' && temp[i] == temp[i+1])
					{
						i++;
						outputstream.write('o');
					}
					else if (temp[i] == 'z' && temp[i] == temp[i+1])
					{
						i++;
						outputstream.write('e');
					}
					else if (temp[i] == '0')
					{
					}
					else if (temp[i] == '1')
					{
					}
					else if (temp[i] == '2')
					{
					}
					else if (temp[i] == '3')
					{
					}
					else if (temp[i] == '4')
					{
					}
					else if (temp[i] == '5')
					{
					}
					else if (temp[i] == '6')
					{
					}
					else if (temp[i] == '7')
					{
					}
					else if (temp[i] == '8')
					{
					}
					else if (temp[i] == '9')
					{
					}
					else if (temp[i] == ' ')
					{
						outputstream.write(' ');
					}
					else
					{
						outputstream.write(temp[i]);
					}
				}
				outputstream.close();
					
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
				
	}

	public static void main(String[] args) throws IOException 
	{
		gib2eng();
		
		
	}

}
