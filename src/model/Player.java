package model;

/**
 * Created by El Capit�n on 29.09.2015.
 */
public class Player {
    public Card[] getHand() {
        return hand;
    }

    public void setHand() {
        this.hand = hand;
    }

    private Card[] hand;
    public Player(int sizeOfHand){
        hand = new Card[sizeOfHand];
    }
}
