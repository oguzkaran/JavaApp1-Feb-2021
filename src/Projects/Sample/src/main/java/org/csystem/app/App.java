/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        Sample.foo(3);
    }
}

class Sample {
    public static void foo(int n)
    {
        Console.writeLine("Giriş:%d", n);

        if (n == 0)
            return;

        foo(n - 1);
        Console.writeLine("Çıkış:%d", n); //**
    }
}

