package com.lieve.base.common.hystrix;

import java.util.concurrent.*;

/**
 * @author sunlijiang
 * @date 2019/8/1
 */
public class ThreadLocalThreadPoolExecutor extends ThreadPoolExecutor {

    private static final RejectedExecutionHandler  rejectedExecutionHandler = new AbortPolicy();

    public ThreadLocalThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadLocalThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, rejectedExecutionHandler);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(new TtlRunnable(command, true));
    }
}
