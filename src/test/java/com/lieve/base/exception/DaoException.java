package com.lieve.base.exception;

/**
 * Created by IntelliJ IDEA.
 * User: sunyoboy@gmail.com
 * Date: 19/1/19
 * Time: 下午2:41
 */
public class DaoException {

    Throwable throwable;
    Exception exception;
    Error error;
    RuntimeException runtimeException;
    NullPointerException nullPointerException;
    ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException;
    OutOfMemoryError outOfMemoryError;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread");
            }
        });
        thread.start();
        // thread.start();
    }
}
