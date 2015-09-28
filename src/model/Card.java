package model;

/**
 * Created by El Capitán on 28.09.2015.
 */
public class Card {
    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }
    public enum Suite {
        Clubs, Diamonds, Hearts, Spades
    }

    public Suite getSuite() {
        return suite;
    }

    public Rank getRank() {
        return rank;
    }

    private final Rank rank;
    private final Suite suite;

    public Card(Rank rank, Suite suite){
        this.rank = rank;
        this.suite = suite;
    }
}
