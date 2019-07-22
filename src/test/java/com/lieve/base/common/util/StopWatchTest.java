package com.lieve.base.common.util;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @author sunlijiang
 * @date 2019/7/10
 */
public class StopWatchTest {

    @Test
    public void testStopWatch() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start("caculate");
        Thread.sleep(1000);
        stopWatch.stop();

        stopWatch.start("caculate2");
        Thread.sleep(2000);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());;
    }
}
