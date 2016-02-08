package twitter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 1/29/2016
 *
 *
 * Checks for @ or # at beginning of string, adds the rest of that string to a HashMap.
 * HashMap will contain mentions, topics, and URLs.
 *
 * Parses a list of strings that represent each "word" in the original message.
 * HashMap will have the string keys mentions, topics, and URLs and values will be ArrayLists
 * of strings. Go through input list and depending on what it starts with, add it to correct
 * ArrayList, then (outside of loop) put the 3 keys and all their values in parsedMap.
 */

public class Parser {

    /**
     * An ArrayList containing all the users that were mentioned in the tweet.
     * TODO Make private after testing in Main.
     */
    ArrayList<String> mentionsList = new ArrayList<>();

    /**
     * An ArrayList containing all the topics that were tagged in the tweet.
     * TODO Make private after testing in Main.
     */
    ArrayList<String> topicsList = new ArrayList<>();

    /**
     * An ArrayList containing all the urls that were linked in the tweet.
     * TODO Make private after testing in Main.
     */
    ArrayList<String> urlsList = new ArrayList<>();

    /**
     * A parsedMap containing 3 keys: mentions, topics, and URLs where each key
     * is mapped to an ArrayList containing the items found in the tweet.
     */
    public HashMap<String, ArrayList<String>> parsedMap = new HashMap<>();


    /**
     * Creates a new parser that checks if each word is a mention, topic, or URL
     * (or none of those) and sorts them into a HashMap by its type and ignoring regular text.
     * @param list of words from the message in a string array
     */
    public Parser(String[] list) {

        if (list.length > 0) {
            for (String word : list) {
                sorter(word);
            }
        } else {
            parsedMap.clear();
        }

    }

    /**
     * Sorts a word by first catching @ symbol at beginning followed by at least
     * one character, then catches the # symbol at beginning followed by at least one
     * character, and finally checks if the word begins with "www" or "http."
     * TODO Take into account other types of URLs based on end pattern
     * TODO remove 1st character (@/#) if it's a mention or topic?
     * TODO remove special characters like .?! from end of mention
     * @param word A "sub-string" of the original message that was either at the
     *             beginning/end of the tweet or was surrounded by spaces.
     */
    private void sorter(String word) {

        // TODO find better way to write nested else if
        if (word.matches("@.+")) {
            mentionsList.add(word);
        } else if (word.matches("#.+")) {
            topicsList.add(word);
        } else if (word.matches("www|http")) {
            urlsList.add(word);
        }

        parsedMap.put("mentions", mentionsList);
        parsedMap.put("topics", topicsList);
        parsedMap.put("urls", urlsList);
    }

    // TODO create parsedMap getter method?
}
