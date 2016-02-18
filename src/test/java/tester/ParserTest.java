package tester;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import twitter.*;
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
        Parser p = new Parser(TestFixtures.L0);
        assert (p.parsedMap.isEmpty());
    }

    @Test
    public void emptySpaceParse() {
        //message with only a space
        Parser p = new Parser(TestFixtures.L00);
        assert (p.parsedMap.isEmpty());
    }

    @Test
    public void tooLongParse() {
        //message is too long
        Parser p = new Parser(TestFixtures.L000);
        assert(p.parsedMap.isEmpty());
    }

    @Test
    public void basicParse() {
        //basic message with no mentions/topics/URLs or punctuation
        Parser p = new Parser(TestFixtures.L1);
        assert (p.parsedMap.get("mentions").size() == 0);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("urls").size() == 0);
    }

    @Test
    public void oneLetterBasicParse() {
        //basic message one letter
        Parser p = new Parser(TestFixtures.L2);
        assert (p.parsedMap.get("mentions").size() == 0);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("urls").size() == 0);
    }

    @Test
    public void basicPunctuationParse() {
        //basic message with no mentions/topics/URLs with punctuation
        Parser p = new Parser(TestFixtures.L3);
        assert(p.parsedMap.get("mentions").size() == 0);
        assert(p.parsedMap.get("topics").size() == 0);
        assert(p.parsedMap.get("urls").size() == 0);
    }

    @Test
    public void twoBasicMentionsParse() {
        //message contains 2 mentions with punctuation
        Parser p = new Parser(TestFixtures.L4);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 2);
        assertTrue(p.parsedMap.get("mentions").contains("John"));
        assertTrue(p.parsedMap.get("mentions").contains("Martha"));
    }

    @Test
    public void oneBasicMentionParse() {
        //message only contains mention
        Parser p = new Parser(TestFixtures.L5);
        assert(p.parsedMap.get("topics").size() == 0);
        assert(p.parsedMap.get("urls").size() == 0);
        assert(p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("john"));
    }

    @Test
    public void emptyMentionParse() {
        //message is only @ symbol
        Parser p = new Parser(TestFixtures.L6);
        assert (p.parsedMap.get("mentions").size() == 0);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("urls").size() == 0);
    }

    @Test
    public void mentionDotParse() {
        //message is @ symbol followed by dot
        Parser p = new Parser(TestFixtures.L7);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 0);
    }

    @Test
    public void mentionTopicSymbolsParse() {
        //message is @ symbol followed by # symbol
        Parser p = new Parser(TestFixtures.L8);
        assert(p.parsedMap.get("topics").size() == 0);
        assert(p.parsedMap.get("urls").size() == 0);
        assert(p.parsedMap.get("mentions").size() == 0);
    }

    @Test
    public void oneMentionOneTopicParse() {
        //1 mention + 1 topic with punctuation
        Parser p = new Parser(TestFixtures.L9);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("you"));
        assert (p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("tagged"));
    }

    @Test
    public void oneMentionTwoTopicsParse() {
        //1 mention + 2 topics with punctuation
        Parser p = new Parser(TestFixtures.L10);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("John"));
        assert (p.parsedMap.get("topics").size() == 2);
        assertTrue(p.parsedMap.get("topics").contains("Google"));
        assertTrue(p.parsedMap.get("topics").contains("cool"));
    }

    @Test
    public void twoMentionsOneTopicParse() {
        //2 mentions + 1 topic
        Parser p = new Parser(TestFixtures.L11);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 2);
        assertTrue(p.parsedMap.get("mentions").contains("John"));
        assertTrue(p.parsedMap.get("mentions").contains("Billy"));
        assert (p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("cooler"));
    }

    @Test
    public void oneMentionManyTopicsParse() {
        //1 mention + 6 topics
        Parser p = new Parser(TestFixtures.L12);
        assert(p.parsedMap.get("urls").size() == 0);
        assert(p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("here"));
        assert(p.parsedMap.get("topics").size() == 6);
        assertTrue(p.parsedMap.get("topics").contains("there"));
        assertTrue(p.parsedMap.get("topics").contains("are"));
        assertTrue(p.parsedMap.get("topics").contains("a"));
        assertTrue(p.parsedMap.get("topics").contains("lot"));
        assertTrue(p.parsedMap.get("topics").contains("of"));
        assertTrue(p.parsedMap.get("topics").contains("tags"));
    }

    @Test
    public void basicHttpWwwURLsParse() {
        //URL with http + URL with www
        Parser p = new Parser(TestFixtures.L13);
        assert (p.parsedMap.get("mentions").size() == 0);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("urls").size() == 2);
        assertTrue(p.parsedMap.get("urls").contains("http://www.google.com"));
        assertTrue(p.parsedMap.get("urls").contains("www.google.com"));
    }

    @Test
    public void badURLOneTopicParse() {
        //1 topic + bad URL
        Parser p = new Parser(TestFixtures.L14);
        assert (p.parsedMap.get("mentions").size() == 0);
        //TODO fix URL with correct syntax, but website doesn't exist
        //assert(p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("favorite"));
    }

    @Test
    public void oneURLOneMentionOneTopicParse() {
        //1 mention + 1 topic + 1 URL
        Parser p = new Parser(TestFixtures.L15);
        assert(p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("Billy"));
        assert(p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("loves"));
        assert(p.parsedMap.get("urls").size() == 1);
        assertTrue(p.parsedMap.get("urls").contains("www.google.com"));
    }

    @Test
    public void oneShortenedURLOneMentionParse() {
        //1 mention + 1 shortened URL
        Parser p = new Parser(TestFixtures.L16);
        assert (p.parsedMap.get("topics").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("Twitter"));
        assert (p.parsedMap.get("urls").size() == 1);
        assertTrue(p.parsedMap.get("urls").contains("t.co"));
    }

    @Test
    public void manyShortenedURLsOneTopicParse() {
        //1 topic + 3 shortened URLs
        Parser p = new Parser(TestFixtures.L17);
        assert(p.parsedMap.get("mentions").size() == 0);
        assert(p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("services"));
        assert(p.parsedMap.get("urls").size() == 3);
        assertTrue(p.parsedMap.get("urls").contains("bit.ly"));
        assertTrue(p.parsedMap.get("urls").contains("goo.gl"));
        assertTrue(p.parsedMap.get("urls").contains("ow.ly"));
    }

    @Test
    public void twoShortenedTagsOneMentionParse() {
        //2 shortened tags + 1 mention
        Parser p = new Parser(TestFixtures.L18);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 1);
        assertTrue(p.parsedMap.get("mentions").contains("Billy"));
        assert (p.parsedMap.get("topics").size() == 2);
        assertTrue(p.parsedMap.get("topics").contains("this"));
        assertTrue(p.parsedMap.get("topics").contains("so"));
    }

    @Test
    public void longTagInvalidMentionParse() {
        //long tag + invalid mention
        Parser p = new Parser(TestFixtures.L19);
        assert (p.parsedMap.get("urls").size() == 0);
        assert (p.parsedMap.get("mentions").size() == 0);
        assert (p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("thatawkwardmomentwhen"));
    }

    @Test
    public void invalidMentionShortenedTagURLParse() {
        //URL + invalid mention + shortened tag
        Parser p = new Parser(TestFixtures.L20);
        assert(p.parsedMap.get("mentions").size() == 0);
        assert(p.parsedMap.get("urls").size() == 1);
        assertTrue(p.parsedMap.get("urls").contains("google.com"));
        assert(p.parsedMap.get("topics").size() == 1);
        assertTrue(p.parsedMap.get("topics").contains("google"));
    }

}



