package com.lieve.micro;

import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

/**
 * @author sunlijiang
 * @date 2019/7/30
 */
public class Consumer implements Runnable {

    private BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            Object obj = blockingQueue.take();
            System.out.println(obj);
            sleep(1000);
            Object obj2 = blockingQueue.take();
            System.out.println(obj2);
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
