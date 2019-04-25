package com.lieve.base.common.util;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @since 2018/12/13 下午8:58
 */

import com.google.common.annotations.VisibleForTesting;
import java.lang.invoke.MethodHandles;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EffectiveUtils {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    public void random() {

    }

    public static void main(String[] args) {
        Random random = new Random();
        int randomIntValue = random.nextInt(10);
        System.out.println(randomIntValue);
    }
}
