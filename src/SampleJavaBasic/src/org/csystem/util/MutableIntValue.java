package org.csystem.util;

public class MutableIntValue {
    private int m_val;

    public MutableIntValue(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    public MutableIntValue setVal(int val)
    {
        m_val = val;

        return this;
    }

    public MutableIntValue add(int val)
    {
        m_val += val;

        return this;
    }

    public MutableIntValue subtract(int val)
    {
        add(-val);

        return this;
    }

    public MutableIntValue multiply(int val)
    {
        m_val *= val;

        return this;
    }
    //...
}
