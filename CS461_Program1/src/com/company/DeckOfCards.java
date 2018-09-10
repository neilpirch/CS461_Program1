/*
SOME OF THE CODE IN THIS CLASS IS FROM http://www.mathcs.emory.edu/~cs17000,
BY Shun Y. Cheung (cheung@mathcs.emory.edu), HOSTED ONLINE AT http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/10/
*/

package com.company;

public class DeckOfCards {
    public static final int NCARDS = 52;

    private Card[] deckOfCards;         // Contains all 52 cards
    private int currentCard;            // deal THIS card in deck

    public DeckOfCards( )
    {
        deckOfCards = new Card[ NCARDS ];

        int i = 0;

        for ( int suit = Card.DIAMOND; suit <= Card.SPADE; suit++ )
            for ( int rank = 1; rank <= 13; rank++ )
                deckOfCards[i++] = new Card(suit, rank);

        currentCard = 0;
    }

    /* ---------------------------------
       shuffle(n): shuffle the deck
       --------------------------------- */
    public void shuffle(int n)
    {
        int i, j, k;

        for ( k = 0; k < n; k++ )
        {
            i = (int) ( NCARDS * Math.random() );  // Pick 2 random cards
            j = (int) ( NCARDS * Math.random() );  // in the deck

	  /* ---------------------------------
	     swap these randomly picked cards
	     --------------------------------- */
            Card tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;
        }

        currentCard = 0;   // Reset current card to deal
    }

    /* -------------------------------------------
       deal(): deal deckOfCards[currentCard] out
       ------------------------------------------- */
    public Card deal()
    {
        if ( currentCard < NCARDS )
        {
            return ( deckOfCards[ currentCard++ ] );
        }
        else
        {
            System.out.println("Out of cards error");
            return ( null );  // Error;
        }
    }
    public void simShuffle(int n)
    {
        int i, j, k;

        for ( k = 0; k < n; k++ )
        {
            i = (int) ( NCARDS * Math.random() );  // Pick 2 random cards
            j = (int) ( NCARDS * Math.random() );  // in the deck

	  /* ---------------------------------
	     swap these randomly picked cards
	     --------------------------------- */
	        if (i>6 && j>6) {
                Card tmp = deckOfCards[i];
                deckOfCards[i] = deckOfCards[j];
                deckOfCards[j] = tmp;
            }
        }

        currentCard = 0;   // Reset current card to deal
    }
    public Card simDeal(int simCard)
    {
        if ( simCard < NCARDS )
        {
            return ( deckOfCards[ simCard++ ] );
        }
        else
        {
            System.out.println("Out of cards error");
            return ( null );  // Error;
        }
    }

    public String toString()
    {
        String s = "";
        int k;

        k = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 1; j <= 13; j++ )
                s += (deckOfCards[k++] + " ");

            s += "\n";
        }
        return ( s );
    }

}
