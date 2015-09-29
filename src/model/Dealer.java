package model;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Dealer {
    public Suite[] set;

    /**
     * Generates a set of all suites with their symbols.
     */
    public Dealer(){
        set = new Suite[Suite.Symbol.values().length];
        for(int symbolCounter=0;symbolCounter<Suite.Symbol.values().length;symbolCounter++){
            set[symbolCounter] = new Suite(Suite.Symbol.values()[symbolCounter]);
        }
    }
}
