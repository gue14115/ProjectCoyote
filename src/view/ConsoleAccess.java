package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class ConsoleAccess {

    /**
     * This method returns a line from the console.
     * @return  the line that the user typed into the console.
     */
    public String getString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.print("Sorry, I was unable to read that :(. Try again!");
            return getString();
        }
        return line;
    }

    /**
     * Used to get an int from the console.
     * @return the number that the user typed into the console.
     */
    public int getInt(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = 0;

        try {
            line = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe){
            System.out.print("Hey! That hurt! Try a number ><!");
            return getInt();
        } catch (IOException e) {
            System.out.print("Sorry, I was unable to read that :(. Try again!");
            return getInt();
        }


        return line;
    }

}
