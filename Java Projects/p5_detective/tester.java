import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.io.PrintWriter;

public class tester
{
  public static void readingFile(String originalFile)
  {
    try
    {
      FileReader file = new FileReader(originalFile);
      BufferedReader reader = new BufferedReader(file);

      String outputfilename = "out.txt";
      PrintWriter outputstream = new PrintWriter(outputfilename);

      String line = "first";

      while(line != null)
      {
        line = reader.readLine();
        //System.out.println(line);
        outputstream.println(line);
      }
      outputstream.close();
      System.out.println("done");
    }
    catch(Exception e)
    {
      System.out.println("File cannot be found");
    }
  }

  public static void main(String [] args)
  {
      readingFile("test.txt");

  }
}