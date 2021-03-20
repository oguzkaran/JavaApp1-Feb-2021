package org.csystem.util.bitwise;

import org.csystem.util.Console;

public final class BitwiseUtil {
    private static void writeBits(String bitStr, int bitsLength)
    {
        int lengthOfZeros = bitsLength - bitStr.length();

        Console.writeLine(lengthOfZeros != 0 ? String.format("%0" + lengthOfZeros + "d%s", 0, bitStr) : bitStr);
    }

    private BitwiseUtil()
    {
    }

    public static int clearBit(int val, int k) //k -> [0, 31]
    {
        return val & ~(1 << k);
    }

    public static long clearBit(long val, int k) //k -> [0, 63]
    {
        return val & ~(1L << k);
    }

    public static short clearBit(short val, int k) //k -> [0, 15]
    {
        return (short)(val & ~(1 << k));
    }

    public static byte clearBit(byte val, int k) //k -> [0, 7]
    {
        return (byte)(val & ~(1 << k));
    }

    public static boolean isEven(int val)
    {
        return isClear(val, 0);
    }

    public static boolean isSet(int val, int k)
    {
        return (val & 1 << k) != 0;
    }

    public static boolean isSet(long val, int k)
    {
        return (val & 1L << k) != 0;
    }

    public static boolean isClear(int val, int k)
    {
        return !isSet(val, k);
    }

    public static boolean isClear(long val, int k)
    {
        return !isSet(val, k);
    }

    public static char clearBit(char val, int k) //k -> [0, 15]
    {
        return (char)(val & ~(1 << k));
    }

    public static int setBit(int val, int k) //k -> [0, 31]
    {
        return val | 1 << k;
    }

    public static long setBit(long val, int k) //k -> [0, 63]
    {
        return val | 1L << k;
    }

    public static short setBit(short val, int k) //k -> [0, 15]
    {
        return (short)(val | 1 << k);
    }

    public static byte setBit(byte val, int k) //k -> [0, 7]
    {
        return (byte)(val | 1 << k);
    }

    public static char setBit(char c, int k) //k -> [0, 15]
    {
        return (char)(c | 1 << k);
    }

    public static int toggleBit(int val, int k)
    {
        return val ^ 1 << k;
    }

    public static long toggleBit(long val, int k)
    {
        return val ^ 1L << k;
    }

    public static short toggleBit(short val, int k)
    {
        return (short)(val ^ 1 << k);
    }

    public static byte toggleBit(byte val, int k)
    {
        return (byte)(val ^ 1 << k);
    }

    public static char toggleBit(char val, int k)
    {
        return (char)(val ^ 1 << k);
    }

    public static void writeBits(int val)
    {
        writeBits(Integer.toBinaryString(val), 32);
    }

    public static void writeBits(long val)
    {
        writeBits(Long.toBinaryString(val), 64);
    }

    public static void writeBits(short val)
    {
        writeBits(Integer.toBinaryString(val), 16);
    }

    public static void writeBits(byte val)
    {
        writeBits(Integer.toBinaryString(val), 8);
    }

    public static void writeBits(char val)
    {
        writeBits(Integer.toBinaryString(val), 16);
    }
}
