/*----------------------------------------------------------------------------------------------------------------------
    BitwiseUtil sınıfının isSet metodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.bitwise.BitwiseUtil;

class App {
    public static void main(String[] args)
    {
        for (;;) {
            var a = Console.readLong("Bir sayı giriniz:");
            if (a == 0)
                break;

            BitwiseUtil.writeBits(a);
            Console.writeLine("%d sayısı ikinin %s", a, (a & (a - 1)) == 0 ? "kuvvetidir" : "kuvveti değildir");
        }
    }
}
