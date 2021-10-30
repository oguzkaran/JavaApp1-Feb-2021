package org.csystem.util;

import org.csystem.util.string.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetRandomTextTestCase {
    private final DataInfo m_dataInfo;
    private final Random m_random = new Random();

    private static class DataInfo {
        String sourceText;
        int count;

        public DataInfo(String sourceText, int count)
        {
            this.sourceText = sourceText;
            this.count = count;
        }

        public boolean isValid(String text)
        {
            var len = text.length();

            for (int i = 0; i < len; ++i)
                if (!sourceText.contains(text.charAt(i) + ""))
                    return false;

            return true;
        }
    }


    @Parameterized.Parameters
    public static Collection<DataInfo> collectionTestData() throws IOException
    {
        return Files.newBufferedReader(Path.of("sourcetexts.txt"))
                .lines()
                .map(s -> s.split("[ \t]+"))
                .map(str -> new DataInfo(str[0], Integer.parseInt(str[1])))
                .collect(Collectors.toList());
    }

    public GetRandomTextTestCase(DataInfo dataInfo)
    {
        m_dataInfo = dataInfo;
    }

    @Test
    public void test_getRandomText()
    {
        var str = StringUtil.getRandomText(m_random, m_dataInfo.count, m_dataInfo.sourceText);

        assertEquals(m_dataInfo.count, str.length());
        assertTrue(m_dataInfo.isValid(str));
    }
}
