/*----------------------------------------------------------------------------------------------------------------------
	Circle sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

public class Circle {
    private double m_r;

    public Circle()
    {
    }

    public Circle(double r)
    {
        setRadius(r);
    }

    public Circle(double r, double pi)
    {
        setRadius(r, pi);
    }

    public double getRadius()
    {
        return m_r;
    }

    public void setRadius(double r)
    {
        setRadius(r, Math.PI);
    }

    public void setRadius(double r, double pi)
    {
        m_r = Math.abs(r);
    }

    public double getArea()
    {
        return Math.PI * m_r * m_r;
    }

    public double getCircumference()
    {
        return 2 * Math.PI * m_r;
    }
}
