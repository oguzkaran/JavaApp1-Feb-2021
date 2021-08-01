/*----------------------------------------------------------------------------------------------------------------------
    ... numaralı örnekte n tane rasgele üretilmiş long türden asol sayı elde edilmiştir
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.NumberUtil;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.LongStream;

class App {
    public static void main(String[] args)
    {
       GeneratePrimesApp.run();
    }
}

final class GeneratePrimesApp {
    private GeneratePrimesApp()
    {
    }

    public static void run()
    {
        try (var fos = new FileOutputStream("primes.txt", true)) {
            var r = new Random();
            var gp = new GeneratePrimes(3, r, fos);

            gp.generate();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

enum OutputStatus {TEXT, BINARY}

class GeneratePrimes {
    private long m_count;
    private OutputStream m_outputStream;
    private OutputStatus m_outputStatus;
    private Random m_random;

    private void generateForTextForEachCallback(BufferedWriter bw, long val)
    {
        try {
            bw.write(val + "\r\n");
            bw.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void generateForBinaryForEachCallback(DataOutputStream dos, long val)
    {
        try {
            dos.writeLong(val);
            dos.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void generateForText()
    {
        var bw = new BufferedWriter(new OutputStreamWriter(m_outputStream, StandardCharsets.UTF_8));

        LongStream.generate(m_random::nextLong)
                .filter(NumberUtil::isPrime)
                .limit(m_count)
                .forEach(val -> generateForTextForEachCallback(bw, val));
    }

    private void generateForBinary()
    {
        var dos = new DataOutputStream(m_outputStream);

        LongStream.generate(m_random::nextLong)
                .filter(NumberUtil::isPrime)
                .limit(m_count)
                .forEach(val -> generateForBinaryForEachCallback(dos, val));
    }

    public GeneratePrimes(long count, Random random, OutputStream outputStream)
    {
        this(count, random, outputStream, OutputStatus.TEXT);
    }

    public GeneratePrimes(long count, Random random, OutputStream outputStream, OutputStatus outputStatus)
    {
        m_count = count;
        m_random = random;
        m_outputStream = outputStream;
        m_outputStatus = outputStatus;
    }

    //...

    public void generate()
    {
        if (m_outputStatus == OutputStatus.BINARY)
            generateForBinary();
        else
            generateForText();
    }
}
