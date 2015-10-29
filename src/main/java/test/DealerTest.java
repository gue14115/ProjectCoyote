package test;

import model.Card;
import model.Card.Rank;
import model.Card.Suite;
import model.Dealer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukas on 24.10.2015.
 */
public class DealerTest{


    @Test
    public void testFindCard(){
        Dealer dealer = new Dealer();
        Card c = dealer.findCard(Card.Rank.Nine, Card.Suite.Hearts);
        Assert.assertEquals(c.getRank(), Card.Rank.Nine);
        Assert.assertEquals(c.getSuite(), Card.Suite.Hearts);
    }
    
    @Test
    public void testPercentage(){
    	Dealer dealer = new Dealer();
    	Card c1 = dealer.draw(Rank.Ace, Suite.Clubs);
    	Card c2 = dealer.draw(Rank.Ace, Suite.Diamonds);
    	Assert.assertEquals(dealer.getPercentageOf(c1), 0, 0);
    	Assert.assertEquals(dealer.getPercentageOf(c2), 0, 0);
    	Assert.assertEquals(dealer.getPercentageOf(dealer.findCard(Rank.Five, Suite.Clubs)), (float)1/50, 0);
    	dealer.drawUnknown();
    	Assert.assertEquals(dealer.getPercentageOf(dealer.findCard(Rank.Five, Suite.Clubs)), (float)((float)1/49)*((float)49/50), 0);
    	dealer.drawUnknown();
    	dealer.drawUnknown();
    	dealer.drawUnknown();
    	float percentage = 1;
    	Assert.assertEquals(dealer.getPercentageOf(Rank.Ace), (float)1/25, 0);
    	dealer.draw(Rank.Eight, Suite.Hearts);
    	Assert.assertEquals(dealer.getPercentageOf(Rank.Ace), (float)46/1125, 0.0000001);
    }
}
