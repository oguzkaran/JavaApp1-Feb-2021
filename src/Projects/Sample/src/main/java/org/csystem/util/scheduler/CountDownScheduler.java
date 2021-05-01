package org.csystem.util.scheduler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public abstract class CountDownScheduler {
    private final Timer m_timer;
    private final long m_millisInFuture;
    private final long m_interval;
    private final TimerTask m_timerTask;

    private TimerTask createTimerTask()
    {
        return new TimerTask() {
            private long m_value;

            public void run()
            {
                var millisUntilFinished = m_millisInFuture - m_value;

                onTick(millisUntilFinished);
                m_value += m_interval;
                if (m_value < m_millisInFuture)
                    return;

                onFinish();
                m_timer.cancel();
            }
        };
    }

    public CountDownScheduler(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, MILLISECONDS);
    }

    public CountDownScheduler(long future, long interval, TimeUnit timeUnit)
    {
        m_millisInFuture = timeUnit != MILLISECONDS ? MILLISECONDS.convert(future, timeUnit) : future;
        m_interval = timeUnit != MILLISECONDS ? MILLISECONDS.convert(interval, timeUnit) : interval;
        m_timer = new Timer();
        m_timerTask = this.createTimerTask();
    }

    public abstract void onTick(long millisUntilFinished);
    public abstract void onFinish();

    public final void start()
    {
        m_timer.schedule(m_timerTask, 0, m_interval);
    }

    public final void cancel()
    {
        m_timer.cancel();
    }
}
