package test;

import org.junit.Test;

import model.Card;
import model.Card.Rank;
import model.Card.Suite;
import model.Dealer;

public class AdvancedUtilityTest {
	
	@Test
	public void chanceForAFour(){
		Dealer d = new Dealer();
		Card[] player = new Card[2];
		//Player 1 First Card
		d.drawUnknown();
		//Player 2 First Card
		d.drawUnknown();
		//My First Card
		player[0] = d.draw(Rank.Ace, Suite.Diamonds);
		//Player 1 Second Card
		d.drawUnknown();
		//Player 2 Second Card
		d.drawUnknown();
		player[1] = d.draw(Rank.Three, Suite.Hearts);
		
		//Betting...
		//Community cards
		Card[] com = new Card[3];
		com[0] = d.draw(Rank.Ace, Suite.Hearts);
		com[1] = d.draw(Rank.Jack, Suite.Diamonds);
		com[2] = d.draw(Rank.Ace, Suite.Spades);
		
		float perc = 0;
		perc += d.getPercentageOf(Rank.Ace);
		d.drawUnknown();
		perc += d.getPercentageOf(Rank.Ace);
		System.out.println(perc);
	}

}
