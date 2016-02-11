package tester;

import org.junit.Test;
import twitter.Parser;
import static org.junit.Assert.*;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/4/2016
 */
public class ParserTest {

    @Test
    public void emptyParse() {
        //empty message
        Parser p1 = new Parser(TestFixtures.L0);
        assert(p1.parsedMap.isEmpty());

        //message with only spaces
        Parser p2 = new Parser(TestFixtures.L00);
        assert(p2.parsedMap.isEmpty());

        //message is too long
        Parser p3 = new Parser(TestFixtures.L000);
        assert(p3.parsedMap.isEmpty());
    }

    @Test
    public void basicParse() {
        //basic message with no mentions/topics/URLs or punctuation
        Parser p1 = new Parser(TestFixtures.L1);
        assert(p1.parsedMap.get("mentions").size() == 0);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 0);

        //basic message one letter
        Parser p2 = new Parser(TestFixtures.L2);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 0);
        assert(p2.parsedMap.get("urls").size() == 0);

        //basic message with no mentions/topics/URLs with punctuation
        Parser p3 = new Parser(TestFixtures.L3);
        assert(p3.parsedMap.get("mentions").size() == 0);
        assert(p3.parsedMap.get("topics").size() == 0);
        assert(p3.parsedMap.get("urls").size() == 0);
    }

    @Test
    public void basicMentions() {
        //message contains 2 mentions with punctuation
        Parser p1 = new Parser(TestFixtures.L4);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 2);
        assertTrue(p1.parsedMap.get("mentions").contains("John"));
        assertTrue(p1.parsedMap.get("mentions").contains("Martha"));

        //message only contains mention
        Parser p2 = new Parser(TestFixtures.L5);
        assert(p2.parsedMap.get("topics").size() == 0);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 1);
        assertTrue(p2.parsedMap.get("mentions").contains("john"));
    }

    @Test
    public void emptyMentions() {
        //message is only @ symbol
        Parser p1 = new Parser(TestFixtures.L6);
        assert(p1.parsedMap.get("mentions").size() == 0);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 0);

        //message is @ symbol followed by dot
        Parser p2 = new Parser(TestFixtures.L7);
        assert(p2.parsedMap.get("topics").size() == 0);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 0);

        //message is @ symbol followed by # symbol
        Parser p3 = new Parser(TestFixtures.L8);
        assert(p3.parsedMap.get("topics").size() == 0);
        assert(p3.parsedMap.get("urls").size() == 0);
        assert(p3.parsedMap.get("mentions").size() == 0);
    }

    @Test
    public void mentionsTopicsCombo() {
        //1 mention + 1 topic with punctuation
        Parser p1 = new Parser(TestFixtures.L9);
        assert(p1.parsedMap.get("urls").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 1);
        assertTrue(p1.parsedMap.get("mentions").contains("you"));
        assert(p1.parsedMap.get("topics").size() == 1);
        assertTrue(p1.parsedMap.get("topics").contains("tagged"));

        //1 mention + 2 topics with punctuation
        Parser p2 = new Parser(TestFixtures.L10);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 1);
        assertTrue(p2.parsedMap.get("mentions").contains("John"));
        assert(p2.parsedMap.get("topics").size() == 2);
        assertTrue(p2.parsedMap.get("topics").contains("Google"));
        assertTrue(p2.parsedMap.get("topics").contains("cool"));

        //2 mentions + 1 topic
        Parser p3 = new Parser(TestFixtures.L11);
        assert(p3.parsedMap.get("urls").size() == 0);
        assert(p3.parsedMap.get("mentions").size() == 2);
        assertTrue(p3.parsedMap.get("mentions").contains("John"));
        assertTrue(p3.parsedMap.get("mentions").contains("Billy"));
        assert(p3.parsedMap.get("topics").size() == 1);
        assertTrue(p3.parsedMap.get("topics").contains("cooler"));

        //1 mention + 6 topics
        Parser p4 = new Parser(TestFixtures.L12);
        assert(p4.parsedMap.get("urls").size() == 0);
        assert(p4.parsedMap.get("mentions").size() == 1);
        assertTrue(p4.parsedMap.get("mentions").contains("here"));
        assert(p4.parsedMap.get("topics").size() == 6);
        assertTrue(p4.parsedMap.get("topics").contains("there"));
        assertTrue(p4.parsedMap.get("topics").contains("are"));
        assertTrue(p4.parsedMap.get("topics").contains("a"));
        assertTrue(p4.parsedMap.get("topics").contains("lot"));
        assertTrue(p4.parsedMap.get("topics").contains("of"));
        assertTrue(p4.parsedMap.get("topics").contains("tags"));
    }

    @Test
    public void basicURLs() {
        //URL with http
        Parser p1 = new Parser(TestFixtures.L13);
        assert(p1.parsedMap.get("mentions").size() == 0);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 1);
        assertTrue(p1.parsedMap.get("urls").contains("http://www.google.com"));

        //URL with www
        Parser p2 = new Parser(TestFixtures.L14);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 1);
        assertTrue(p2.parsedMap.get("topics").contains("favorite"));
        assert(p2.parsedMap.get("urls").size() == 1);
        assertTrue(p2.parsedMap.get("urls").contains("www.google.com"));

        //1 mention + 1 topic + 1 URL
        Parser p3 = new Parser(TestFixtures.L15);
        assert(p3.parsedMap.get("mentions").size() == 1);
        assertTrue(p3.parsedMap.get("mentions").contains("Billy"));
        assert(p3.parsedMap.get("topics").size() == 1);
        assertTrue(p3.parsedMap.get("topics").contains("loves"));
        assert(p3.parsedMap.get("urls").size() == 1);
        assertTrue(p3.parsedMap.get("urls").contains("www.google.com"));
    }

    @Test
    public void shortenedURLs() {
        //1 mention + 1 shortened URL
        Parser p1 = new Parser(TestFixtures.L16);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 1);
        assertTrue(p1.parsedMap.get("mentions").contains("Twitter"));
        assert(p1.parsedMap.get("urls").size() == 1);
        assertTrue(p1.parsedMap.get("urls").contains("t.co"));

        //1 topic + 3 shortened URLs
        Parser p2 = new Parser(TestFixtures.L17);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 1);
        assertTrue(p2.parsedMap.get("topics").contains("services"));
        assert(p2.parsedMap.get("urls").size() == 3);
        assertTrue(p2.parsedMap.get("urls").contains("bit.ly"));
        assertTrue(p2.parsedMap.get("urls").contains("goo.gl"));
        assertTrue(p2.parsedMap.get("urls").contains("ow.ly"));
    }

    @Test
    public void badTagsMentions() {
        //2 shortened tags + 1 mention
        Parser p1 = new Parser(TestFixtures.L18);
        assert(p1.parsedMap.get("urls").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 1);
        assertTrue(p1.parsedMap.get("mentions").contains("Billy"));
        assert(p1.parsedMap.get("topics").size() == 2);
        assertTrue(p1.parsedMap.get("topics").contains("this"));
        assertTrue(p1.parsedMap.get("topics").contains("so"));

        //long tag + invalid mention
        Parser p2 = new Parser(TestFixtures.L19);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 1);
        assertTrue(p2.parsedMap.get("topics").contains("thatawkwardmomentwhen"));

        //URL + invalid mention + shortened tag
        Parser p3 = new Parser(TestFixtures.L20);
        assert(p3.parsedMap.get("mentions").size() == 0);
        System.out.print(p3.parsedMap.get("urls"));
        assert(p3.parsedMap.get("urls").size() == 1);
        assertTrue(p3.parsedMap.get("urls").contains("google.com"));
        assert(p3.parsedMap.get("topics").size() == 1);
        assertTrue(p3.parsedMap.get("topics").contains("google"));
    }

}



