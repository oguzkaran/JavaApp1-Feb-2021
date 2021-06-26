/*----------------------------------------------------------------------------------------------------------------------
    IntRange sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntRange implements Iterable<Integer> {
    private final int m_min;
    private final int m_max;
    private final int m_step;

    public IntRange(int min, int max)
    {
        this(min, max, 1);
    }

    public IntRange(int min, int max, int step)
    {
        if (min > max || step < 1)
            throw new IllegalArgumentException("Invalid Arguments");

        m_min = min;
        m_max = max;
        m_step = step;
    }

    public int getMin()
    {
        return m_min;
    }

    public int getMax()
    {
        return m_max;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            int m_val = m_min - m_step;

            @Override
            public boolean hasNext()
            {
                return m_val + m_step <= m_max;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException("No such value");

                return m_val += m_step;
            }
        };
    }
}
