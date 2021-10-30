package org.csystem.test.number.runner;

import org.csystem.test.number.testcase.IsPrimeTestCase;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class IsPrimeTestRunner {
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(IsPrimeTestCase.class);

        for (Failure f : result.getFailures())
            System.err.println(f);

        System.out.printf("Number Of Failures:%d%n", result.getFailureCount());
        System.out.println(result.wasSuccessful() ? "Success" : "Fail");
    }
}

