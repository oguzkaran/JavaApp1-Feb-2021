/*----------------------------------------------------------------------------------------------------------------------
    Yukarıdaki kod anonim sınıf kullanılmadan aşağıdaki gibi de yapılabilir. Anonim sınıfta yakalanan yerel değişkenin
    aşağıdaki örnekte nesne yaratılırken verildiğine dikkat ediniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

class App {
    public static void main(String[] args)
    {
        var timer = new Timer();
        var message = Console.read("Bir yazı giriniz:");

        timer.schedule(new MyTimerTask(message), 0, 1000);
    }
}

class MyTimerTask extends TimerTask {
    private final String m_message;

    public MyTimerTask(String message)
    {
        m_message = message;
    }

    public void run()
    {
        var now = LocalDateTime.now();

        Console.write("%s:%s\r", m_message, DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss").format(now));
    }
}

