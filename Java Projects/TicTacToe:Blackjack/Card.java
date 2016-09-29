import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class Card
{
	private int value;
	private char suit;
	private String type;
	private BufferedImage cardImg;

	public Card(int i, char c)
	{
		value = i;
		suit = c;

		if(suit == 'c')
		{
			type = "Clubs";
		}
		else if(suit == 'd')
		{
			type = "Diamonds";
		}
		else if(suit == 'h')
		{
			type = "Hearts";
		}
		else
		{
			type = "Spades";
		}



		//assigns card image to card

		switch(value)
		{
			case 1:
				try
				{
					cardImg = ImageIO.read(new File("1.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 2:
				try
				{
					cardImg = ImageIO.read(new File("2.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 3:
				try
				{
					cardImg = ImageIO.read(new File("3.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;

			case 4:
				try
				{
					cardImg = ImageIO.read(new File("4.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 5:
				try
				{
					cardImg = ImageIO.read(new File("5.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 6:
				try
				{
					cardImg = ImageIO.read(new File("6.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 7:
				try
				{
					cardImg = ImageIO.read(new File("7.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 8:
				try
				{
					cardImg = ImageIO.read(new File("8.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 9:
				try
				{
					cardImg = ImageIO.read(new File("9.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 10:
				try
				{
					cardImg = ImageIO.read(new File("10.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 11:
				try
				{
					cardImg = ImageIO.read(new File("11.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 12:
				try
				{
					cardImg = ImageIO.read(new File("12.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 13:
				try
				{
					cardImg = ImageIO.read(new File("13.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 14:
				try
				{
					cardImg = ImageIO.read(new File("14.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 15:
				try
				{
					cardImg = ImageIO.read(new File("15.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 16:
				try
				{
					cardImg = ImageIO.read(new File("16.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 17:
				try
				{
					cardImg = ImageIO.read(new File("17.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 18:
				try
				{
					cardImg = ImageIO.read(new File("18.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 19:
				try
				{
					cardImg = ImageIO.read(new File("19.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 20:
				try
				{
					cardImg = ImageIO.read(new File("20.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 21:
				try
				{
					cardImg = ImageIO.read(new File("21.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 22:
				try
				{
					cardImg = ImageIO.read(new File("22.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 23:
				try
				{
					cardImg = ImageIO.read(new File("23.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 24:
				try
				{
					cardImg = ImageIO.read(new File("24.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 25:
				try
				{
					cardImg = ImageIO.read(new File("25.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 26:
				try
				{
					cardImg = ImageIO.read(new File("26.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 27:
				try
				{
					cardImg = ImageIO.read(new File("27.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 28:
				try
				{
					cardImg = ImageIO.read(new File("28.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 29:
				try
				{
					cardImg = ImageIO.read(new File("29.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 30:
				try
				{
					cardImg = ImageIO.read(new File("30.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 31:
				try
				{
					cardImg = ImageIO.read(new File("31.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 32:
				try
				{
					cardImg = ImageIO.read(new File("32.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 33:
				try
				{
					cardImg = ImageIO.read(new File("33.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 34:
				try
				{
					cardImg = ImageIO.read(new File("34.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 35:
				try
				{
					cardImg = ImageIO.read(new File("35.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 36:
				try
				{
					cardImg = ImageIO.read(new File("36.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 37:
				try
				{
					cardImg = ImageIO.read(new File("37.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 38:
				try
				{
					cardImg = ImageIO.read(new File("38.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 39:
				try
				{
					cardImg = ImageIO.read(new File("39.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 40:
				try
				{
					cardImg = ImageIO.read(new File("40.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 41:
				try
				{
					cardImg = ImageIO.read(new File("41.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 42:
				try
				{
					cardImg = ImageIO.read(new File("42.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 43:
				try
				{
					cardImg = ImageIO.read(new File("43.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 44:
				try
				{
					cardImg = ImageIO.read(new File("44.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 45:
				try
				{
					cardImg = ImageIO.read(new File("45.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 46:
				try
				{
					cardImg = ImageIO.read(new File("46.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 47:
				try
				{
					cardImg = ImageIO.read(new File("47.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 48:
				try
				{
					cardImg = ImageIO.read(new File("48.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 49:
				try
				{
					cardImg = ImageIO.read(new File("49.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 50:
				try
				{
					cardImg = ImageIO.read(new File("50.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 51:
				try
				{
					cardImg = ImageIO.read(new File("51.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;
			case 52:
				try
				{
					cardImg = ImageIO.read(new File("52.png"));
				}
				catch(Exception e)
				{
					System.out.println("Couldnt read card image.");
				}
				break;

			default:

				System.out.println("Something went wrong.");
				System.exit(1);




		}



	}


	public int getValue()
	{
		if( value == 13 || value == 12 || value == 11)
			return 10;
		else
			return value;
	}

	public char getSuit()
	{
		return suit;
	}

	public String getCard()
	{
		if( value == 1)
		{
			return "Ace of " + type;
		}
		else if( value == 13)
		{
			return "King of " + type;
		}
		else if( value == 12)
		{
			return "Queen of " + type;
		}
		else if( value == 11)
		{
			return "Jack of " + type;
		}
		else
		{
			return value + " of " + type;
		}
	}

	public BufferedImage getImage()
	{
		return cardImg;
	}


}
