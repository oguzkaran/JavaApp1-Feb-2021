/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örnekte callback olarak verilen Lambda ifadelerinin parametrelerine tür yazılmazsa "ambiguity" oluşur.
    Yani hangi metodun çağırlacağına yönelik "en uygun metot (the most applicable method)" bulunamaz
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.StringUtil;

import java.util.Random;

class App {
    public static void main(String[] args)
    {
        Random r = new Random();
        RandomGeneratorUtil.display(r, Integer::sum, 10);
        Console.writeLine("#####################################");
        RandomGeneratorUtil.display(r, (String s1, String s2) -> s1 + s2, 10);
    }
}

class RandomGeneratorUtil {
    public static void display(Random r, IBinaryOperator<String> bos, int n)
    {
        for (int i = 0; i < n; ++i) {
            var s1 = StringUtil.getRandomTextTR(r, 10);
            var s2 = StringUtil.getRandomTextTR(r, 10);
            Console.writeLine("s1 = %s, s2 = %s", s1, s2);
            Console.writeLine(bos.apply(s1, s2));
            Console.writeLine("-------------------");
        }
    }

    public static void display(Random r, IIntBinaryOperator boi, int n)
    {
        for (int i = 0; i < n; ++i) {
            var a = r.nextInt(100);
            var b = r.nextInt(100);

            Console.writeLine("a = %d, b = %d", a, b);
            Console.writeLine(boi.applyAsInt(a, b));
            Console.writeLine("-------------------");
        }
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}

interface IDoubleBinaryOperator {
    double applyAsDouble(double a, double b);
}

interface ILongBinaryOperator {
    long applyAsLong(long a, long b);
}

interface IBinaryOperator<T> {
    T apply(T a, T b);
}
