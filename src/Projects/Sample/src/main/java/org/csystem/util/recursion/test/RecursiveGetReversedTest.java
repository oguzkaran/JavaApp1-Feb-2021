/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersyüz eden algoritmanın recursive bir versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.RecursionUtil;

public class RecursiveGetReversedTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            Console.writeLine(RecursionUtil.getReversed(s));

            if ("quit".equals(s))
                break;
        }
    }
}
