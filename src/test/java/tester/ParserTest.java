package tester;

import org.junit.Test;
import twitter.Parser;

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


}



