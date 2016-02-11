package tester;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/11/2016
 *
 * A class to run all tests in ReaderTest and ParserTest.
 * Idea from http://www.javacodegeeks.com/2014/11/junit-tutorial-unit-testing.html#suite_tests
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ReaderTest.class, ParserTest.class})
public class SuiteTest {

}
