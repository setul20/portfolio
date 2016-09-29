import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.PrintWriter;
import java.util.List;
import java.io.FileWriter;


public class P5_Detective
{

	public static void readingFile(String originalFile)
	{
		//checks if the file exist or not
		try
		{
			//reading the file 
			FileReader file = new FileReader(originalFile);
			BufferedReader reader = new BufferedReader(file);

			String outputfilename = "out.txt";
			PrintWriter outputstream = new PrintWriter(outputfilename);

			//reading the file and adding the content to a list array and it writes the canonical form of each word to a file
			String line = "first";
			List<String> originallistarray = new ArrayList<String>();

			while(line != null)
			{
				line = reader.readLine();
				originallistarray.add(line);

				if (line != null)
				{
					line = canonical(line);
					outputstream.println(line);
				}
			}
			outputstream.close();
			reader.close();
			file.close();

			//takes the file that contains the canonical form of word and puts it in a list array
			String tempinputFile = "out.txt";
			String outputFile = "output.txt";

			FileReader secondfile = new FileReader(tempinputFile);
			BufferedReader secondreader = new BufferedReader(secondfile);

			String newLine;
			List<String> listinfinal = new ArrayList<String>();

			while ((newLine = secondreader.readLine()) != null)
			{
				listinfinal.add(newLine);
			}

			secondfile.close();

			//this sorts the array into alphabetical order
			Collections.sort(listinfinal);

			//this writes the alphabetically ordered array to a new file
			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter finalwriter = new PrintWriter(fileWriter);

			for(int i = 0; i < listinfinal.size(); i++)
			{
				finalwriter.println(listinfinal.get(i));
			}


			finalwriter.close();
			fileWriter.close();

			//deletes the second file created
			File deletefile = new File(tempinputFile);
			deletefile.delete();


			//it compares the two list arrays created and if the canonical form of a word equals on of the lines in 
			//new file created above than it creates the final output file that contains the original word ordered alphabetically through canonical
			String tempvar;
			String tempvar1;
			String finalfinaloutputfile = "finalOutput.txt";

			FileWriter fileWriter1 = new FileWriter(finalfinaloutputfile);
			PrintWriter finalfinalwriter = new PrintWriter(fileWriter1);

			for (int j = 0; j < listinfinal.size(); j++)
			{
				tempvar = listinfinal.get(j);

				for (int k = 0; k < originallistarray.size(); k++)
				{
					tempvar1 = canonical(originallistarray.get(k));

					if (tempvar.compareToIgnoreCase(tempvar1) == 0)
					{
						finalfinalwriter.println(originallistarray.get(k));
						break;
					}
				}

			}

			fileWriter1.close();
			finalfinalwriter.close();

			File deletefile1 = new File(outputFile);
			deletefile1.delete();


		}
		catch(Exception e)
		{
			System.out.println("File cannot be found");
		}
	}

	//checks if the words enter are anagrams or not
	public static boolean anagram(String word1, String word2)
	{
		if(word1.length() != word2.length())
		{
			return false;
		}

		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();

		if (canonical(word1).equals(canonical(word2)))
		{
			return true;
		}



		return false;
	}

	//puts each word into its canonical form
	public static String canonical(String word)
	{
		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);

		return String.valueOf(wordArray);
	}

	//this checks whether the word entered exist in the dictionary 
	public static boolean checkIn(String word, String originalfile)
	{
		boolean value = false;
		try
		{
			FileReader filereader = new FileReader(originalfile);
			BufferedReader reader = new BufferedReader(filereader);

			String tempword = "temporary";
			while (tempword != null)
			{
				tempword = reader.readLine();
				if (word.compareToIgnoreCase(tempword) == 0)
				{
					value = true;
					break;
				}
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File cannot be found!");
			System.exit(0);
		}
		finally
		{
			return value;
		}


	}

	public static void main(String [] args)
	{
		String filename = args [0];
		String word1 = args[1];
		String word2 = args[2];

		//checks if none of the words entered exist
		if ((checkIn(word1, filename) == false) && (checkIn(word2, filename) == false))
		{
			System.out.println(word1 + " and " + word2 + " were not found in the dictionary!!!");
		}
		//checks if onely one of them exist or if both of them exist than checks if they are anagrams or not
		else if (checkIn(word1, filename) == true)
		{
			if(checkIn(word2, filename) == true)
			{
				if (anagram(word1,word2) == true)
				{
					System.out.println(word1 + " and " + word2 + " are anagrams of each other!");
				}
				else
				{
					System.out.println(word1 + " and " + word2 + " are not anagrams of each other!");
				}
			}
			else
			{
				System.out.println(word2 + " was not found in the dictionary!!!");
			}
		}
		else
		{
			System.out.println(word1 + " was not found in the dictionary!!!");
		}

		//does all the magic of putting the files into order
		readingFile(filename);


	}

}
