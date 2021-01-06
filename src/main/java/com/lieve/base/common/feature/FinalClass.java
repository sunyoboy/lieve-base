package com.lieve.base.common.feature;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/11/30 下午5:52
 */

import java.lang.invoke.MethodHandles;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FinalClass {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    private FinalClass() {}

    Function function;

    Supplier supplier;

    Objects objects;

    public static void main(String[] args) {
        while(true) {
            System.out.println();
        }
    }

}
