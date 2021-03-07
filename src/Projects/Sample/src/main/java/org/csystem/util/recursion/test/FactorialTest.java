/*----------------------------------------------------------------------------------------------------------------------
    Faktoriyel hesaplayan metodun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.Util;

public class FactorialTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (int i = -1; i < 13; ++i)
            Console.writeLine("%d! = %d", i, Util.factorial(i));
    }
}
