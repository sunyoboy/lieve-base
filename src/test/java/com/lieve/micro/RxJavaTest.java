package com.lieve.micro;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import org.junit.Test;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
public class RxJavaTest {

    @Test
    public void testHelloWorld() {
        Flowable.just("Hello world").subscribe(System.out::println);

        // not lambda
        Flowable.just("Hello").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
    }

    @Test
    public void test1() {
        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(v -> v * v)
                .filter(v -> v % 2 == 0);
        flow.subscribe(System.out::println);

        flow.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println(integer);
            }
        });
    }
}
