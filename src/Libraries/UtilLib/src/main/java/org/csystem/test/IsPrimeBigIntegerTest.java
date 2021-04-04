package org.csystem.test;

import org.csystem.util.Console;
import org.csystem.util.NumberUtil;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
public class IsPrimeBigIntegerTest {
    private static void run()
    {
        BigInteger hundred = BigInteger.valueOf(100);

        for (BigInteger i = BigInteger.ONE; i.compareTo(hundred) <= 0; i = i.add(ONE))
            if (NumberUtil.isPrime(i))
                Console.write("%s ", i);

        Console.writeLine();
        Console.writeLine(NumberUtil.isPrime(BigInteger.valueOf(1_000_003)) ? "Asal" : "Asal değil");

        var n = new BigInteger("1000010");

        for (BigInteger i = new BigInteger("1000003"); i.compareTo(n) <= 0; i = i.add(ONE))
            if (NumberUtil.isPrime(i))
                Console.writeLine("%s ", i);
    }

    private IsPrimeBigIntegerTest()
    {
    }

    public static void main(String[] args)
    {
        run();
    }
}

