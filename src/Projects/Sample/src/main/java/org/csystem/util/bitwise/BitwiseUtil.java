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
