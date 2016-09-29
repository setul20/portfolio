import java.util.*;

public class Shoe
{

	ArrayList origShoe = new ArrayList();
	ArrayList dealtShoe = new ArrayList();
	int handValue1 = 0;
	int handValue2 = 0;
	int cardCount = 52;
	Random rn = new Random();
	int rCard;
	int checkHand = 1;

	Card one = new Card(1,'c');
	Card two = new Card(1,'s');
	Card three = new Card(1,'h');
	Card four = new Card(1,'d');
	Card five = new Card(13,'c');
	Card six = new Card(13,'s');
	Card seven = new Card(13,'h');
	Card eight = new Card(13,'d');
	Card nine = new Card(12,'c');
	Card ten = new Card(12,'s');
	Card eleven = new Card(12,'h');
	Card twelve = new Card(12,'d');
	Card thirteen = new Card(11,'c');
	Card fourteen = new Card(11,'s');
	Card fifteen = new Card(11,'h');
	Card sixteen = new Card(11,'d');
	Card seventeen = new Card(10,'c');
	Card eighteen = new Card(10,'s');
	Card nineteen = new Card(10,'h');
	Card twenty = new Card(10,'d');
	Card twentyOne = new Card(9,'c');
	Card twentyTwo = new Card(9,'s');
	Card twentyThree = new Card(9,'h');
	Card twentyFour = new Card(9,'d');
	Card twentyFive = new Card(8,'c');
	Card twentySix = new Card(8,'s');
	Card twentySeven = new Card(8,'h');
	Card twentyEight = new Card(8,'d');
	Card twentyNine = new Card(7,'c');
	Card thirty = new Card(7,'s');
	Card thirtyOne = new Card(7,'h');
	Card thirtyTwo = new Card(7,'d');
	Card thirtyThree = new Card(6,'c');
	Card thirtyFour = new Card(6,'s');
	Card thirtyFive = new Card(6,'h');
	Card thirtySix = new Card(6,'d');
	Card thirtySeven = new Card(5,'c');
	Card thirtyEight = new Card(5,'s');
	Card thirtyNine = new Card(5,'h');
	Card fourty = new Card(5,'d');
	Card fourtyOne = new Card(4,'c');
	Card fourtyTwo = new Card(4,'s');
	Card fourtyThree = new Card(4,'h');
	Card fourtyFour = new Card(4,'d');
	Card fourtyFive = new Card(3,'c');
	Card fourtySix = new Card(3,'s');
	Card fourtySeven = new Card(3,'h');
	Card fourtyEight = new Card(3,'d');
	Card fourtyNine = new Card(2,'c');
	Card fifty = new Card(2,'s');
	Card fiftyOne = new Card(2,'h');
	Card fiftyTwo = new Card(2,'d');



	public Shoe()
	{


		origShoe.add(one);
		origShoe.add(two);
		origShoe.add(three);
		origShoe.add(four);
		origShoe.add(five);
		origShoe.add(six);
		origShoe.add(seven);
		origShoe.add(eight);
		origShoe.add(nine);
		origShoe.add(ten);
		origShoe.add(eleven);
		origShoe.add(twelve);
		origShoe.add(thirteen);
		origShoe.add(fourteen);
		origShoe.add(fifteen);
		origShoe.add(sixteen);
		origShoe.add(seventeen);
		origShoe.add(eighteen);
		origShoe.add(nineteen);
		origShoe.add(twenty);
		origShoe.add(twentyOne);
		origShoe.add(twentyTwo);
		origShoe.add(twentyThree);
		origShoe.add(twentyFour);
		origShoe.add(twentyFive);
		origShoe.add(twentySix);
		origShoe.add(twentySeven);
		origShoe.add(twentyEight);
		origShoe.add(twentyNine);
		origShoe.add(thirty);
		origShoe.add(thirtyOne);
		origShoe.add(thirtyTwo);
		origShoe.add(thirtyThree);
		origShoe.add(thirtyFour);
		origShoe.add(thirtyFive);
		origShoe.add(thirtySix);
		origShoe.add(thirtySeven);
		origShoe.add(thirtyEight);
		origShoe.add(thirtyNine);
		origShoe.add(fourty);
		origShoe.add(fourtyOne);
		origShoe.add(fourtyTwo);
		origShoe.add(fourtyThree);
		origShoe.add(fourtyFour);
		origShoe.add(fourtyFive);
		origShoe.add(fourtySix);
		origShoe.add(fourtySeven);
		origShoe.add(fourtyEight);
		origShoe.add(fourtyNine);
		origShoe.add(fifty);
		origShoe.add(fiftyOne);
		origShoe.add(fiftyTwo);

		//change cardCount to match number of decks

	}


	public void shuffleCards()
	{
		//shuffle card logic

	}

	public Card dealCard()
	{
		//deal card logic
		rCard = rn.nextInt(cardCount) + 1;
		dealtShoe.add(origShoe.get(rCard));

		//adds the card value to total hand value
		if(canSplit())
		{
			handValue1 = handValue1 / 2;
			if(checkHand % 2 != 0)
				handValue1 += ((Card) origShoe.get(rCard)).getValue();
			else
				handValue2 += ((Card) origShoe.get(rCard)).getValue();
		}
		else
		{
			handValue1 += ((Card) origShoe.get(rCard)).getValue();
		}
		cardCount--;


		return (Card) origShoe.get(rCard);
	}

	public void dealDealerCard()
	{
		//display card in dealers spot
		//
		dealCard();
	}

	public void dealPlayerCard()
	{
		//display card in players spot
		//
		dealCard();
	}

	public void removeCard()
	{
		origShoe.remove(rCard);
	}


	public int getHandValue1()
	{
			return handValue1;
	}

	public int getHandValue2()
	{
			return handValue2;
	}


	public boolean canSplit()
	{
		if(((Card) dealtShoe.get(0)).getValue() == ((Card) dealtShoe.get(0)).getValue())
			return true;
		else
			return false;
	}

}
