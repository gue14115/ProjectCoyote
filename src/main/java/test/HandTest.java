package test;

import junit.framework.Assert;
import model.Card;
import model.Dealer;
import model.Hand;
import org.junit.Test;

/**
 * Created by Lukas on 24.10.2015.
 */
public class HandTest {

    @Test
    public void testRoyalFlush(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{d.draw(Card.Rank.Ace, Card.Suite.Clubs), d.draw(Card.Rank.Jack, Card.Suite.Clubs)};
        Card[] community = new Card[]{d.draw(Card.Rank.King, Card.Suite.Clubs), d.draw(Card.Rank.King, Card.Suite.Hearts), d.draw(Card.Rank.Queen, Card.Suite.Clubs), d.draw(Card.Rank.Seven, Card.Suite.Diamonds), d.draw(Card.Rank.Ten, Card.Suite.Clubs)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Royal_Flush);
    }

    @Test
    public void testStraightFlush(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{
                d.draw(Card.Rank.Four, Card.Suite.Clubs),
                d.draw(Card.Rank.Five, Card.Suite.Clubs)};
        Card[] community = new Card[]{
                d.draw(Card.Rank.Six, Card.Suite.Clubs),
                d.draw(Card.Rank.King, Card.Suite.Clubs),
                d.draw(Card.Rank.Seven, Card.Suite.Clubs),
                d.draw(Card.Rank.Seven, Card.Suite.Diamonds),
                d.draw(Card.Rank.Eight, Card.Suite.Clubs)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Straight_Flush);
    }

    @Test
    public void testFour(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{
                d.draw(Card.Rank.Five, Card.Suite.Clubs),
                d.draw(Card.Rank.Five, Card.Suite.Diamonds)};
        Card[] community = new Card[]{
                d.draw(Card.Rank.Six, Card.Suite.Clubs),
                d.draw(Card.Rank.Five, Card.Suite.Hearts),
                d.draw(Card.Rank.Seven, Card.Suite.Clubs),
                d.draw(Card.Rank.Seven, Card.Suite.Diamonds),
                d.draw(Card.Rank.Five, Card.Suite.Spades)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Four_Of_A_Kind);
    }

    @Test
    public void testFullHouse(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{
                d.draw(Card.Rank.Five, Card.Suite.Clubs),
                d.draw(Card.Rank.Five, Card.Suite.Diamonds)};
        Card[] community = new Card[]{
                d.draw(Card.Rank.Seven, Card.Suite.Spades),
                d.draw(Card.Rank.Five, Card.Suite.Hearts),
                d.draw(Card.Rank.Seven, Card.Suite.Clubs),
                d.draw(Card.Rank.Seven, Card.Suite.Diamonds),
                d.draw(Card.Rank.Ten, Card.Suite.Spades)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Full_House);
    }

    @Test
    public void testFlush(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{
                d.draw(Card.Rank.Five, Card.Suite.Clubs),
                d.draw(Card.Rank.King, Card.Suite.Diamonds)};
        Card[] community = new Card[]{
                d.draw(Card.Rank.Jack, Card.Suite.Spades),
                d.draw(Card.Rank.Five, Card.Suite.Diamonds),
                d.draw(Card.Rank.Seven, Card.Suite.Diamonds),
                d.draw(Card.Rank.Two, Card.Suite.Diamonds),
                d.draw(Card.Rank.Ten, Card.Suite.Diamonds)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Straight);
    }

    @Test
    public void testStraight(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{
                d.draw(Card.Rank.Five, Card.Suite.Clubs),
                d.draw(Card.Rank.Six, Card.Suite.Diamonds)};
        Card[] community = new Card[]{
                d.draw(Card.Rank.Seven, Card.Suite.Spades),
                d.draw(Card.Rank.Eight, Card.Suite.Diamonds),
                d.draw(Card.Rank.Nine, Card.Suite.Diamonds),
                d.draw(Card.Rank.Two, Card.Suite.Diamonds),
                d.draw(Card.Rank.Ten, Card.Suite.Diamonds)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Straight);
    }

    @Test
    public void testTwoPair(){
        Dealer d = new Dealer();
        Card[] player = new Card[]{
                d.draw(Card.Rank.Five, Card.Suite.Clubs),
                d.draw(Card.Rank.Five, Card.Suite.Diamonds)};
        Card[] community = new Card[]{
                d.draw(Card.Rank.Seven, Card.Suite.Spades),
                d.draw(Card.Rank.Seven, Card.Suite.Hearts),
                d.draw(Card.Rank.Nine, Card.Suite.Diamonds),
                d.draw(Card.Rank.Two, Card.Suite.Hearts),
                d.draw(Card.Rank.Ten, Card.Suite.Diamonds)};
        Assert.assertEquals(new Hand(player, community).getHand(), Hand.Hands.Two_Pair);
    }
}
