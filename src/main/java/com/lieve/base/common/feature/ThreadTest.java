package com.lieve.base.common.feature;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sunlijiang
 * @date 2019/8/2
 */
@Slf4j
public class ThreadTest implements Runnable {

    public static InheritableThreadLocal<String> local = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        local.set("main");
        log.info(local.get());
        Thread thread = new Thread(new ThreadTest());
        thread.start();
    }

    @Override
    public void run() {
        log.info(local.get());
    }
}
