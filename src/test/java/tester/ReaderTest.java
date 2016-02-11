package tester;

import org.junit.Assert;
import twitter.Reader;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/2/2016
 *
 */
public class ReaderTest {

    @Test
    public void basicRead() {
        //basic message with no mentions/topics/URLs or punctuation
        Reader r1 = new Reader(TestFixtures.m1);
        assert(r1.message.equals(TestFixtures.m1));
        Assert.assertArrayEquals(r1.list, TestFixtures.L1);

        //basic message one letter
        Reader r2 = new Reader(TestFixtures.m2);
        assert(r2.message.equals(TestFixtures.m2));
        Assert.assertArrayEquals(r2.list, TestFixtures.L2);

        //basic message with no mentions/topics/URLs with punctuation
        Reader r3 = new Reader(TestFixtures.m3);
        assert(r3.message.equals(TestFixtures.m3));
        Assert.assertArrayEquals(r3.list, TestFixtures.L3);
    }

    @Test
    public void basicMentions() {
        //message contains 2 mentions with punctuation
        Reader r1 = new Reader(TestFixtures.m4);
        assert(r1.message.equals(TestFixtures.m4));
        Assert.assertArrayEquals(r1.list, TestFixtures.L4);

        //message only contains mention
        Reader r2 = new Reader(TestFixtures.m5);
        assert(r2.message.equals(TestFixtures.m5));
        Assert.assertArrayEquals(r2.list, TestFixtures.L5);
    }

    @Test
    public void emptyMentions() {
        //message is only @ symbol
        Reader r1 = new Reader(TestFixtures.m6);
        assert(r1.message.equals(TestFixtures.m6));
        Assert.assertArrayEquals(r1.list, TestFixtures.L6);

        //message is @ symbol followed by dot
        Reader r2 = new Reader(TestFixtures.m7);
        assert(r2.message.equals(TestFixtures.m7));
        Assert.assertArrayEquals(r2.list, TestFixtures.L7);

        //message is @ symbol followed by # symbol
        Reader r3 = new Reader(TestFixtures.m8);
        assert(r3.message.equals(TestFixtures.m8));
        Assert.assertArrayEquals(r3.list, TestFixtures.L8);
    }

    @Test
    public void mentionsTopicsCombo() {
        //1 mention + 1 topic with punctuation
        Reader r1 = new Reader(TestFixtures.m9);
        assert(r1.message.equals(TestFixtures.m9));
        Assert.assertArrayEquals(r1.list, TestFixtures.L9);

        //1 mention + 2 topics with punctuation
        Reader r2 = new Reader(TestFixtures.m10);
        assert(r2.message.equals(TestFixtures.m10));
        Assert.assertArrayEquals(r2.list, TestFixtures.L10);

        //2 mentions + 1 topic
        Reader r3 = new Reader(TestFixtures.m11);
        assert(r3.message.equals(TestFixtures.m11));
        Assert.assertArrayEquals(r3.list, TestFixtures.L11);

        //1 mention + 6 topics
        Reader r4 = new Reader(TestFixtures.m12);
        assert(r4.message.equals(TestFixtures.m12));
        Assert.assertArrayEquals(r4.list, TestFixtures.L12);
    }

    @Test
    public void basicURLs() {
        //URL with http
        Reader r1 = new Reader(TestFixtures.m13);
        assert(r1.message.equals(TestFixtures.m13));
        Assert.assertArrayEquals(r1.list, TestFixtures.L13);

        //URL with www
        Reader r2 = new Reader(TestFixtures.m14);
        assert(r2.message.equals(TestFixtures.m14));
        Assert.assertArrayEquals(r2.list, TestFixtures.L14);

        //1 mention + 1 topic + 1 URL
        Reader r3 = new Reader(TestFixtures.m15);
        assert(r3.message.equals(TestFixtures.m15));
        Assert.assertArrayEquals(r3.list, TestFixtures.L15);
    }

    @Test
    public void shortenedURLs() {
        //1 mention + 1 shortened URL
        Reader r1 = new Reader(TestFixtures.m16);
        assert(r1.message.equals(TestFixtures.m16));
        Assert.assertArrayEquals(r1.list, TestFixtures.L16);

        //1 topic + 3 shortened URLs
        Reader r2 = new Reader(TestFixtures.m17);
        assert(r2.message.equals(TestFixtures.m17));
        Assert.assertArrayEquals(r2.list, TestFixtures.L17);
    }

    @Test
    public void badTagsMentions() {
        //2 shortened tags + 1 mention
        Reader r1 = new Reader(TestFixtures.m18);
        assert(r1.message.equals(TestFixtures.m18));
        Assert.assertArrayEquals(r1.list, TestFixtures.L18);

        //long tag + invalid mention
        Reader r2 = new Reader(TestFixtures.m19);
        assert(r2.message.equals(TestFixtures.m19));
        Assert.assertArrayEquals(r2.list, TestFixtures.L19);

        //URL + invalid mention + shortened tag
        Reader r3 = new Reader(TestFixtures.m20);
        assert(r3.message.equals(TestFixtures.m20));
        Assert.assertArrayEquals(r3.list, TestFixtures.L20);
    }
}
