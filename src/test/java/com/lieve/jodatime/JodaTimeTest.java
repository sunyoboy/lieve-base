package com.lieve.jodatime;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * @author sunlijiang
 * @date 2019/7/2
 */
public class JodaTimeTest {

    @Test
    public void testJodaTime() {
        DateTime dateTime = DateTime.now();
        System.out.println(dateTime);

        DateTime date = DateTime.parse("2019-06-02", DateTimeFormat.forPattern("yyyy-MM-dd"));
        System.out.println(date);

        LocalDate begin = new LocalDate();
        LocalDate end = new LocalDate().minusDays(1);
        System.out.println(dateTime.getCenturyOfEra());
        System.out.println(dateTime.getYearOfCentury());
        System.out.println(date.getWeekyear());
        System.out.println(dateTime.monthOfYear().getAsText());
        System.out.println(Days.daysBetween(begin, end).getDays());
        Years.yearsBetween(begin, end);
        Weeks.weeksBetween(begin,end );
        Seconds.secondsBetween(begin, end);
        Months.monthsBetween(begin, end);
        Minutes.minutesBetween(begin, end);
        Hours.hoursBetween(begin, end);
    }
}
