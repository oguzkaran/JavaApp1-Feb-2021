/*----------------------------------------------------------------------------------------------------------------------
    Anımsanacağı gibi "Bitsel ve" ve "bitsel veya" operatörleri boolean türü ile kulanıldıklarında kısa devre davranışı
    olmayan "mantıksal ve" ve "mantıksal veya" operatörleri gibi çalışırlar
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

class App {
    public static void main(String[] args)
    {
        boolean result = Sample.foo() | Sample.bar() & Sample.tar();

        Console.writeLine(result);
    }
}

class Sample {
    public static boolean foo()
    {
        System.out.println("foo");

        return true;
    }

    public static boolean bar()
    {
        System.out.println("bar");

        return false;
    }

    public static boolean tar()
    {
        System.out.println("tar");

        return true;
    }
}


