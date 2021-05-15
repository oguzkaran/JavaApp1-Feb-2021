/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Aşağıda açıklanan Alarm isimli sınıfı yazınız
    Açıklamalar:
    - Sınıfın saat dakika, saniye alan ve LocalTime parametreli iki adet ctor'u yazılacaktır
    - Sınıfın run metodu Ruunable arayüzü ile alarm süresi dolduğu zaman yapılacak işlemi alacaktır
    - Sınıfın ayrıca her saniyede yapacağı işi de alabilen bir run metodu daha olacaktır
    - Sınıfı yazarken Timer veya scheduler kullanabilirsiniz
    - Alarm sınıfını şu senaryo da kullanarak programı yazınız:
        Komut satırı argümanı verilen saat, dakika ve saniye bilgilerine göre zaman dolduğunda "Artık uyan" şeklinde bir
        mesaj veren ve alarmı kapatan zaman gelene kadar ise sürekli ekrana nokta basan programı yazınız
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.scheduler.Alarm;

import java.time.LocalTime;

class App {
    public static void main(String[] args)
    {
        AlarmWithoutSecondApp.run(args);
    }
}

final class AlarmWithoutSecondApp {
    private static LocalTime getLocalTime(String [] args)
    {
        return LocalTime.of(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    private AlarmWithoutSecondApp()
    {
    }

    public static void run(String [] args)
    {
        if (args.length != 3) {
            Console.Error.writeLine("Wrong number of arguments");
            System.exit(-1);
        }

        try {
            var alarm = new Alarm(getLocalTime(args));

            alarm.start(() -> Console.writeLine("\nArtık uyan"), () -> Console.write("."));
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid time values");
        }
    }
}