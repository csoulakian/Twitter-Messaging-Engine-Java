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
    public void basicParse() {
        Parser p = new Parser(TestFixtures.L1);
        assert(p.parsedMap.get("mentions").size() == 0);
        assert(p.parsedMap.get("topics").size() == 0);
        assert(p.parsedMap.get("urls").size() == 0);
    }


}



