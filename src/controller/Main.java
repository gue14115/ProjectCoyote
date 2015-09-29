package controller;


import model.Dealer;
import model.Player;
import view.ConsoleAccess;

/**
 * Created by El Capitán on 28.09.2015.
 */
public class Main {
    static Dealer dealer;
    static Player self;
    static ConsoleAccess ca;
    public static void main(String [ ] args)
    {
        ca = new ConsoleAccess();
        setUpTexas();
    }

    /**
     * Sets up the game for Texas hold'em
     */
    public static void setUpTexas(){
        Dealer dealer = new Dealer();
        Player self = new Player(2);
        System.out.println("How many opponents are there?");
        int numberOfOpponents = ca.getInt();
        //@TODO continue here
    }
}
