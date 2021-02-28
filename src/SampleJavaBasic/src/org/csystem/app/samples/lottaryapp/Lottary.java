/*----------------------------------------------------------------------------------------------------------------------
    Lottary sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app.samples.lottaryapp;

import java.util.Random;

public class Lottary {
    private final Random m_random;

    private static int [] getNumbers(boolean [] flags)
    {
        int [] a = new int[6];
        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (flags[i])
                a[index++] = i;

        return a;
    }

    private boolean [] getFlags()
    {
        boolean [] flags = new boolean[50];

        for (int i = 0; i < 6; ++i) {
            int val;

            for (;;) {
                val = m_random.nextInt(49) + 1;
                if (!flags[val])
                    break;
            }
            flags[val] = true;
        }

        return flags;
    }

    public Lottary()
    {
        m_random = new Random();
    }

    public int[] getNumbers()
    {
        return getNumbers(getFlags());
    }

    public int [][] getNumbers(int n)
    {
        int [][] c = new int[n][];

        for (int i = 0; i < n; ++i)
            c[i] = getNumbers();

        return c;
    }
}
