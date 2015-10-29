package test;

import model.Card;
import model.Card.Rank;
import model.Card.Suite;
import model.Dealer;
import model.Hand;

import org.junit.Assert;
import org.junit.Test;

public class RankingTest {
	
	@Test
	public void testRoyalFlushVSStraightFlush(){
		Dealer d = new Dealer();
		Card[] comCards = new Card[]{
				d.draw(Rank.Queen, Suite.Clubs), 
				d.draw(Rank.Ten, Suite.Clubs),
				d.draw(Rank.Jack, Suite.Clubs),
				d.draw(Rank.Four, Suite.Diamonds),
				d.draw(Rank.Ace, Suite.Spades)};
		Card[] player1 = new Card[]{
				d.draw(Rank.King, Suite.Clubs), 
				d.draw(Rank.Ace, Suite.Clubs)};
		Card[] player2 = new Card[]{
				d.draw(Rank.Nine, Suite.Clubs), 
				d.draw(Rank.Eight, Suite.Clubs)};
		Hand hand1 = new Hand(player1, comCards);
		Hand hand2 = new Hand(player2, comCards);
		Assert.assertTrue(hand1.compareTo(hand2) > 0);
	}
	
	@Test
	public void theSamePair(){
		Dealer d = new Dealer();
		Card[] comCards = new Card[]{
				d.draw(Rank.Queen, Suite.Clubs), 
				d.draw(Rank.Eight, Suite.Clubs),
				d.draw(Rank.Jack, Suite.Hearts),
				d.draw(Rank.Four, Suite.Diamonds),
				d.draw(Rank.Ace, Suite.Spades)};
		Card[] player1 = new Card[]{
				d.draw(Rank.Queen, Suite.Diamonds), 
				d.draw(Rank.Four, Suite.Clubs)};
		Card[] player2 = new Card[]{
				d.draw(Rank.Ace, Suite.Clubs), 
				d.draw(Rank.Four, Suite.Spades)};
		Hand hand1 = new Hand(player1, comCards);
		Hand hand2 = new Hand(player2, comCards);
		Assert.assertTrue(hand1.compareTo(hand2) < 0);
	}

}
