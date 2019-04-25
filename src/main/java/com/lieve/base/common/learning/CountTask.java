package com.lieve.base.common.learning;

import java.util.concurrent.*;

public class CountTask implements Callable<Integer> {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(4);
        CountTask countTask = null;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<Integer>(executorService);
        for (int i = 0; i < 10; i++) {
            countTask = new CountTask(latch, 0 + i * 10, i * 10 + 10);
            executorCompletionService.submit(countTask);
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            latch.countDown();
            Future<Integer> result = executorCompletionService.take();
            sum += result.get();
        }
        System.out.println(sum);
        executorService.shutdown();
    }

    private CountDownLatch countDownLatch;

    private int begin;

    private int end;

    public CountTask(CountDownLatch countDownLatch, int begin, int end) {
        System.out.println(Thread.currentThread().getName() + " " + begin + " " + end);
        this.countDownLatch = countDownLatch;
        this.begin = begin;
        this.end = end;
    }

    private Integer sum = 0;

    @Override
    public Integer call() {
        return count(begin, end);
    }

    private Integer count(int begin, int end) {
        for (; begin < end; begin++) {
            sum += begin;
        }
        countDownLatch.countDown();
        return sum;
    }
}
