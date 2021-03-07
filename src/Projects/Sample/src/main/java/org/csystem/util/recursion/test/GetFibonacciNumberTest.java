/*----------------------------------------------------------------------------------------------------------------------
    n-ici Fibonacci sayısını döndüren getFibonacciNumber metodunun recursive olmayan versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.Util;

public class GetFibonacciNumberTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (;;) {
            var n = Console.readInt("Bir sayı giriniz:");

            if (n <= 0)
                break;

            Console.writeLine(Util.getFibonacciNumber(n));
        }
    }
}
