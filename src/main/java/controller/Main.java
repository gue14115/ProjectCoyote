package controller;


import model.Card;
import model.Dealer;
import model.Player;
import view.ConsoleAccess;

import java.util.ResourceBundle;
import java.util.StringTokenizer;

/**
 * Created by El Capitán on 28.09.2015.
 */
public class Main {
    static Dealer dealer;
    static Player self;
    static ConsoleAccess ca;
    static int amountOfPlayers;
    static int position;
    static LanguageQuery langQ;

    public static void main(String [ ] args)
    {
        ca = new ConsoleAccess();
        langQ = new LanguageQuery(ca);
        setUpTexas();
    }

    /**
     * Sets up the game for Texas hold'em
     */
    public static void setUpTexas(){
        ResourceBundle consoleAccessBundle = langQ.getConsoleAccessLocale();


        dealer = new Dealer();
        Player self = new Player(2);
        System.out.println(consoleAccessBundle.getString("opponentQuery"));
        int numberOfOpponents = ca.getInt();
        amountOfPlayers = numberOfOpponents+1; //+1 for yourself
        System.out.println(consoleAccessBundle.getString("positionQuery"));
        position = ca.getInt();
        System.out.println(consoleAccessBundle.getString("card1Player"));
        Card firstCard = findCard(ca.getString());
        System.out.println(consoleAccessBundle.getString("card2Player"));
        Card secondCard = findCard(ca.getString());
        /**
        for(int i = 0; i<52;i++){
                System.out.println(dealer.set[i].getRank()+" "+dealer.set[i].getSuite());
        }
**/
        /**
        System.out.println(consoleAccessBundle.getString("card1Query"));
        findCard(ca.getString());
        System.out.println(consoleAccessBundle.getString("card2Query"));
        findCard(ca.getString());
         */
    }

    public static Card findCard(String cardString){
        StringTokenizer st = new StringTokenizer(cardString);
        String rank = st.nextToken();
        String suite = st.nextToken();
        Card foundCard = dealer.findCard(rank,suite);
        if(foundCard!=null){
            return foundCard;
        }
        else{
            /**@TODO Tell user that input was in wrong format or that card was not in set.*/
            return null;
        }
    }
}
