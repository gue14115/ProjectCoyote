package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Dealer {
    public Card[] set;
    public Card[] communityCards;

    /**
     * Generates a set of all suites with their symbols.
     */
    public Dealer(){
    	communityCards = new Card[5];
        set = new Card[Card.Suite.values().length*Card.Rank.values().length];

        for(int suiteCounter=0;suiteCounter<Card.Suite.values().length;suiteCounter++){
            for(int rankCounter=0; rankCounter<Card.Rank.values().length;rankCounter++){
                set[suiteCounter*Card.Rank.values().length+rankCounter] = new Card(Card.Rank.values()[rankCounter],Card.Suite.values()[suiteCounter]);
            }
        }
    }

    public Card findCard(String rank, String suite){
    	return findCard(Card.Rank.valueOf(rank), Card.Suite.valueOf(suite));
    }

    public Card findCard(Card.Rank rank, Card.Suite suite){
    	/* This doesn't need multiple loops because the position of the card
    	   in the set array always depends on the rank plus the suite
    	   ergo the  position can be calculated rather than searched */
        return set[suite.ordinal()*Card.Rank.values().length+rank.ordinal()];
    }

    public Card findCardInDeck(Card.Rank rank, Card.Suite suite){
        Card c = findCard(rank, suite);
        if(c.isInStack()){
            return c;
        }
        return null;
    }

    public Card[] getStack(){
        ArrayList<Card> stack = new ArrayList<Card>();
        for(Card c: set){
            if(c.isInStack()){
                stack.add(c);
            }
        }
        return stack.toArray(new Card[stack.size()]);
    }
    
   /**
    * Removes the specific card from the stack and returns it
    */
    public Card draw(Card.Rank rank, Card.Suite suite){
    	Card c = this.findCardInDeck(rank, suite);
        if(c!=null) {
            c.removeFromStack();
        }
    	return c;
    }


}
