package tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/2/2016
 *
 * no HashMaps in TestFixtures, can't assert that two HashMaps are equal
 */
public class TestFixtures {

    //test messages
    static String m0 = "";
    static String m00 = " ";
    static String m000 = "this tweet is way tooooooooooooooooooooooooooooooooooooooooooooo long, " +
            "because it is way tooooooooooooooooooo many characters blah blah blah " +
            "how do we handle this long tweet?";
    static String m1 = "one TWO Three this is a basic tweet";
    static String m2 = "a ";
    static String m3 = "This is a statement. Can you handle the questions?";
    static String m4 = "Hey @John, have you heard from our friend, @Martha?";
    static String m5 = "@john";
    static String m6 = "@";
    static String m7 = "@.";
    static String m8 = "@#";
    static String m9 = "Have @you been #tagged yet?";
    static String m10 = "@John believes #Google is #cool.";
    static String m11 = "@Billy is #cooler than @John";
    static String m12 = "#there #are #a #lot #of #tags @here";
    static String m13 = "http://www.google.com is the best website ever!";
    static String m14 = "my #favorite website is www.google.com";
    static String m15 = "@Billy #loves www.google.com";
    static String m16 = "@Twitter uses t.co as a website";
    static String m17 = "URL shortening #services bit.ly goo.gl ow.ly";

    //string arrays for the messages
    static String[] L0 = {};
    static String[] L00 = {};
    static String[] L000 = {};
    static String[] L1 = {"one", "TWO", "Three", "this", "is", "a", "basic", "tweet"};
    static String[] L2 = {"a"};
    static String[] L3 = {"This", "is", "a", "statement.", "Can", "you", "handle", "the", "questions?"};
    static String[] L4 = {"Hey", "@John,", "have", "you", "heard", "from", "our", "friend,", "@Martha?"};
    static String[] L5 = {"@john"};
    static String[] L6 = {"@"};
    static String[] L7 = {"@."};
    static String[] L8 = {"@#"};
    static String[] L9 = {"Have", "@you", "been", "#tagged", "yet?"};
    static String[] L10 = {"@John", "believes", "#Google", "is", "#cool."};
    static String[] L11 = {"@Billy", "is", "#cooler", "than", "@John"};
    static String[] L12 = {"#there", "#are", "#a", "#lot", "#of", "#tags", "@here"};
    static String[] L13 = {"http://www.google.com", "is", "the", "best", "website", "ever!"};
    static String[] L14 = {"my", "#favorite", "website", "is", "www.google.com"};
    static String[] L15 = {"@Billy", "#loves", "www.google.com"};
    static String[] L16 = {"@Twitter", "uses", "t.co", "as", "a", "website"};
    static String[] L17 = {"URL", "shortening", "#services", "bit.ly", "goo.gl", "ow.ly"};
    //TODO add test cases for early shortening of tags and invalid mentions

}
