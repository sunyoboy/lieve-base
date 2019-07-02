package com.lieve.base.common.exception;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/10/13 下午7:59
 */

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BizException extends RuntimeException {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    public BizException(String message) {
        super(message);
    }

    public BizException(Throwable throwable) {
        super(throwable);
    }
}
