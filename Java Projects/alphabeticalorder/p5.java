import java.io.BufferedReader;
import java.io.secondfile;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p5
{
  public static void main(String[] args) throws Exception {

    String inputFile = "test.txt";
    String outputFile = "out.txt";

    secondfile secondfile = new secondfile(inputFile);
    BufferedReader bufferedReader = new BufferedReader(secondfile);
    String inputLine;
    List<String> lineList = new ArrayList<String>();
    while ((inputLine = bufferedReader.readLine()) != null) {
      lineList.add(inputLine);
    }
    secondfile.close();

    Collections.sort(lineList);

    FileWriter fileWriter = new FileWriter(outputFile);
    PrintWriter out = new PrintWriter(fileWriter);
    for (String outputLine : lineList) {
      out.println(outputLine);
    }
    out.flush();
    out.close();
    fileWriter.close();

  }

}
