/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: NumberUtil sınıfı içerisindeki isPrime metodunun BigInteger parametreleri overload'unu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigInteger;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        Random r = new Random();

        for (int i = 0; i < 10; ++i) {
            var n = new BigInteger(128, r); //[0, pow(2, 128) - 1]

            if (r.nextBoolean())
                n = n.negate();

            Console.writeLine(n);
        }
    }
}


