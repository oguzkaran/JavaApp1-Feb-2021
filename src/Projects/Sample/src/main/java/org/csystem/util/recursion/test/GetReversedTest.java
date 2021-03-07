/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersyüz eden algoritmanın recursive olmayan bir versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.Util;

public class GetReversedTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            Console.writeLine(Util.getReversed(s));

            if ("quit".equals(s))
                break;
        }
    }
}
