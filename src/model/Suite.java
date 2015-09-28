package model;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Suite {
    public enum Symbol{
        Clubs, Diamonds, Hearts, Spades
    }

    public Symbol getSymbol() {
        return symbol;
    }
    public Card[] getCards() {
        return cards;
    }

    private final Symbol symbol;
    private Card[]cards = new Card[13];

    /**
     * Generates an array of cards.
     * @param symbol defines which suite this is.
     */
    public Suite(Symbol symbol){
        this.symbol = symbol;
        for(int rankCounter=0; rankCounter<Card.Rank.values().length;rankCounter++){
            cards[rankCounter] = new Card(Card.Rank.values()[rankCounter]);
        }
    }
}
