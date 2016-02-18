package tester;

import org.junit.Assert;
import twitter.*;
import org.junit.Test;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/2/2016
 *
 */
public class ReaderTest {

    @Test
    public void emptyRead() {
        //empty message
        Reader r = new Reader(TestFixtures.m0);
        assert (r.message.equals(TestFixtures.m0));
        Assert.assertArrayEquals(r.list, TestFixtures.L0);
    }

    @Test
    public void emptySpaceRead() {
        //message with only a space
        Reader r = new Reader(TestFixtures.m00);
        assert (r.message.equals(TestFixtures.m00));
        Assert.assertArrayEquals(r.list, TestFixtures.L00);
    }

    @Test
    public void tooLongRead() {
        //message is too long
        Reader r = new Reader(TestFixtures.m000);
        assert(r.message.equals(TestFixtures.m000));
        Assert.assertArrayEquals(r.list, TestFixtures.L000);
    }

    @Test
    public void basicRead() {
        //basic message with no mentions/topics/URLs or punctuation
        Reader r = new Reader(TestFixtures.m1);
        assert (r.message.equals(TestFixtures.m1));
        Assert.assertArrayEquals(r.list, TestFixtures.L1);
    }

    @Test
    public void oneLetterBasicRead() {
        //basic message one letter
        Reader r = new Reader(TestFixtures.m2);
        assert (r.message.equals(TestFixtures.m2));
        Assert.assertArrayEquals(r.list, TestFixtures.L2);
    }

    @Test
    public void basicPunctuationRead() {
        //basic message with no mentions/topics/URLs with punctuation
        Reader r = new Reader(TestFixtures.m3);
        assert(r.message.equals(TestFixtures.m3));
        Assert.assertArrayEquals(r.list, TestFixtures.L3);
    }

    @Test
    public void twoBasicMentionsRead() {
        //message contains 2 mentions with punctuation
        Reader r = new Reader(TestFixtures.m4);
        assert (r.message.equals(TestFixtures.m4));
        Assert.assertArrayEquals(r.list, TestFixtures.L4);
    }

    @Test
    public void oneBasicMentionRead() {
        //message only contains one mention
        Reader r = new Reader(TestFixtures.m5);
        assert(r.message.equals(TestFixtures.m5));
        Assert.assertArrayEquals(r.list, TestFixtures.L5);
    }

    @Test
    public void emptyMentionRead() {
        //message is only @ symbol
        Reader r = new Reader(TestFixtures.m6);
        assert (r.message.equals(TestFixtures.m6));
        Assert.assertArrayEquals(r.list, TestFixtures.L6);
    }

    @Test
    public void mentionDotRead() {
        //message is @ symbol followed by dot
        Reader r = new Reader(TestFixtures.m7);
        assert (r.message.equals(TestFixtures.m7));
        Assert.assertArrayEquals(r.list, TestFixtures.L7);
    }

    @Test
    public void mentionTopicSymbolsRead() {
        //message is @ symbol followed by # symbol
        Reader r = new Reader(TestFixtures.m8);
        assert(r.message.equals(TestFixtures.m8));
        Assert.assertArrayEquals(r.list, TestFixtures.L8);
    }

    @Test
    public void oneMentionOneTopicRead() {
        //1 mention + 1 topic with punctuation
        Reader r = new Reader(TestFixtures.m9);
        assert (r.message.equals(TestFixtures.m9));
        Assert.assertArrayEquals(r.list, TestFixtures.L9);
    }

    @Test
    public void oneMentionTwoTopicsRead() {
        //1 mention + 2 topics with punctuation
        Reader r = new Reader(TestFixtures.m10);
        assert (r.message.equals(TestFixtures.m10));
        Assert.assertArrayEquals(r.list, TestFixtures.L10);
    }

    @Test
    public void twoMentionsOneTopicRead() {
        //2 mentions + 1 topic
        Reader r = new Reader(TestFixtures.m11);
        assert (r.message.equals(TestFixtures.m11));
        Assert.assertArrayEquals(r.list, TestFixtures.L11);
    }

    @Test
    public void oneMentionManyTopicsRead() {
        //1 mention + 6 topics
        Reader r = new Reader(TestFixtures.m12);
        assert(r.message.equals(TestFixtures.m12));
        Assert.assertArrayEquals(r.list, TestFixtures.L12);
    }

    @Test
    public void basicHttpWwwURLsRead() {
        //URL with http + URL with www
        Reader r = new Reader(TestFixtures.m13);
        assert (r.message.equals(TestFixtures.m13));
        Assert.assertArrayEquals(r.list, TestFixtures.L13);
    }

    @Test
    public void badURLOneTopicRead() {
        //1 topic + bad URL
        Reader r = new Reader(TestFixtures.m14);
        assert (r.message.equals(TestFixtures.m14));
        Assert.assertArrayEquals(r.list, TestFixtures.L14);
    }

    @Test
    public void oneURLOneMentionOneTopicRead() {
        //1 mention + 1 topic + 1 URL
        Reader r = new Reader(TestFixtures.m15);
        assert(r.message.equals(TestFixtures.m15));
        Assert.assertArrayEquals(r.list, TestFixtures.L15);
    }

    @Test
    public void oneShortenedURLOneMentionRead() {
        //1 mention + 1 shortened URL
        Reader r = new Reader(TestFixtures.m16);
        assert (r.message.equals(TestFixtures.m16));
        Assert.assertArrayEquals(r.list, TestFixtures.L16);
    }

    @Test
    public void manyShortenedURLsOneTopicRead() {
        //1 topic + 3 shortened URLs
        Reader r = new Reader(TestFixtures.m17);
        assert(r.message.equals(TestFixtures.m17));
        Assert.assertArrayEquals(r.list, TestFixtures.L17);
    }

    @Test
    public void twoShortenedTagsOneMentionRead() {
        //2 shortened tags + 1 mention
        Reader r = new Reader(TestFixtures.m18);
        assert (r.message.equals(TestFixtures.m18));
        Assert.assertArrayEquals(r.list, TestFixtures.L18);
    }

    @Test
    public void longTagInvalidMentionRead() {
        //long tag + invalid mention
        Reader r = new Reader(TestFixtures.m19);
        assert (r.message.equals(TestFixtures.m19));
        Assert.assertArrayEquals(r.list, TestFixtures.L19);
    }

    @Test
    public void invalidMentionShortenedTagURLRead() {
        //URL + invalid mention + shortened tag
        Reader r = new Reader(TestFixtures.m20);
        assert(r.message.equals(TestFixtures.m20));
        Assert.assertArrayEquals(r.list, TestFixtures.L20);
    }
}