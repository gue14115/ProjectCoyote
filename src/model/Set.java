package model;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Set {
    public Card[]cards = new Card[52];

    /**
     * Generates a set of all cards.
     * @TODO Possibly rewrite this?
     */
    public Set(){
        for(int suiteCounter=0;suiteCounter<Card.Suite.values().length;suiteCounter++){
            for(int rankCounter=0; rankCounter<Card.Rank.values().length;rankCounter++){
                cards[suiteCounter*Card.Rank.values().length+rankCounter] = new Card(Card.Rank.values()[rankCounter],Card.Suite.values()[suiteCounter]);
            }
        }
    }
}
