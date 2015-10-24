package model;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
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
    Multimap<Card.Rank, Card> cardsSortedByRank;

    public Hand(Card[] playerCard, Card[] communityCards){
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
        //Groups the Cards By Rank
        cardsSortedByRank = ArrayListMultimap.create();
        for(Card c: cards){
            cardsSortedByRank.put(c.getRank(), c);
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
        int padding = 0;
        while(suiteCards.length - padding >= 5){
            int i = suiteCards[padding].getRank().ordinal();
            boolean b = suiteCards[padding+1].getRank().ordinal() == i-1
                    && suiteCards[padding+2].getRank().ordinal() == i-2
                    && suiteCards[padding+3].getRank().ordinal() == i-3
                    && suiteCards[padding+4].getRank().ordinal() == i-4;
            if(b)
                return b;
            padding++;
        }
        return false;
    }

    public boolean isFour(){
        for(Card.Rank k:cardsSortedByRank.keys()){
            if(cardsSortedByRank.get(k).size() == 4){
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse(){
        boolean two = false;
        boolean three = false;
        for(Card.Rank k:cardsSortedByRank.keys()){
            if(cardsSortedByRank.get(k).size() >= 2){
                if(cardsSortedByRank.get(k).size() >= 3 && !three){
                    three = true;
                }else{
                    two = true;
                }
            }
        }
        return two && three;
    }

    public boolean isFlush(){
        for(Card.Suite s1: Card.Suite.values()){
            if(cardsSortedBySuite.get(s1).size() >= 5)
                return true;
        }
        return false;
    }

    public boolean isStraight(){
        int padding = 0;
        Card.Rank[] ranks = cardsSortedByRank.keys().toArray(new Card.Rank[cardsSortedByRank.keys().size()]);
        while(ranks.length - padding >= 5){
            int i = ranks[padding].ordinal();
            boolean b = ranks[padding+1].ordinal() == i-1
                    && ranks[padding+2].ordinal() == i-2
                    && ranks[padding+3].ordinal() == i-3
                    && ranks[padding+4].ordinal() == i-4;
            if(b)
                return b;
            padding++;
        }
        return false;
    }

    public boolean isThree(){
        for(Card.Rank k:cardsSortedByRank.keys()){
            if(cardsSortedByRank.get(k).size() >= 3){
                return true;
            }
        }
        return false;
    }

    public boolean isTwoPair(){
        boolean two = false;
        boolean three = false;
        for(Card.Rank k:cardsSortedByRank.keys()){
            if(cardsSortedByRank.get(k).size() >= 2){
                if(!three){
                    three = true;
                }else{
                    two = true;
                }
            }
        }
        return two && three;
    }

    public boolean isOnePair(){
        for(Card.Rank k:cardsSortedByRank.keys()){
            if(cardsSortedByRank.get(k).size() >= 2){
                return true;
            }
        }
        return false;
    }

}
