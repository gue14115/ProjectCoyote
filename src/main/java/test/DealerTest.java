package test;

import model.Card;
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
        Card c = dealer.findCard("Nine", "Hearts");
        Assert.assertEquals(c.getRank(), Card.Rank.Nine);
        Assert.assertEquals(c.getSuite(), Card.Suite.Hearts);
    }
}
