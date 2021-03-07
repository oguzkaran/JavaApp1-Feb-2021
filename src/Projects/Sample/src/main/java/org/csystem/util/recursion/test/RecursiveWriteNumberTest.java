/*----------------------------------------------------------------------------------------------------------------------
    Yalnızca bir karakteri ekrana yazan metot ve dizi veri yapısı kullanarak int türden bir sayıyı ekrana bastıran
    metodun recursive versiyonu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.recursion.test;

import org.csystem.util.Console;
import org.csystem.util.recursion.RecursionUtil;

public class RecursiveWriteNumberTest {
    public static void main(String [] args)
    {
        run();
    }

    public static void run()
    {
        for (;;) {
            var val = Console.readInt("Bir sayı giriniz:");

            RecursionUtil.writeNumber(val);
            Console.writeLine();

            if (val == 0)
                break;
        }
    }
}
