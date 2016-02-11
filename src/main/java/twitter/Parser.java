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
 *
 * Idea for URI verifier from
 * http://stackoverflow.com/questions/14188350/how-do-you-test-if-string-is-in-url-format
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
     * by 1-14 letters, numbers, or underscores. the word can optionally end in 0 or 1
     * of any character to allow for ending punctuation.
     */
    private static String regMentions = "^@[A-Za-z0-9_]{1,14}.?$";

    /**
     * regex to match in sorter method for topics. begins with # symbol and followed
     * by one or more letters, numbers, or underscores. It could be followed by 0 or
     * more of any character to allow for ending punctuation.
     */
    private static String regTopics = "#[A-Za-z0-9_]+.*";

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
     * Sorts a word by first catching if it matches the regex in regMentions.
     * All special characters are then removed from the string before it
     * is added to the mentionsList.
     * Then sorter catches if the word matches the regex in regTopics.
     * If it does, then the initial # symbol is removed and the topic stops
     * prematurely where the first special character occurs (not letter/number/underscore).
     * The final topic is added to the topicsList.
     * Last, the sorter checks if the word contains at least one dot which is not at
     * the beginning or end. If it does, and the URI is verified,
     * then it is added to the URLs list.
     * @param word A "sub-string" of the original message that was either at the
     *             beginning/end of the tweet or was surrounded by spaces.
     */
    private void sorter(String word) {
        if (word.matches(regMentions)) {
            word = word.replaceAll("[^A-Za-z0-9_]", "");
            mentionsList.add(word);
        } else if (word.matches(regTopics)) {
            word = word.substring(1).replaceFirst("[^A-Za-z0-9_].*", "");
            topicsList.add(word);
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

}
