package org.csystem.application.randomgenerator.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class RandomPasswordGeneratorConfig {
    private final FileOutputStream m_fileOutputStream1;
    private final FileOutputStream m_fileOutputStream2;

    private void runForFirstCallback() throws InterruptedException, IOException
    {
        var dos = new DataOutputStream(m_fileOutputStream1);

        for (int i = 0; i < m_count; ++i) {
            dos.writeUTF(i + "");
            Thread.sleep(1000);
        }
    }

    private void runForSecondCallback() throws InterruptedException, IOException
    {
        var dos = new DataOutputStream(m_fileOutputStream2);

        for (int i = 0; i < m_count; ++i) {
            dos.writeUTF(i + "");
            Thread.sleep(1000);
        }
    }

    public RandomPasswordGeneratorConfig(@Qualifier("first") FileOutputStream fileOutputStream1,
                                         @Qualifier("second") FileOutputStream fileOutputStream2)
    {
        m_fileOutputStream1 = fileOutputStream1;
        m_fileOutputStream2 = fileOutputStream2;
    }

    @Value("${count}")
    private int m_count;

    @Value("${timeout}")
    private long timeout;

    @Bean
    public ApplicationRunner runForFirstFile()
    {
        return args -> runForFirstCallback();
    }

    @Bean
    public ApplicationRunner runForSecondFile()
    {
        return args -> runForSecondCallback();
    }
}

