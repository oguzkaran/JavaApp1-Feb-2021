/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: int türden iki dizi dizisinin eşit olup olmadığını test eden equals isimli metodu yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

import java.util.Arrays;
import java.util.Random;

class App {
    public static void main(String[] args)
    {
        EqualsTest.run();
    }
}

class EqualsTest {
    private EqualsTest()
    {
    }

    public static void run()
    {
        for (;;) {
            var seed1 = Console.readLong("Birinci tohum değerini giriniz:");
            if (seed1 == 0)
                break;
            var seed2 = Console.readLong("İkinci tohum değerini giriniz:");
            var r1 = new Random(seed1);

            var m1 = ArrayUtil.getRandomMatrix(r1, 3, 4, 1, 100);
            var m2 = ArrayUtil.getRandomMatrix(r1, 3, 4, 1, 100);

            ArrayUtil.display(2, m1);
            Console.writeLine("------------------");
            ArrayUtil.display(2, m2);
            Console.writeLine("------------------");
            Console.writeLine(Util.equals(m1, m2) ? "Eşit" : "Eşit değil");
        }
    }
}
class Util {
    public static boolean equals(int [][] a, int [][] b)
    {
        if (a.length != b.length)
            return false;

        for (var i = 0; i < a.length; ++i)
            if (!Arrays.equals(a[i], b[i]))
                return false;

        return true;
    }
}