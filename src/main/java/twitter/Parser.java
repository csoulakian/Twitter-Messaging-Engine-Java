package twitter;
import java.net.URI;
import java.net.URISyntaxException;
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
     */
    private ArrayList<String> mentionsList = new ArrayList<>();

    /**
     * An ArrayList containing all the topics that were tagged in the tweet.
     */
    private ArrayList<String> topicsList = new ArrayList<>();

    /**
     * An ArrayList containing all the urls that were linked in the tweet.
     */
    private ArrayList<String> urlsList = new ArrayList<>();

    /**
     * regex to match in sorter method for mentions. begins with @ symbol and followed
     * by one or more of any character.
     */
    private static String regMentions = "@.+";

    /**
     * regex to match in sorter method for topics. begins with # symbol and followed
     * by one or more of any character.
     */
    private static String regTopics = "#.+";

    /**
     * regex to match in sorter method for URLs. starts with at least one character, followed by
     * at least one dot, followed by at least one character. matches words that contain at least one
     * dot somewhere in the word but not at the beginning or end. additional check of verifying
     * the URL is completed after matched to regex.
     */
    private static String regURLs = ".+\\..+";

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
     * character, and finally checks if the word contains at least one dot in the word
     * which is not at the beginning or end. If it does, and the URI is verified,
     * then it is added to the URLs list.
     * TODO remove special characters like .?! from end of mention and topics
     * @param word A "sub-string" of the original message that was either at the
     *             beginning/end of the tweet or was surrounded by spaces.
     */
    private void sorter(String word) {
        if (word.matches(regMentions)) {
            mentionsList.add(word.substring(1));
        } else if (word.matches(regTopics)) {
            topicsList.add(word.substring(1));
        } else if (word.matches(regURLs) && verifyURL(word)) {
            urlsList.add(word);
        }

        parsedMap.put("mentions", mentionsList);
        parsedMap.put("topics", topicsList);
        parsedMap.put("urls", urlsList);
    }

    /**
     * Checks if a word that doesn't start with @ or # and has a dot
     * somewhere in the middle of the word is a valid URL.
     * @param url input string that is a potentially valid URL
     * @return true if the URL is valid, otherwise false
     */
    private boolean verifyURL(String url) {
        try {
            new URI(url);
            return true;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    // TODO create parsedMap getter method?
}
