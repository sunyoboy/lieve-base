package com.lieve.base.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.function.Consumer;

/**
 * @author sunlijiang
 * @date 2019/6/27
 */
@Component
public class TransactionUtil {

    @Autowired
    private PlatformTransactionManager transactionManager;

    public boolean transact(Consumer consumer) {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            consumer.accept(null);

            transactionManager.commit(status);
            return true;
        } catch (Exception e) {
            transactionManager.rollback(status);
            e.printStackTrace();
            return false;
        }


    }
}
