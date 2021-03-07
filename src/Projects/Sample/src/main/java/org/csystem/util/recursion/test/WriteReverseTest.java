/*----------------------------------------------------------------------------------------------------------------------
    Bir yazıyı tersten yazdıran algoritmanın recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.Util;

public class WriteReverseTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (;;) {
            var s = Console.read("Bir yazı giriniz:");

            Util.writeReverse(s);
            Console.writeLine();

            if ("quit".equals(s))
                break;
        }
    }
}
