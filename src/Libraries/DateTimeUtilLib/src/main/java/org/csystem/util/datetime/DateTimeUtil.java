/*----------------------------------------------------------------------
    FILE        : DateTimeUtil.java
    AUTHOR      : Oğuz Karan
    LAST UPDATE : 28.03.2021

    Utility class for date-time operations

    Copyleft (c) 1993 by C and System Programmers Association (CSD)
    All Rights Free
-----------------------------------------------------------------------*/
package org.csystem.util.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public final class DateTimeUtil {
    private static final int [] DAYS_OF_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 32};

    private static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private DateTimeUtil() {}

    public static final DateTimeFormatter DATE_TR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter DATE_DOT_TR = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter DATE_HYPHEN_TR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate randomLocalDate(Random r, int minYear, int maxYear)
    {
        int year = r.nextInt(maxYear - minYear) + minYear;
        int month = r.nextInt(12) + 1;
        int day = r.nextInt(month == 2 && isLeapYear(year) ? 29 : DAYS_OF_MONTHS[month]) + 1;

        return LocalDate.of(year, month, day);
    }

    public static LocalTime randomLocalTime(Random r)
    {
        int hour = r.nextInt(24);
        int minute = r.nextInt(60);
        int second = r.nextInt(60);

        return LocalTime.of(hour, minute, second);
    }

    public static LocalDateTime randomLocalDateTime(Random r, int minYear, int maxYear)
    {
        return randomLocalDate(r, minYear, maxYear).atTime(randomLocalTime(r));
    }

    public static long toMilliseconds(LocalDateTime localDateTime)
    {
        return toMilliseconds(localDateTime, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDateTime localDateTime, ZoneId zoneId)
    {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime toLocalDateTime(long milliseconds)
    {
        return toLocalDateTime(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDateTime();
    }

    public static long toMilliseconds(LocalDate localDate)
    {
        return toMilliseconds(localDate, ZoneId.systemDefault());
    }

    public static long toMilliseconds(LocalDate localDate, ZoneId zoneId)
    {
        return localDate.atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDate toLocalDate(long milliseconds)
    {
        return toLocalDate(milliseconds, ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(long milliseconds, ZoneId zoneId)
    {
        return Instant.ofEpochMilli(milliseconds).atZone(zoneId).toLocalDate();
    }
}
