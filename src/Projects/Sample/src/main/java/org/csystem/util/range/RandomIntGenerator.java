/*----------------------------------------------------------------------------------------------------------------------
    RandomIntGenerator sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.range;

import java.util.Iterator;
import java.util.Random;
import java.util.function.IntSupplier;

public class RandomIntGenerator implements Iterable<Integer> {
    public static RandomIntGenerator of(int count, int min, int max)
    {
        return of(new Random(), count, min, max);
    }

    public static RandomIntGenerator of(Random random, int count, int min, int max)
    {
        return of(count, () -> random.nextInt(max - min) + min);
    }

    public static RandomIntGenerator of(int count, IntSupplier intSupplier)
    {
        throw new UnsupportedOperationException();
    }

    //...

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext()
            {
                throw new UnsupportedOperationException();
            }

            @Override
            public Integer next()
            {
                throw new UnsupportedOperationException();
            }
        };
    }
}
