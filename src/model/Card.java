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

    final Rank rank;
    final Suite suite;

    public Card(Rank rank, Suite suite){
        this.rank = rank;
        this.suite = suite;
    }
}
