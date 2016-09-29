import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class SecretDecoder
{


	//reading file
	public static BufferedImage readFile(String inputFile, String initialColor, String finalColor)
	{

		BufferedImage inputImage = null;

		//Error handling
		try
		{
			File inputFile = new File(inputFile);
			inputImage = ImageIO.read(inputFile);
		}
		catch(IOException e)
		{
			System.err.println("Error: could not load the image file. Please try again.");
			System.exit(0);
		}

		//Transfer initialColor string to Color find

		Color find=new Color(0,0,0);
		Color change=new Color(0,0,0);

		if(initialColor.toLowerCase().equals("green"))
		{
			find = new Color(0, 255, 0);
		}
		else if(initialColor.toLowerCase().equals("blue"))
		{
			find = new Color(0, 0, 255);
		}
		else if(initialColor.toLowerCase().equals("white"))
		{
			find = new Color(255, 255, 255);
		}
		else if(initialColor.toLowerCase().equals("red"))
		{
			find = new Color(255, 0, 0);
		}
		else if(initialColor.toLowerCase().equals("cyan"))
		{
			find = new Color(0, 255, 255);
		}
		else if((initialColor.toLowerCase().equals("gray")) || (initialColor.toLowerCase().equals("grey")))
		{
			find = new Color(128, 128, 128);
		}
		else
		{
			System.err.println("Invalid color to encode. Please choose from green, white, red, blue, cyan, and gray.");
			System.exit(0);
		}

		//Transfer finalColor string to Color change

		if(finalColor.toLowerCase().equals("green"))
		{
			change = new Color(0, 255, 0);
		}
		else if(finalColor.toLowerCase().equals("blue"))
		{
			change = new Color(0, 0, 255);
		}
		else if(finalColor.toLowerCase().equals("white"))
		{
			change = new Color(255, 255, 255);
		}
		else if(finalColor.toLowerCase().equals("red"))
		{
			change = new Color(255, 0, 0);
		}
		else if(finalColor.toLowerCase().equals("cyan"))
		{
			change = new Color(0, 255, 255);
		}
		else if((finalColor.toLowerCase().equals("gray")) || (finalColor.toLowerCase().equals("grey")))
		{
			change = new Color(128, 128, 128);
		}
		else
		{
			System.err.println("Invalid color to decode. Please choose from green, white, red, blue, cyan, and gray.");
			System.exit(0);
		}


		//create new BufferedImage
		BufferedImage newinputImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), inputImage.getType());
		for(int y=0; y<inputImage.getHeight(); ++y)
		{
			for(int x=0; x<inputImage.getWidth(); ++x)
			{

				Color pixelColor = new Color(inputImage.getRGB(x,y));

				if(pixelColor.equals(find))
				{
					pixelColor = change;
				}

				newinputImage.setRGB(x, y, pixelColor.getRGB());
			}
		}


		return newinputImage;
	}

	//Create file out of BuffferedImage
	public static void crtFile(BufferedImage img, String pathFile)
	{
		//Exception Handling
		try {
			File outputFile = new File(pathFile);
			ImageIO.write(img, "png", outputFile);
		} catch(IOException e) {
			System.err.println("Error: could not load the image.");
			System.exit(0);
		}

	}

	public static void main (String[] args)
	{

		//Check number of arguments
		if((args.length > 4)||(args.length < 4))
		{
			System.err.println("Wrong number of arguments.");
			System.exit(0);
		}

		//User input parameters
		String inputFile = args[0];
		String initialColor = args[1];
		String finalColor = args[2];
		String outputFile = args[3];
		BufferedImage finalImage = null;

		//Check output file is .png
		if(!(outputFile.substring(outputFile.lastIndexOf('.') + 1).equalsIgnoreCase("png")))
		{
			System.err.println("Output file must be a .png file. Please try again.");
			System.exit(0);
		}

		//helper functions invoked
		finalImage = readFile(inputFile, initialColor, finalColor);
		crtFile(finalImage,outputFile);
	}

}
