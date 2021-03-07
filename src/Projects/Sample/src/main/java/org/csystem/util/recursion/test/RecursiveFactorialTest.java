/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.RecursionUtil;

public class RecursiveFactorialTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (int i = -1; i < 13; ++i)
            Console.writeLine("%d! = %d", i, RecursionUtil.factorial(i));
    }
}
