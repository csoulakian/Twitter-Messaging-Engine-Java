package twitter;
import java.util.Scanner;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 1/29/2016
 *
 * Reads in user input using scanner and adds the message to a string. If the string is
 * less than the max of 140 characters, it is then split into words in an array.
 * Press Ctrl+D when finished typing message in IntelliJ when running.
 *
 * ??? 2 constructors, 1 reads in from console and other reads in
 *      text file??
 */

public class Reader {

    /**
     * The original tweet.
     */
    public String message = "";
    /**
     * The array of "sub-strings" of the message separated into words. Initialized to an
     * empty array so a message that's too long will still have an empty list.
     */
    public String[] list = {};
    /**
     * The maximum length of a twitter message.
     */
    private static final int MAX_LENGTH = 140;


    /**
     * Creates a new reader that scans input from the console and
     * adds it to a single string (message). If tweet is within required max characters, it is sent
     * to the stringSplitter.
     * TODO pull major functionality out of constructor to allow for better testing, create msg setter?
     */
    public Reader() {

        System.out.println("Enter the tweet to be analyzed:");
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            message += scanner.nextLine();
        }

        scanner.close();

        //splits message string if message is not empty and <= max length
        if (checkLength(message)) {
            if (message.length() > 0) {
                stringSplitter(message);
            } else System.out.println("Your message is empty!");
        } else System.out.println("Your message is too long! The maximum number of characters is 140!");

    }

    /**
     * Ensures that the message is less than or equal to the maximum of 140 characters.
     * @param message Full original tweet.
     * @return true if message meets character requirements, otherwise false.
     */
    private boolean checkLength(String message) {
        return message.length() <= MAX_LENGTH;
    }

    /**
     * Takes a message in the form of a string and creates an array of the individual words.
     * @param message Full original tweet.
     * @return String array of individual words from the message.
     */
    private String[] stringSplitter(String message) {
        list = message.split(" ");
        return list;
    }


}
