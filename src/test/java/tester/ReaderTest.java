package tester;

import org.junit.Assert;
import twitter.Reader;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/2/2016
 *
 */
public class ReaderTest {

    @Test
    public void basicTweets() {
        Reader reader = new Reader(TestFixtures.m0);
        //Assert.assertArrayEquals(reader.list, TestFixtures.L1);
    }


}
