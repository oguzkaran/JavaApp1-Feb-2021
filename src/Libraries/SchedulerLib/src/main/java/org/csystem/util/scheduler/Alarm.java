/*----------------------------------------------------------------------------------------------------------------------
    Alarm class
---------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public final class Alarm {
    private final Scheduler m_scheduler;
    private final LocalTime m_time;

    private void schedulerTask(Runnable periodTask)
    {
        if (periodTask != null)
            periodTask.run();

        LocalTime now = LocalTime.now();

        now = now.withNano(0);

        if (m_time.equals(now))
            m_scheduler.cancel();
    }

    public Alarm(int hour, int minute)
    {
        this(hour, minute, 0);
    }

    public Alarm(LocalTime time)
    {
        m_time = time;
        m_scheduler = new Scheduler(1, TimeUnit.SECONDS);
    }

    public Alarm(int hour, int minute, int second)
    {
        this(LocalTime.of(hour, minute, second));
    }

    public void start(Runnable alarmTask)
    {
        start(alarmTask, null);
    }

    public void start(Runnable alarmTask, Runnable periodTask)
    {
        m_scheduler.schedule(() -> schedulerTask(periodTask), alarmTask);
    }
}
