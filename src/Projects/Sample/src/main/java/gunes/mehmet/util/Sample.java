package gunes.mehmet.util;

import org.csystem.IMyInterface;
import org.csystem.MyAnnotation;

import java.io.*;

@Deprecated
@MyAnnotation("merhaba")
public class Sample implements IMyInterface, Closeable, Cloneable, Externalizable {
    private int m_x;

    protected double val;

    public Sample(int a)
    {

    }

    public Sample()
    {

    }

    public void foo()
    {

    }

    public void bar(int a, double b)
    {

    }

    @Override
    public void tar()
    {

    }

    @Override
    public void close() throws IOException
    {

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {

    }
}
