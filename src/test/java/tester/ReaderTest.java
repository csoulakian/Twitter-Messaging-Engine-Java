package tester;

import org.junit.Assert;
import twitter.Reader;
import org.junit.Test;
import twitter.Reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/2/2016
 *
 * Trying to get test to work with scanner using
 * http://stackoverflow.com/questions/31635698/junit-testing-for-user-input-using-scanner
 */
public class ReaderTest {

    //Reader reader = new Reader();

    @Test
    public void basicTweets() {
        Reader reader = new Reader();
        String input = TestFixtures.m1;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assert.assertArrayEquals(reader.list, TestFixtures.L1);



    }


}
