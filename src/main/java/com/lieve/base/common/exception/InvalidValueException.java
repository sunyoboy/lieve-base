package com.lieve.base.common.exception;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/12/10 下午8:00
 */

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidValueException extends Exception {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    private String message;

    public InvalidValueException() {
        super();
    }

    public InvalidValueException(String message) {
        super(message);
    }
}
