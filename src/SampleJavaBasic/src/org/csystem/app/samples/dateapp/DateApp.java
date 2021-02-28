package org.csystem.app.samples.dateapp;

import org.csystem.util.datetime.Date;

import java.util.Random;

public class DateApp {
    private final Date m_date;

    public DateApp(Random r)
    {
        m_date = Date.of(r, 2021);
    }

    public void display()
    {
        System.out.println(m_date.toLongDateStringTR());

        System.out.println(m_date.isWeekEnd() ? "Hafta sonu geldi kurs var. Tekrar yaptınız mı?!!!" : "Hafta sonu yaklaşıyor. Tekrar yapmayı unutmayınız!!!");
    }
    //...
}