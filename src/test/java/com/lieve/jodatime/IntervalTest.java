package com.lieve.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author sunlijiang
 * @date 2019/7/3
 */
public class IntervalTest {

    /**
     * 判断特定日期是否在区间内
     */
    @Test
    public void testInterval() {
        DateTime begin = new DateTime("2019-07-01");
        DateTime end = new DateTime("2019-07-03");

        Interval interval = new Interval(begin, end);
        boolean contained = interval.contains(new DateTime("2019-07-02"));
        Assert.assertTrue(contained);

        begin = DateTime.now().minusDays(1);
        end = DateTime.now().plusDays(1);
        contained = interval.contains(DateTime.now());
        Duration duration = new Duration(begin, end);
        System.out.println(duration.getMillis());
        System.out.println(duration.getStandardDays());
        System.out.println(duration.getStandardHours());
        System.out.println(duration.getStandardMinutes());
        System.out.println(duration.getStandardSeconds());
    }

    /**
     * 计算区间天数
     */
}
