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
        Parser p1 = new Parser(TestFixtures.L1);
        assert(p1.parsedMap.get("mentions").size() == 0);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 0);

        Parser p2 = new Parser(TestFixtures.L2);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 0);
        assert(p2.parsedMap.get("urls").size() == 0);

        Parser p3 = new Parser(TestFixtures.L3);
        assert(p3.parsedMap.get("mentions").size() == 0);
        assert(p3.parsedMap.get("topics").size() == 0);
        assert(p3.parsedMap.get("urls").size() == 0);
    }

    @Test
    public void basicMentions() {
        Parser p1 = new Parser(TestFixtures.L4);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 2);
        assertTrue(p1.parsedMap.get("mentions").contains("John,"));
        assertTrue(p1.parsedMap.get("mentions").contains("Martha?"));

        Parser p2 = new Parser(TestFixtures.L5);
        assert(p2.parsedMap.get("topics").size() == 0);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 1);
        assertTrue(p2.parsedMap.get("mentions").contains("john"));
    }

    @Test
    public void emptyMentions() {
        Parser p1 = new Parser(TestFixtures.L6);
        assert(p1.parsedMap.get("mentions").size() == 0);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 0);

        //TODO should be empty
        Parser p2 = new Parser(TestFixtures.L7);
        assert(p2.parsedMap.get("topics").size() == 0);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 1);
        assertTrue(p2.parsedMap.get("mentions").contains("."));

        //should be empty
        Parser p3 = new Parser(TestFixtures.L8);
        assert(p3.parsedMap.get("topics").size() == 0);
        assert(p3.parsedMap.get("urls").size() == 0);
        assert(p3.parsedMap.get("mentions").size() == 1);
        assertTrue(p3.parsedMap.get("mentions").contains("#"));
    }

    @Test
    public void mentionsTopicsCombo() {
        Parser p1 = new Parser(TestFixtures.L9);
        assert(p1.parsedMap.get("urls").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 1);
        assertTrue(p1.parsedMap.get("mentions").contains("you"));
        assert(p1.parsedMap.get("topics").size() == 1);
        assertTrue(p1.parsedMap.get("topics").contains("tagged"));

        Parser p2 = new Parser(TestFixtures.L10);
        assert(p2.parsedMap.get("urls").size() == 0);
        assert(p2.parsedMap.get("mentions").size() == 1);
        assertTrue(p2.parsedMap.get("mentions").contains("John"));
        assert(p2.parsedMap.get("topics").size() == 2);
        assertTrue(p2.parsedMap.get("topics").contains("Google"));
        assertTrue(p2.parsedMap.get("topics").contains("cool."));

        Parser p3 = new Parser(TestFixtures.L11);
        assert(p3.parsedMap.get("urls").size() == 0);
        assert(p3.parsedMap.get("mentions").size() == 2);
        assertTrue(p3.parsedMap.get("mentions").contains("John"));
        assertTrue(p3.parsedMap.get("mentions").contains("Billy"));
        assert(p3.parsedMap.get("topics").size() == 1);
        assertTrue(p3.parsedMap.get("topics").contains("cooler"));

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
        Parser p1 = new Parser(TestFixtures.L13);
        assert(p1.parsedMap.get("mentions").size() == 0);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("urls").size() == 1);
        assertTrue(p1.parsedMap.get("urls").contains("http://www.google.com"));

        Parser p2 = new Parser(TestFixtures.L14);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 1);
        assertTrue(p2.parsedMap.get("topics").contains("favorite"));
        assert(p2.parsedMap.get("urls").size() == 1);
        assertTrue(p2.parsedMap.get("urls").contains("www.google.com"));

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
        Parser p1 = new Parser(TestFixtures.L16);
        assert(p1.parsedMap.get("topics").size() == 0);
        assert(p1.parsedMap.get("mentions").size() == 1);
        assertTrue(p1.parsedMap.get("mentions").contains("Twitter"));
        assert(p1.parsedMap.get("urls").size() == 1);
        assertTrue(p1.parsedMap.get("urls").contains("t.co"));

        Parser p2 = new Parser(TestFixtures.L17);
        assert(p2.parsedMap.get("mentions").size() == 0);
        assert(p2.parsedMap.get("topics").size() == 1);
        assertTrue(p2.parsedMap.get("topics").contains("services"));
        assert(p2.parsedMap.get("urls").size() == 3);
        assertTrue(p2.parsedMap.get("urls").contains("bit.ly"));
        assertTrue(p2.parsedMap.get("urls").contains("goo.gl"));
        assertTrue(p2.parsedMap.get("urls").contains("ow.ly"));
    }

}



