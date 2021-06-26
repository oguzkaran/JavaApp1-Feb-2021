/*----------------------------------------------------------------------------------------------------------------------
    IntRange sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.range.IntRange;

import java.util.function.Consumer;

class App {
    public static void main(String[] args)
    {
        IntRange intRange = new IntRange(10, 50, 3);

        Util.doWork(intRange, val -> Console.write("%d ", val));

        Console.writeLine();

        for (var val : intRange)
            Console.write("%d ", val);
    }
}

class Util {
    public static <T> void doWork(Iterable<T> iterable, Consumer<T> consumer)
    {
        for (var val : iterable)
            consumer.accept(val);
    }
}

