package org.csystem.app.samples.simulation.randomobjectgenerator;

import org.csystem.util.ArrayUtil;
import org.csystem.util.StringUtil;
import org.csystem.util.datetime.Date;
import org.csystem.util.datetime.Time;

import java.util.Random;

public class RandomObjectArrayGenerator {
    private final Random m_random;
    private final Object [] m_objects;

    private Object getRandomObject()
    {
        //String, Integer, Date, Time, Double, Character, int[]
        int val = m_random.nextInt(7);

        Object object;

        switch (val) {
            case 0:
                object = m_random.nextInt(256) - 128;
                break;
            case 1:
                object = StringUtil.getRandomTextTR(m_random, m_random.nextInt(20) + 1);
                break;
            case 2:
                object = Date.of(m_random, 2021);
                break;
            case 3:
                object = Time.of(m_random);
                break;
            case 4:
                object = m_random.nextDouble();
                break;
            case 5:
                object = (char)(m_random.nextInt('Z' - 'A' + 1) + 'A');
                break;
            default:
                object = ArrayUtil.getRandomArray(m_random, 10, 1, 100);
        }

        return object;
    }

    public RandomObjectArrayGenerator(int n)
    {
        m_random = new Random();
        m_objects = new Object[n];
    }

    public Object [] getObjects()
    {
        return m_objects;
    }

    public void run()
    {
        for (int i = 0; i < m_objects.length; ++i)
            m_objects[i] = getRandomObject();
    }
}
