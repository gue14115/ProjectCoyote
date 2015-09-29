package controller;

import model.Suite;
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
     * Retrieves the default language ResourceBundle for ConsoleAccess.
     * @return The ResourceBundle for the language of the console.
     */
    public ResourceBundle getConsoleAccessLocale(){
        ResourceBundle languageBundle = ResourceBundle.getBundle("ConsoleAccessBundle", Locale.getDefault());
        return languageBundle;
    }
}
