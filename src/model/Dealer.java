package model;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Dealer {
    public Card[] set;

    /**
     * Generates a set of all suites with their symbols.
     */
    public Dealer(){

        set = new Card[Card.Suite.values().length*Card.Rank.values().length];

        for(int suiteCounter=0;suiteCounter<Card.Suite.values().length;suiteCounter++){
            for(int rankCounter=0; rankCounter<Card.Rank.values().length;rankCounter++){
                set[suiteCounter*Card.Rank.values().length+rankCounter] = new Card(Card.Rank.values()[rankCounter],Card.Suite.values()[suiteCounter]);
            }
        }
    }


}
