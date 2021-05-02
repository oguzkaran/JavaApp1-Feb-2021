/*----------------------------------------------------------------------------------------------------------------------
    assert deyiminin mesaj kısmı.
    Not: trimToSize metodunda enlargaCapacity çağrılarını değiştirerek sonucu gözlemleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDateTime;
import java.util.Arrays;

class App {
    public static void main(String[] args)
    {
        IntList list = new IntList(5);

        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());

        for (int i = 0; i < 11; ++i)
            list.add(i * 10);

        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());

        list.trimToSize();

        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());

        list.clear();

        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());

        list.trimToSize();

        Console.writeLine("Size:%d", list.size());
        Console.writeLine("Capacity:%d", list.capacity());

        list.add(10);
    }
}

class IntList {
    private int [] m_elems;
    private int m_index;

    //...
    private void enlargeCapacity(int newCapacity)
    {
        assert newCapacity != 0: LocalDateTime.now();
        assert newCapacity >= m_index: newCapacity;
        m_elems = Arrays.copyOf(m_elems, newCapacity);
    }

    public IntList(int capacity)
    {
        m_elems = new int[capacity];
    }

    public void add(int val)
    {
        if (m_elems.length == m_index)
            enlargeCapacity(m_elems.length * 2);

        m_elems[m_index++] = val;
    }

    public int get(int index)
    {
        if (index < 0 || index >= m_index)
            throw new IndexOutOfBoundsException("invalid index");

        return m_elems[index];
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        m_index = 0;
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        enlargeCapacity(m_index);
        //enlargeCapacity(m_index == 0 ? 1 : m_index);
    }
}


