/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.collection;

public class CSDArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] m_elems;
    private int m_index;

    private static void doWorkForIllegalArgumentException(String message)
    {
        System.out.println(message);
        System.exit(-1); //exception işlemleri konusuna kadar sabredin
    }

    private static void doWorkForIndexOutOfException(String message)
    {
        System.out.println(message);
        System.exit(-1); //exception işlemleri konusuna kadar sabredin
    }

    private void checkForIndex(int index)
    {
        if (index < 0 || index >= m_index)
            doWorkForIndexOutOfException("Index Out of bounds");
    }

    private void checkCapacityValue(int capacity)
    {
        if (capacity < 0)
            doWorkForIllegalArgumentException("Capacity can not be negative");
    }

    private void changeCapacity(int capacity)
    {
        Object [] temp = new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }

    public CSDArrayList()
    {
        m_elems = new Object[DEFAULT_CAPACITY];
    }

    public CSDArrayList(int initialCapacity)
    {
        this.checkCapacityValue(initialCapacity);
        m_elems = new Object[initialCapacity];
    }

    public boolean add(Object elem)
    {
        if (m_index == m_elems.length)
            this.changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, Object elem)
    {
        //...
        if (m_index == m_elems.length)
            this.changeCapacity(m_elems.length == 0 ? 1 : m_elems.length * 2);

        //TODO:
    }

    public int capacity()
    {
        return m_elems.length;
    }

    public void clear()
    {
        for (int i = 0; i < m_index; ++i) //Dikkat bu yapılmazsa bellek sızıntısı (memory leak) oluşabilir
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity <= m_elems.length)
            return;

        this.changeCapacity(Math.max(minCapacity, m_elems.length * 2));
    }

    public Object get(int index)
    {
        this.checkForIndex(index);

        return m_elems[index];
    }

    public Object remove(int index)
    {
        Object oldElem = m_elems[index];

        //TODO:

        return oldElem;
    }

    public Object set(int index, Object elem)
    {
        this.checkForIndex(index);
        Object oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public int size()
    {
        return m_index;
    }

    public void trimToSize()
    {
        this.changeCapacity(m_index);
    }
}
