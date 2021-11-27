/*----------------------------------------------------------------------------------------------------------------------
    Apache Commons StopWatch sınıfı. Detayları manual'dan inceleyebilirsiniz:
    https://commons.apache.org/proper/commons-lang/
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.apache.commons.lang3.time.StopWatch;
import org.csystem.util.Console;
import org.csystem.util.number.NumberUtil;

import java.math.BigInteger;

class App {
    public static void main(String[] args)
    {
        var stopWatch = new StopWatch();

        stopWatch.start();
        Console.writeLine(NumberUtil.isPrime(6584583408148485263L));
        stopWatch.stop();
        var elapsed = stopWatch.getNanoTime();
        Console.writeLine("Elapsed Time:%f", elapsed / 1_000_000_000.);

        stopWatch.reset();
        stopWatch.start();
        Console.writeLine(NumberUtil.isPrime(BigInteger.valueOf(6584583408148485263L)));
        stopWatch.stop();

        elapsed = stopWatch.getNanoTime();
        Console.writeLine("Elapsed Time:%f", elapsed / 1_000_000_000.);
    }
}

