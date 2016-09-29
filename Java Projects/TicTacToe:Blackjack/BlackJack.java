public class BlackJack
{


  public BlackJack()
  {
    Shoe shoe = new Shoe();

    //handle multiple decks and GUI


    //deals two random cards from the shoe
    shoe.dealPlayerCard();
    shoe.dealPlayerCard();


    shoe.dealDealerCard();
    shoe.dealDealerCard();
    //if statement that decides if card is face down or up


    if(shoe.canSplit())
    {
      //give player the option to hit, stand, or split
      //if hit or split, implement rest of hand loop in ActionListener
    }
    else
    {
      //give player the option to hit or stand
      //if hit, implement rest of hand loop in ActionListener
    }




  }

  public int getHandValue()
  {
    return shoe.handValue();
  }

}
