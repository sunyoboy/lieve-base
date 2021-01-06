package com.lieve.micro;

import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

/**
 * @author sunlijiang
 * @date 2019/7/30
 */
public class Producer implements Runnable {

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(1);
            sleep(1000);
            blockingQueue.put(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
