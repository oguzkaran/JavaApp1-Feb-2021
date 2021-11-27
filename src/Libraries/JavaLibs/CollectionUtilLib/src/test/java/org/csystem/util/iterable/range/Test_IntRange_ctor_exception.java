package org.csystem.util.iterable.range;

import org.csystem.util.tuple.IntPair;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class Test_IntRange_ctor_exception {
    private static final Random ms_random = new Random();
    private final IntPair m_pair;

    @Parameterized.Parameters
    public static Collection<IntPair> createData()
    {
        return IntStream.range(0, 10).mapToObj(i -> IntPair.create(ms_random.nextInt(), ms_random.nextInt()))
                .collect(Collectors.toList());
    }

    public Test_IntRange_ctor_exception(IntPair pair)
    {
        m_pair = pair;
    }

    @Before
    public void setUp()
    {

    }

    @After
    public void tearDown()
    {
        //...
    }

    @Test
    public void test_ctor()
    {
        Assert.assertThrows(IllegalArgumentException.class, () -> IntRange.of(m_pair.getFirst(), m_pair.getSecond()));
    }
}
