package model;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Set {
    public Suite[] suites;

    /**
     * Generates a set of all suites with their symbols.
     */
    public Set(){
        suites = new Suite[Suite.Symbol.values().length];
        for(int symbolCounter=0;symbolCounter<Suite.Symbol.values().length;symbolCounter++){
            suites[symbolCounter] = new Suite(Suite.Symbol.values()[symbolCounter]);
        }
    }
}
