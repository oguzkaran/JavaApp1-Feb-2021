package org.csystem.games.cardgames;

public class Card
{
   private CardValue m_value;
   private CardType m_type;			
   //...
	
   public Card(CardValue value, CardType type)
   {
      m_value = value;
      m_type = type;
   }

   //...

   public CardValue getValue()
   {
      return m_value;
   }

   public CardType getType()
   {
      return m_type;
   }

   public static Card[] getShuffledDeck()
   {
       Card[] deck = new Card[52];

       int index = 0;

       for (CardType cardType : CardType.values())
          for (CardValue cardValue : CardValue.values())
             deck[index++] = new Card(cardValue, cardType);

      //...
      return deck;
   }
	
   //…
}
