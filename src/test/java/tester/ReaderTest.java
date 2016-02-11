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
        System.out.println(r1.message);
        assert(r1.message.equals(TestFixtures.m1));
        Assert.assertArrayEquals(r1.list, TestFixtures.L1);

        //basic message one letter
        Reader r2 = new Reader(TestFixtures.m2);
        System.out.println(r2.message);
        assert(r2.message.equals(TestFixtures.m2));
        Assert.assertArrayEquals(r2.list, TestFixtures.L2);

        //basic message with no mentions/topics/URLs with punctuation
        Reader r3 = new Reader(TestFixtures.m3);
        System.out.println(r3.message);
        assert(r3.message.equals(TestFixtures.m3));
        Assert.assertArrayEquals(r3.list, TestFixtures.L3);
    }

    @Test
    public void basicMentions() {
        //message contains 2 mentions with punctuation
        Reader r1 = new Reader(TestFixtures.m4);
        System.out.println(r1.message);
        assert(r1.message.equals(TestFixtures.m4));
        Assert.assertArrayEquals(r1.list, TestFixtures.L4);

        //message only contains mention
        Reader r2 = new Reader(TestFixtures.m5);
        System.out.println(r2.message);
        assert(r2.message.equals(TestFixtures.m5));
        Assert.assertArrayEquals(r2.list, TestFixtures.L5);
    }

    @Test
    public void emptyMentions() {
        //message is only @ symbol
        Reader r1 = new Reader(TestFixtures.m6);
        System.out.println(r1.message);
        assert(r1.message.equals(TestFixtures.m6));
        Assert.assertArrayEquals(r1.list, TestFixtures.L6);

        //message is @ symbol followed by dot
        Reader r2 = new Reader(TestFixtures.m7);
        System.out.println(r2.message);
        assert(r2.message.equals(TestFixtures.m7));
        Assert.assertArrayEquals(r2.list, TestFixtures.L7);

        //message is @ symbol followed by # symbol
        Reader r3 = new Reader(TestFixtures.m8);
        System.out.println(r3.message);
        assert(r3.message.equals(TestFixtures.m8));
        Assert.assertArrayEquals(r3.list, TestFixtures.L8);
    }


}
