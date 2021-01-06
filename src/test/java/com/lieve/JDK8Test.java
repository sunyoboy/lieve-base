package com.lieve;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @author sunlijiang
 * @date 2019/7/18
 */
@Slf4j
public class JDK8Test {

    @Test
    public void testBefore() {

    }

    /**
     * 用() -> {}代码块替代了整个匿名类
     */
    @Test
    public void testLambda() {
        new Thread(() -> System.out.println("Lambda express")).start();
        new Thread(() -> {System.out.println("Lambda express");}).start();
    }

    /**
     * Java 8的方法引用更方便，方法引用由::双冒号操作符标示
     */

    @Test
    public void testForEach() {
        List<Integer> list = Lists.newArrayList(1, 2 ,3);
        list.forEach(i -> System.out.println(i));
    }
}
