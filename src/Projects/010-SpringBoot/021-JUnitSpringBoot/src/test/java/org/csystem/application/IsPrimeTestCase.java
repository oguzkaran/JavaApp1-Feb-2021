package org.csystem.application;

import org.csystem.util.number.NumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IsPrimeTestCase {
    private final DataInfo m_dataInfo;

    private static class DataInfo {
        long val;
        boolean result;

        public DataInfo(long val, boolean result)
        {
            this.val = val;
            this.result = result;
        }
    }


    @Parameterized.Parameters
    public static Collection<DataInfo> collectionTestData() throws IOException
    {
        return Files.newBufferedReader(Path.of("primes.txt"))
                .lines()
                .map(str -> new DataInfo(Long.parseLong(str), true))
                .collect(Collectors.toList());
    }

    public IsPrimeTestCase(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_isPrime()
    {
        var value = m_dataInfo.val;

        assertTrue(String.format("%d must be prime!...", value), NumberUtil.isPrime(value));
    }
}
