/*----------------------------------------------------------------------------------------------------------------------
	ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public class ArrayUtil {
    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] < a[k])
                    swap(a, k, k + 1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length - 1; ++i)
            for (int k = 0; k < a.length - 1 - i; ++k)
                if (a[k + 1] > a[k])
                    swap(a, k, k + 1);
    }


    private static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] < min) {
                    min = a[k];
                    minIndex = k;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i) {
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k) {
                if (a[k] > max) {
                    max = a[k];
                    maxIndex = k;
                }
            }
            a[maxIndex] = a[i];
            a[i] = max;
        }
    }

    private ArrayUtil()
    {}

    public static void bubbleSort(int [] a)
    {
        bubbleSortAscending(a);
    }

    public static void bubbleSort(int [] a, boolean descending)
    {
        if (descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    public static int [] copyOf(int [] a, int size)
    {
        if (a.length >= size)
            return a;

        int [] result = new int[size];

        for (int i = 0; i < a.length; ++i)
            result[i] = a[i];

        return result;
    }

    public static void display(int... a)
    {
        display(1, a);
    }

    public static void display(int []... a)
    {
        display(1, a);
    }

    public static void display(int n, int... a)
    {
        display(' ', '\n', n, a);
    }

    public static void display(int n, int [][] a)
    {
        for (int [] array : a)
            display(n, array);
    }

    public static void display(char sep, char end, int... a)
    {
        display(sep, end, 1, a);
    }

    public static void display(char sep, char end, int n, int... a)
    {
        String fmt = String.format("%%0%dd%%c", n);

        for (int val : a)
            System.out.printf(fmt, val, sep); //n -> 2 -> "%02d%c"

        System.out.print(end);
    }


    public static void display(String... str)
    {
        for (String s : str)
            System.out.println(s);
    }


    public static void display(char [] c)
    {
        for (char ch : c)
            System.out.println(ch);
    }

    public static void drawHistogram(int [] data, int n, char ch)
    {
        int maxVal = max(data);

        for (int val : data) {
            int nVal = (int)Math.ceil(val * n / (double)maxVal);

            while (nVal-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] counts = new int[n + 1];

        for (int val : a)
            ++counts[val];

        return counts;
    }

    public static void fillArrayRandom(Random r, int [] a, int min, int max)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(max - min) + min;
    }

    public static void fillArrayRandom(int [] a, int min, int max)
    {
        fillArrayRandom(new Random(), a, min, max);
    }

    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        fillArrayRandom(r, a, min, max);

        return a;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }

    public static int [][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int [][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static int [][] getRandomSquareMatrix(int n, int min, int max) //[min, max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static boolean isMatrix(int [][] a)
    {
        int n = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != n)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a[0].length == a.length;
    }

    public static int max(int... a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.max(result, a[i]);

        return result;
    }

    public static int min(int... a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; ++i)
            result = Math.min(result, a[i]);

        return result;
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if (partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if (a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static void reverse(int [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(a, i, a.length - 1 - i);
    }

    public static void reverse(char [] chars)
    {
        int halfLen = chars.length / 2;

        for (int i = 0; i < halfLen; ++i)
            swap(chars, i, chars.length - 1 - i);
    }

    public static void selectionSort(int [] a)
    {
        selectionSortAscending(a);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if (descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static void shuffle(int [] a, int n)
    {
        shuffle(new Random(), a, n);
    }

    public static void shuffle(Random r, int [] a, int n)
    {
        for (int i = 0; i < n; ++i) {
            int firstIndex, secondIndex;

            do {
                firstIndex = r.nextInt(a.length);
                secondIndex = r.nextInt(a.length);
            } while (firstIndex == secondIndex);

            swap(a, firstIndex, secondIndex);
        }
    }

    public static int sum(int... a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sum(int []... a)
    {
        int total = 0;

        for (int [] array : a)
            total += sum(array);

        return total;
    }

    public static int sumDiagonal(int []... a)
    {
        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(char [] a, int i, int k)
    {
        a[i] ^= a[k];
        a[k] ^= a[i];
        a[i] ^= a[k];
    }

    public static void swap(int [] a, int i, int k)
    {
        a[i] ^= a[k];
        a[k] ^= a[i];
        a[i] ^= a[k];
    }

    public static int [][] transpose(int [][] a)
    {
        int m = a.length;
        int n = a[0].length;
        int [][] t = new int[n][m];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}


