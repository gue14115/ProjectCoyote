package controller;


import model.Dealer;
import model.Player;
import view.ConsoleAccess;

import java.util.Locale;
import java.util.ResourceBundle;

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
        ResourceBundle consoleBundle = langQ.getConsoleAccessLocale();


        Dealer dealer = new Dealer();
        Player self = new Player(2);
        System.out.println(consoleBundle.getString("opponentQuery"));
        int numberOfOpponents = ca.getInt();
        amountOfPlayers = numberOfOpponents+1; //+1 for yourself
        System.out.println(consoleBundle.getString("positionQuery"));
        position = ca.getInt();

    }
}
