package org.csystem.application.dependencyinjection.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

@Component
public class DateTime {
    private final Temporal m_date;
    private final Temporal m_time;

    public DateTime(@Qualifier("today") Temporal date, @Qualifier("timeNow") Temporal time)
    {
        m_date = date;
        m_time = time;
    }

    public String toDateString()
    {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(m_date);
    }

    public String toTimeString()
    {
        return DateTimeFormatter.ofPattern("hh:mm:ss").format(m_time);
    }

    //...

    @Override
    public String toString()
    {
        return toDateString() + " " + toTimeString();
    }
}
