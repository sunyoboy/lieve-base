package com.lieve.micro;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author sunlijiang
 * @date 2019/7/30
 */
public class LambdaTest {

    @Test
    public void testLambda() {
        List<Integer> list = Lists.newArrayList(1,2);
        list.forEach(System.out::println);
    }
}
