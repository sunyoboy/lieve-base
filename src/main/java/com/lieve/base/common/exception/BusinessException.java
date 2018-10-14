package com.lieve.base.common.exception;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @since 2018/10/13 下午7:59
 */

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessException extends Exception {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }
}
