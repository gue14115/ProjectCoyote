package view;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by El Capitán on 29.09.2015.
 */
public class Console {

    /**
     * This method returns a line from the console.
     * @return  the line that the user typed into the console.
     * @throws IOException
     */
    public String getConsoleLine() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        String line = br.readLine();
        return line;
    }

}
