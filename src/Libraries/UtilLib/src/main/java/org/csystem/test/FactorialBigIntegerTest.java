package org.csystem.test;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;

public class FactorialBigIntegerTest {
    private static void run()
    {
        for (int i = 0; i <= 1000; ++i)
            Console.writeLine("%d!=%s", i, NumberUtil.factorialBig(i));
    }

    private FactorialBigIntegerTest()
    {
    }

    public static void main(String[] args)
    {
        run();
    }
}

