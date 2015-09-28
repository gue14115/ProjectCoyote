package model;

/**
 * Created by El Capitán on 28.09.2015.
 */
public class Card {
    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    public Rank getRank() {
        return rank;
    }

    private final Rank rank;

    /**
     * Generates a card with its rank.
     * @param rank defines which card this is.
     */
    public Card(Rank rank){
        this.rank = rank;
    }
}
