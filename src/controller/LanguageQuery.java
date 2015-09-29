package controller;

import view.ConsoleAccess;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class LanguageQuery {
    Locale[] supportedConsoleAccessLocales = {
            Locale.ENGLISH,
            Locale.GERMAN
    };
    ConsoleAccess ca;

    public LanguageQuery(ConsoleAccess ca){
        this.ca = ca;
    }

    /**
     * Retrieves the ResourceBundle for ConsoleAccess.
     * @return The ResourceBundle for the language of the console.
     */
    public ResourceBundle getConsoleAccessLocale(){
        for (int i = 0; i < supportedConsoleAccessLocales.length; i ++) {
            System.out.println(i+":"+supportedConsoleAccessLocales[i]);
        }
        int locale = ca.getInt();
        ResourceBundle languageBundle = ResourceBundle.getBundle("ConsoleAccessBundle", supportedConsoleAccessLocales[locale]);
        return languageBundle;
    }
}
