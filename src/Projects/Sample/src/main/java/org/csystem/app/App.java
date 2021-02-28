/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki örnek aşağıdaki gibi char türden dizi ile yapılabilir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

public class App {
    public static void main(String[] args)
    {
        for (;;) {
            String s = Console.read("Bir yazı giriniz:");

            if ("quit".equals(s))
                break;

            Console.writeLine(Util.reverse(s));
        }
    }
}

class Util {
    public static String reverse(String str)
    {
        char [] c = str.toCharArray();

        ArrayUtil.reverse(c);

        return String.valueOf(c);
    }
}
