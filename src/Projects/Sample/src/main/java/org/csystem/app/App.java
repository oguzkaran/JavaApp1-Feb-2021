/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Klavyeden sıfır girilene kadar alınan BigDecimal sayıların en büyüğünü, en küçüğünü ve toplamlarını
    hesaplayan programı yazınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.math.BigDecimal;

class App {
    public static void main(String[] args)
    {
        FindMaxMinTotalApp.run();
    }
}

class FindMaxMinTotalApp {
    private FindMaxMinTotalApp()
    {
    }

    private static void calculate(BigDecimal initial)
    {
        var min = initial;
        var max = initial;
        var sum = initial;

        for (;;) {
            var val = Console.readBigDecimal("Bir sayı giriniz:");
            if (val.equals(BigDecimal.ZERO))
                break;

            if (val.compareTo(min) < 0)
                min = val;

            if (max.compareTo(val) < 0)
                max = val;

            sum = sum.add(val);
        }

        Console.writeLine("En küçük sayı:%s", min);
        Console.writeLine("En büyük sayı:%s", max);
        Console.writeLine("Toplam:%s", sum);
    }
    public static void run()
    {
        var val = Console.readBigDecimal("Bir sayı giriniz:");

        if (!val.equals(BigDecimal.ZERO))
            calculate(val);
        else
            Console.writeLine("Hiç sayı girilmedi");


    }
}
