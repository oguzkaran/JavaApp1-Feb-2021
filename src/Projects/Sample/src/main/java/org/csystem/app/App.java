/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte [-2 * PI, 2 * PI] aralığında sinus fonksiyonun değerleri elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.stream.DoubleStream;

class App {
    public static void main(String[] args)
    {
        var min = -2 * Math.PI;
        var max = 2 * Math.PI;
        var step = 0.03;

        DoubleStream.iterate(min, i -> Double.compare(i, max) <= 0, i -> i + step)
                .map(Math::sin)
                .forEach(Console::writeLine);
    }
}
