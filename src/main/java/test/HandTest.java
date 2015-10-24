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
}
