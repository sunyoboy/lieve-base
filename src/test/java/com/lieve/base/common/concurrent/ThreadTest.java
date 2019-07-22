package com.lieve.base.common.concurrent;

import org.junit.Test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunlijiang
 * @date 2019/7/7
 */
public class ThreadTest {

    @Test
    public void testExecutor() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 1,
                10, TimeUnit.SECONDS, new LinkedBlockingDeque());
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
    }

    @Test
    public void testT() {
        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(-1 << COUNT_BITS);
        int value = (1 << COUNT_BITS) - 1;
        System.out.println(value);
    }
}