package tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/2/2016
 */
public class TestFixtures {

    //test messages
    static String m0 = "";
    static String m00 = " ";
    static String m1 = "one TWO Three, this is a basic tweet!";
    static String m2 = "this tweet is way tooooooooooooooooooooooooooooooooooooooooooooo long, " +
            "because it is way tooooooooooooooooooo many characters blah blah blah " +
            "how do we handle this long tweet?";
    static String m3 = "a ";
    static String m4 = "This is a statement. Can you handle the questions?";
    static String m5 = "Hey @John, have you heard from our friend, @Martha?";
    static String m6 = "@john";
    static String m7 = "@";
    static String m8 = "@.";
    static String m9 = "@#";
    static String m10 = "Have you been #tagged yet?";
    static String m11 = "@John believes #Google is cool.";
    static String m12 = "@Billy is #cooler than @John";
    static String m13 = "#there #are #a #lot #of #tags @here";
    static String m14 = "http://www.google.com is the best website ever!";
    static String m15 = "my #favorite website is www.google.com";
    static String m16 = "@Billy #loves www.google.com";

    //string arrays for the messages
    static String[] L0 = {};
    static String[] L00 = {};
    static String[] L1 = {"one", "TWO", "Three,", "this", "is", "a", "basic", "tweet!"};
    //static String[] L2 =
    static String[] L3 = {"a"};
    static String[] L4 = {"This", "is", "a", "statement.", "Can", "you", "handle", "the", "questions?"};
    static String[] L5 = {"Hey", "@John,", "have", "you", "heard", "from", "our", "friend,", "@Martha?"};
    static String[] L6 = {"@john"};
    static String[] L7 = {"@"};
    static String[] L8 = {"@."};
    static String[] L9 = {"@#"};
    static String[] L10 = {"Have", "you", "been", "#tagged", "yet?"};
    static String[] L11 = {"@John", "believes", "#Google", "is", "cool."};
    static String[] L12 = {"@Billy", "is", "#cooler", "than", "@John"};
    static String[] L13 = {"#there", "#are", "#a", "#lot", "#of", "#tags", "@here"};
    static String[] L14 = {"http://www.google.com", "is", "the", "best", "website", "ever!"};
    static String[] L15 = {"my", "#favorite", "website", "is", "www.google.com"};
    static String[] L16 = {"@Billy", "#loves", "www.google.com"};

    //HashMaps of the messages

    //initial empty parsedMap
    static Map<String, ArrayList<String>> emptyMap = new HashMap<>();
    static {
        emptyMap.put("mentions", new ArrayList<>());
        emptyMap.put("topics", new ArrayList<>());
        emptyMap.put("urls", new ArrayList<>());
    }

}
