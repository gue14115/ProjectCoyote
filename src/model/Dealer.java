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

    public Card findCard(String rank, String suite){
        int suiteCounter=0;
        for(Card.Suite s : Card.Suite.values()){
            if(suite.equals(s.toString())){
                int rankCounter=0;
                for(Card.Rank r : Card.Rank.values()){
                    if(rank.equals(r.toString())){
                        return set[suiteCounter*Card.Rank.values().length+rankCounter];
                    }
                    rankCounter++;
                }
            }
            suiteCounter++;
        }
        return null;
    }


}
