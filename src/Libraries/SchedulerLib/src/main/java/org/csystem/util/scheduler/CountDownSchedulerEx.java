/*----------------------------------------------------------------------------------------------------------------------
    CountDownSchedulerEx class
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.scheduler;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public abstract class CountDownSchedulerEx extends CountDownScheduler {
    public CountDownSchedulerEx(long millisInFuture, long interval)
    {
        this(millisInFuture, interval, MILLISECONDS);
    }

    public CountDownSchedulerEx(long future, long interval, TimeUnit timeUnit)
    {
        super(future, interval, timeUnit);
    }

    public abstract void onStart();

    public final void startScheduler()
    {
        onStart();
        start();
    }
}
