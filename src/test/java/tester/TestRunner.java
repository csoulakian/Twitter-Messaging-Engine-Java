package tester;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/11/2016
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SuiteTest.class);
        for (Failure fail : result.getFailures()) {
            System.out.println(fail.toString());

        }
        if (result.wasSuccessful()) {
            System.out.println("All tests finished successfully.");
        }
    }
}
