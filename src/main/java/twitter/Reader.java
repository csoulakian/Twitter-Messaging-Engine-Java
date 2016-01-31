package twitter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 1/29/2016
 *
 * Reads in user input using scanner and adds each word to a list. Press Ctrl+D when finished
 * typing message in IntelliJ when running.
 *
 * ??? 2 constructors, 1 reads in from console and other reads in
 *      text file??
 */

public class Reader {

    /**
     * The list of "sub-strings" of the message separated into words.
     */
    ArrayList<String> list = new ArrayList<String>();


    /**
     * Creates a new reader that scans input from the console and
     * separates the message into individual words/items.
     */
    public Reader() {
        System.out.println("Enter the tweet to be analyzed:");
        Scanner scanner = new Scanner(System.in);
        stringSplitter(scanner);
        scanner.close();
    }

    /**
     * Takes individual words that are scanned in and adds them to an ArrayList.
     * @param scan Scanner object using the console for input
     * @return ArrayList of individual words from the message
     */
    private ArrayList<String> stringSplitter(Scanner scan) {
        while(scan.hasNext()) {
            list.add(scan.next());
        }
        return list;
    }

}
