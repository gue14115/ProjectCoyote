package model;

/**
 * Created by El Capitán on 28.09.2015.
 */
public class Card {
    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }
    public enum Suite{
        Clubs, Diamonds, Hearts, Spades
    }

    public Rank getRank() {
        return rank;
    }
    public Suite getSuite() {
        return suite;
    }
    private final Suite suite;
    private final Rank rank;

    /**
     * Generates a card with its rank.
     * @param rank defines which card this is.
     */
    public Card(Rank rank, Suite suite){
        this.rank = rank;
        this.suite = suite;
    }
}
