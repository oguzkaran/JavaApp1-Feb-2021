/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki kod Java 8 ile Comparator<T> arayüzüne eklenen reverseOrder metodu ile yazılabilir. reverseOrders
    çağrılabilmesi için açılıma ilişkin türün Comparable<T> arayüzünü desteklemesi gerekir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.math.Complex;

import java.util.Random;
import java.util.TreeSet;

class App {
    public static void main(String[] args)
    {
        TreeSet<Complex> treeSet = new TreeSet<>((z1, z2) -> Double.compare(z1.getNorm(), z2.getNorm()));
        Random r = new Random();

        int min = -10, max = 10;

        for (int i = 0; i < 10; ++i) {
            int a = r.nextInt(max - min + 1) + 1;
            int b = r.nextInt(max - min + 1) + 1;
            var z = new Complex(a, b);

            treeSet.add(z);
        }

        Console.writeLine();
        Console.writeLine(treeSet);
        Console.writeLine("Size:%d", treeSet.size());
    }
}
