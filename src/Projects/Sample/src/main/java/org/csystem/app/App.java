/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: CountDownScheduler sınıfını genişletecek şekilde başlangıçta da bir işin yapılabilmesini
    sağlayan onStart abstract metodunun eklendiği CountDownSchedulerEx isimli sınıfı yazınız ve test ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;
import org.csystem.util.scheduler.CountDownSchedulerEx;

import java.util.concurrent.TimeUnit;

class App {
    public static void main(String[] args)
    {
        CountDownSchedulerTest.run();
    }
}

final class CountDownSchedulerTest {
    private CountDownSchedulerTest()
    {
    }
    public static void run()
    {
        var scheduler = new CountDownSchedulerEx(10, 1, TimeUnit.SECONDS) {
            private int m_count;

            public void onStart()
            {
                Console.writeLine("Geri sayım başladı:");
            }

            public void onTick(long millisUntilFinished)
            {
                ++m_count;
                Console.write("%02d\r", millisUntilFinished / 1000);
            }

            public void onFinish()
            {
                Console.writeLine("00");
                Console.writeLine("Count:%d", m_count);
                Console.writeLine("Geri sayım tamamlandı");
            }
        };

        scheduler.startScheduler();
    }
}
