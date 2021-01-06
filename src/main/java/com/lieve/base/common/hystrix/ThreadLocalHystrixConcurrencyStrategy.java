package com.lieve.base.common.hystrix;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.properties.HystrixProperty;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunlijiang
 * @date 2019/7/31
 */
@Slf4j
public class ThreadLocalHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixProperty<Integer> corePoolSize, HystrixProperty<Integer> maximumPoolSize, HystrixProperty<Integer> keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        return this.getThreadPool(threadPoolKey, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public ThreadPoolExecutor getThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolProperties threadPoolProperties) {
        return super.getThreadPool(threadPoolKey, threadPoolProperties);
    }

    public ThreadLocalThreadPoolExecutor doGetThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                                         BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        return new ThreadLocalThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                threadFactory);
    }
}
