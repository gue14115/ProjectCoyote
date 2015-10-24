package model;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Lukas on 24.10.2015.
 * This general purpose of this class to identify the value of a load of cards
 */
public class Hand {

    /**
     *
     */
    public enum Hands{
        High_Card, One_Pair, Two_Pair, Three_Of_A_Kind, Straight, Flush,
        Full_House, Four_Of_A_Kind, Straight_Flush, Royal_Flush
    }

    ArrayList<Card> cards;
    Multimap<Card.Suite, Card> cardsSortedBySuite;

    public Hand(Card[] playerCard, Card[] communityCards){
        ArrayList<Card> cards;
        cards = new ArrayList<Card>();
        for(Card c: playerCard){
            if(c != null){
                cards.add(c);
            }
        }
        for(Card c: communityCards){
            if(c != null){
                cards.add(c);
            }
        }
        //Sorts the Array by Rank
        cards.sort(new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return  o2.getRank().ordinal() - o1.getRank().ordinal();
            }
        });
        //Groups the Cards By Suite
        cardsSortedBySuite = ArrayListMultimap.create();
        for(Card c: cards){
            cardsSortedBySuite.put(c.getSuite(), c);
        }
    }

    public Hands getHand(){
        if(isRoyalFlush())
            return Hands.Royal_Flush;
        if(isStraightFlush())
            return Hands.Straight_Flush;
        if(isFour())
            return Hands.Four_Of_A_Kind;
        if(isFullHouse())
            return Hands.Full_House;
        if(isFlush())
            return Hands.Flush;
        if(isStraight())
            return Hands.Straight;
        if(isThree())
            return Hands.Three_Of_A_Kind;
        if(isTwoPair())
            return Hands.Two_Pair;
        if(isOnePair())
            return Hands.One_Pair;
        return Hands.High_Card;
    }

    public boolean isRoyalFlush(){
        Card[] suiteCards = null;
        for(Card.Suite s1: Card.Suite.values()){
            if(cardsSortedBySuite.get(s1).size() >= 5){
                suiteCards = cardsSortedBySuite.get(s1).toArray(new Card[cardsSortedBySuite.get(s1).size()]);
                break;
            }
        }
        if(suiteCards == null){
            return false;
        }
        return suiteCards[0].getRank() == Card.Rank.Ace && suiteCards[1].getRank() == Card.Rank.King && suiteCards[2].getRank() == Card.Rank.Queen&& suiteCards[3].getRank() == Card.Rank.Jack && suiteCards[4].getRank() == Card.Rank.Ten;
    }

    public boolean isStraightFlush(){
        throw new NotImplementedException();
    }

    public boolean isFour(){
        throw new NotImplementedException();
    }

    public boolean isFullHouse(){
        throw new NotImplementedException();
    }

    public boolean isFlush(){
        throw new NotImplementedException();
    }

    public boolean isStraight(){
        throw new NotImplementedException();
    }

    public boolean isThree(){
        throw new NotImplementedException();
    }

    public boolean isTwoPair(){
        throw new NotImplementedException();
    }

    public boolean isOnePair(){
        throw new NotImplementedException();
    }

}
