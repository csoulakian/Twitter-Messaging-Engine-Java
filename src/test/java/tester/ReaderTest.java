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
        Reader r1 = new Reader(TestFixtures.m1);
        System.out.println(r1.message);
        assert(r1.message.equals(TestFixtures.m1));
        Assert.assertArrayEquals(r1.list, TestFixtures.L1);

        Reader r2 = new Reader(TestFixtures.m2);
        System.out.println(r2.message);
        assert(r2.message.equals(TestFixtures.m2));
        Assert.assertArrayEquals(r2.list, TestFixtures.L2);

        Reader r3 = new Reader(TestFixtures.m3);
        System.out.println(r3.message);
        assert(r3.message.equals(TestFixtures.m3));
        Assert.assertArrayEquals(r3.list, TestFixtures.L3);
    }


}
