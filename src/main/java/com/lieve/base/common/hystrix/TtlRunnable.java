package com.lieve.base.common.hystrix;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.security.PrivateKey;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author sunlijiang
 * @date 2019/8/2
 */
public class TtlRunnable implements Runnable {

    private AtomicReference copiedRef;

    private Runnable runnable;

    private boolean releaseTtlValueReferenceAfterRun;

    @Override
    public void run() {
 /*       Map<TransmittableThreadLocal<?>, Object> copied = copiedRef.get();
        if (copied == null || releaseTtlValueReferenceAfterRun && !copiedRef.compareAndSet(copied, null)) {
            throw new IllegalStateException("TTL value reference is released after run!");
        }

        Map<TransmittableThreadLocal<?>, Object> backup = TransmittableThreadLocal.backupAndSetToCopied(copied);
        try {
            runnable.run();
        } finally {
            TransmittableThreadLocal.restoreBackup(backup);
        }*/
    }

    public TtlRunnable(Runnable runnable, boolean releaseTtlValueReferenceAfterRun) {
        // this.copiedRef = new AtomicReference<Map<TransmittableThreadLocal<?>, Object>>(TransmittableThreadLocal.copy());
        this.runnable = runnable;
        this.releaseTtlValueReferenceAfterRun = releaseTtlValueReferenceAfterRun;
    }
}
