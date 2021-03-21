/*----------------------------------------------------------------------------------------------------------------------
   Yukarıdaki örneğin Calendar ve GregorianCalendar kullanarak yapılmış biçimi
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Calendar;
import java.util.GregorianCalendar;

class App {
    public static void main(String[] args)
    {
        var month = Console.readInt("Son kullanma tarihi ay bilgisini giriniz:");
        var year = Console.readInt("Son kullanma tarihi yıl bilgisini giriniz:");
        var expiryDate = new GregorianCalendar(year, month - 1, 1);

        expiryDate.set(Calendar.DAY_OF_MONTH, expiryDate.getActualMaximum(Calendar.DAY_OF_MONTH));

        if (new GregorianCalendar().after(expiryDate))
            Console.writeLine("Kartın son kullanma tarihi geçmiştir");
        else
            Console.writeLine("Kartın son kullanma tarihi henüz geçmemiştir");
    }
}
