/*----------------------------------------------------------------------------------------------------------------------
    Unit sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class Unit<T> {
    private final T m_t;

    public static <T> Unit<T> of(T t)
    {
        return new Unit<>(t);
    }

    public Unit(T t)
    {
        m_t = t;
    }

    public T get()
    {
        return m_t;
    }

    //...

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Unit))
            return false;

        return m_t.equals(((Unit<T>)obj).m_t);
    }

    @Override
    public String toString()
    {
        return String.format("{value: %s}", m_t);
    }
}
