/*----------------------------------------------------------------------------------------------------------------------	
	Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.math;

import static java.lang.Math.*;

public class Complex {
    private static Complex add(double re1, double im1, double re2, double im2)
    {
        return new Complex(re1 + re2, im1 + im2);
    }

    private static Complex subtract(double re1, double im1, double re2, double im2)
    {
        return add(re1, im1, -re2, -im2);
    }

    private static Complex multiply(double re1, double im1, double re2, double im2)
    {
        return new Complex(re1 * re2 - im1 * im2, re1 * im2 + re2 * im1);
    }

    public double re;
    public double im;

    public Complex()
    {
    }

    public Complex(double re)
    {
        this.re = re;
    }

    public Complex(double re, double im)
    {
        this.re = re;
        this.im = im;
    }

    //add methods
    public static Complex add(double val, Complex z)
    {
        return add(val, 0, z.re, z.im);
    }

    public Complex add(Complex other)
    {
        return add(re, im, other.re, other.im);
    }

    public Complex add(double val)
    {
        return add(re, im, val, 0);
    }

    //subtract methods
    public static Complex subtract(double val, Complex z)
    {
        return subtract(val, 0, z.re, z.im);
    }

    public Complex subtract(Complex other)
    {
        return subtract(re, im, other.re, other.im);
    }

    public Complex subtract(double val)
    {
        return subtract(re, im, val, 0);
    }

    //multiply methods
    public static Complex multiply(double val, Complex z)
    {
        return multiply(val, 0, z.re, z.im);
    }

    public Complex multiply(Complex other)
    {
        return multiply(re, im, other.re, other.im);
    }

    public Complex multiply(double val)
    {
        return multiply(re, im, val, 0);
    }

    public Complex getConjugate()
    {
        Complex z = new Complex();

        z.re = re;
        z.im = -im;

        return z;
    }

    public double getNorm()
    {
        return sqrt(re * re + im * im);
    }

    //...

    public double getLength()
    {
        return getNorm();
    }

    public String toString()
    {
        return String.format("|%.2f + i * %.2f|=%f", re, im, getNorm());
    }
}