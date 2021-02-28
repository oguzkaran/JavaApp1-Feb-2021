/*----------------------------------------------------------------------------------------------------------------------
	Date sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.util.Random;

public class Date {
    private static final String [] DAYS_OF_WEEK_TR;
    private static final String [] DAYS_OF_WEEK_EN;
    private static final String [] MONTHS_TR;
    private static final String [] MONTHS_EN;
    private static final Month [] MONTHS;
    private static final DayOfWeek [] DAY_OF_WEEKS;

    static {
        DAYS_OF_WEEK_TR = new String[]{"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
        DAYS_OF_WEEK_EN = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        MONTHS_TR = new String[]{"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
        MONTHS_EN = new String[]{"", "Jan", "Feb", "Mar", "Apr", "May", "JUn", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        MONTHS = Month.values();
        DAY_OF_WEEKS = DayOfWeek.values();
    }

    private int m_day;
    private int m_month;
    private int m_year;
    private int m_dayOfWeek;

    private static int getDayOfWeek(int day, int month, int year)
    {
        int totalDays;

        totalDays = getDayOfYear(day, month, year);

        for (int y = 1900; y < year; ++y)
            totalDays += Month.isLeapYear(y) ? 366 : 365;

        return totalDays % 7;
    }

    private static int getDayOfYear(int day, int month, int year)
    {
        int dayOfYear = day;

        for (int m = month - 1; m >= 1; --m)
            dayOfYear += getDays(m, year);

        return dayOfYear;
    }

    private static boolean isValidDate(int day, int month, int year)
    {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900)
            return false;

        return day <= getDays(month, year);
    }

    private static int getDays(int month, int year)
    {
        return MONTHS[month - 1].getDays(year);
    }

    private static void doWorkForException(String message)
    {
        System.out.println(message);
        System.exit(0); //Exception konusuna kadar sabredin
    }

    private static void checkForDate(int day, int month, int year, String message)
    {
        if (!isValidDate(day, month, year))
            doWorkForException(message);
    }

    private void checkForDay(int val)
    {
        checkForDate(val, m_month, m_year, "Invalid day value");
    }

    private void checkForMonth(int val)
    {
        checkForDate(m_day, val, m_year, "Invalid month value");
    }

    private void checkForYear(int val)
    {
        checkForDate(m_day, m_month, val, "Invalid year value");
    }

    private void set(int day, int monthValue, int year)
    {
        m_day = day;
        m_month = monthValue;
        m_year = year;
        m_dayOfWeek = getDayOfWeek(m_day, m_month, m_year);
    }

    private String getDaySuffix()
    {
        String suffix;

        switch (m_day) {
            case 1:
            case 21:
            case 31:
                suffix = "st";
                break;
            case 2:
            case 22:
                suffix = "nd";
                break;
            case 3:
            case 23:
                suffix = "rd";
                break;
            default:
                suffix = "th";
        }

        return suffix;
    }

    public static Date of(int year)
    {
        return of(new Random(), year);
    }

    public static Date of(Random r, int year)
    {
        return of(r, year, year);
    }

    public static Date of(int minYear, int maxYear)
    {
        return of(new Random(), minYear, maxYear);
    }

    public static Date of(Random r, int minYear, int maxYear) //[minYear, maxYear]
    {
        int year = r.nextInt(maxYear - minYear + 1) + minYear;
        int month = r.nextInt(12) + 1;
        int day = r.nextInt(getDays(month, year)) + 1;

        return new Date(day, month, year);
    }

    //...

    public Date(int day, int monthValue, int year)
    {
        checkForDate(day, monthValue, year, "Invalid date values");
        set(day, monthValue, year);
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }

    public int getDay()
    {
        return m_day;
    }

    public void setDay(int day)
    {
        if (day == m_day)
            return;

        checkForDay(day);
        set(day, m_month, m_year);
    }

    public int getMonthValue()
    {
        return m_month;
    }

    public Month getMonth() {return MONTHS[m_month - 1];}

    public void setMonth(Month month)
    {
        setMonthValue(month.ordinal() + 1);
    }

    public void setMonthValue(int monthValue)
    {
        if (monthValue == m_month)
            return;

        checkForMonth(monthValue);
        set(m_day, monthValue, m_year);
    }

    public int getYear()
    {
        return m_year;
    }

    public void setYear(int year)
    {
        if (year == m_year)
            return;

        checkForYear(year);
        set(m_day, m_month, year);
    }

    public int getDayOfWeekValue()
    {
        return m_dayOfWeek;
    }

    public DayOfWeek getDayOfWeek()
    {
        return DAY_OF_WEEKS[m_dayOfWeek];
    }

    public String getDayOfWeekTR()
    {
        return DAYS_OF_WEEK_TR[m_dayOfWeek];
    }

    public String getDayOfWeekEN()
    {
        return DAYS_OF_WEEK_EN[m_dayOfWeek];
    }

    public boolean isLeapYear() {return Month.isLeapYear(m_year);}

    public boolean isWeekDay()
    {
        return !isWeekEnd();
    }

    public boolean isWeekEnd()
    {
        return m_dayOfWeek == 0 || m_dayOfWeek == 6;
    }

    public String toString()
    {
        return toString('/');
    }

    public String toString(char delimiter)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delimiter, m_month, delimiter, m_year);
    }

    public String toStringTR()
    {
        return String.format("%d %s %d", m_day, MONTHS_TR[m_month], m_year);
    }

    public String toStringEN()
    {
        return String.format("%d%s %s %d", m_day,getDaySuffix(), MONTHS_EN[m_month], m_year);
    }

    public String toLongDateStringTR()
    {
        return String.format("%s %s", toStringTR(), getDayOfWeekTR());
    }

    public String toLongDateStringEN()
    {
        return String.format("%s %s", toStringEN(), getDayOfWeekEN());
    }
}
