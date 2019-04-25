package com.lieve.base.common.learning;

public class Deadlock extends Thread {


    public static void main(String[] args) {
        Deadlock deadlockA = new Deadlock(false);
        Deadlock deadlockB = new Deadlock(true);
        deadlockA.start();
        deadlockB.start();
    }

    private static final Object objectA = new Object();
    private static final Object objectB = new Object();

    private boolean flag;

    Deadlock(boolean flag) {
        this.flag = flag;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        if (flag) {
            synchronized (objectA) {
                System.out.println(Thread.currentThread().getName() + "get lock objectA");
                synchronized (objectB) {
                    System.out.println(Thread.currentThread().getName() + "get lock objectB");
                }
            }
        } else {
            synchronized (objectB) {
                System.out.println(Thread.currentThread().getName() + "get lock objectB");
                synchronized (objectA) {
                    System.out.println(Thread.currentThread().getName() + "get lock objectA");
                }
            }
        }
    }
}
