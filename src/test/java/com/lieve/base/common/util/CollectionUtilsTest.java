package com.lieve.base.common.util;

import com.google.common.collect.Lists;
import com.lieve.base.common.util.CollectionUtils;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @version 1.0
 * @since 2018/11/30 下午3:14
 */
public class CollectionUtilsTest {

    @Test
    public void intList2StringList() {
        List<Integer> integerList = Lists.newArrayList(1,2,3,4);
        List<Integer> integerList1 = Arrays.asList(1,6,7,8);
        List<String> stringList = CollectionUtils.intList2StringList(integerList);
        List<String> stringList1 = CollectionUtils.intList2StringList(integerList1);
        Assert.assertTrue(stringList1.get(0).equals(stringList.get(0)));
        System.out.println();
    }
}