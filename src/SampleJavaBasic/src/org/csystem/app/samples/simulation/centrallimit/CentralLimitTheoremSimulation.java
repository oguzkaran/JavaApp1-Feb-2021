package org.csystem.app.samples.simulation.centrallimit;

import org.csystem.util.ArrayUtil;

import java.util.Arrays;
import java.util.Random;

public class CentralLimitTheoremSimulation {
    private final int m_max;
    private final int m_sampleCount;
    private final int m_count;
    private final int [] m_counts;
    private final Random m_random;
    private final int m_divisor;

    private double calculateSamplesAverage()
    {
        int sum = 0;

        for (int i = 0; i < m_sampleCount; ++i)
            sum += m_random.nextInt(m_max + 1);

        return (double)sum / m_sampleCount;
    }

    private void start()
    {
        for (int i = 0; i < m_count; ++i) {
            double avg = calculateSamplesAverage();

            ++m_counts[(int)avg / m_divisor];
        }
    }

    public CentralLimitTheoremSimulation(int max, int sampleCount, int count, int n)
    {
        m_max = max;
        m_sampleCount = sampleCount;
        m_count = count;
        m_counts = new int[n];
        m_random = new Random();
        m_divisor = m_max / m_counts.length;
    }

    public int [] getCounts()
    {
        return Arrays.copyOf(m_counts, m_counts.length);
    }

    public void run()
    {
        start();
    }

    public void displayHistogram(int n, char ch)
    {
        ArrayUtil.drawHistogram(m_counts, n, ch);
    }
}
