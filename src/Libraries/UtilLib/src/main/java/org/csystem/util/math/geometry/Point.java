/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x;
	public int y;
	
	public Point()
	{	
	}
	
	public Point(int x)
	{
		this.x = x;
	}		
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distance()
	{
		return this.distance(0, 0);
	}
	
	public double distance(Point other)
	{
		return this.distance(other.x, other.y);
	}
	
	public double distance(int x, int y)
	{
		return sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
	}
	
	public void offset(int dxy)
	{
		this.offset(dxy, dxy);
	}
	
	public void offset(int dx, int dy)
	{
		x += dx;
		y += dy;
	}

	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Point))
			return false;

		Point p = (Point)other;

		return p.x == x && p.y == y;
	}

	@Override
	public String toString()
	{
		return String.format("{x : %d, y : %d}", x, y);
	}
}
