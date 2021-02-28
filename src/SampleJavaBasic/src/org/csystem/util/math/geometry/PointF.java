/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.sqrt;

public class PointF {
    public float x;
    public float y;

    public PointF()
    {
    }

    public PointF(float x)
    {
        this.x = x;
    }

    public PointF(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public double distance()
    {
        return distance(0, 0);
    }

    public double distance(PointF other)
    {
        return distance(other.x, other.y);
    }

    public double distance(float x, float y) //primary, core
    {
        return sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }

    public void offset(float dxy)
    {
        offset(dxy, dxy);
    }

    public void offset(float dx, float dy)
    {
        x += dx;
        y += dy;
    }

    public String toString()
    {
        return String.format("{x : %f, y : %f}", x, y);
    }
}

