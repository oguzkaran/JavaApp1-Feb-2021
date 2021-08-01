/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte yazılan isPrime metodunu inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.stream.IntStream;

class App {
    public static void main(String[] args)
    {
        IntStream.rangeClosed(-10, 100).filter(Util::isPrime).forEach(p -> Console.write("%d ", p));
    }
}

class Util {
    public static boolean isPrime(int val)
    {
        return val > 1 && IntStream.rangeClosed(2, val / 2).allMatch(i -> val % i != 0);
    }
}
