package com.lieve.base.common.util;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @since 2018/11/30 下午3:09
 */

import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import java.lang.invoke.MethodHandles;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CollectionUtils {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    public static List<String> intList2StringList(List<Integer> integerList) {
        return Lists.transform(integerList, Functions.toStringFunction());
    }

}
