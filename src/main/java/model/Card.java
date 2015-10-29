package model;

/**
 * Created by El Capitán on 28.09.2015.
 */
public class Card {

    public enum Rank {
        // Lukas: I reordered this enum 'cause Ace is the Highest Rank
        Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace
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
     * This indicates if this card is in the stack or not
     */
    private boolean inStack;

    /**
     * Generates a card with its rank.
     * @param rank defines which card this is.
     */
    public Card(Rank rank, Suite suite){
        this.rank = rank;
        this.suite = suite;
        this.inStack = true;
    }
    
    /**
     * This is used to indicate that a card just left the stack and wandered into 
     * a player's hand or the community cardss
     */
    public void removeFromStack(){
    	this.inStack = false;		
    }

    public boolean isInStack(){
        return this.inStack;
    }
	@Override
	public String toString() {
		return rank.name() +" "+suite.name();
	}
    
    

}
