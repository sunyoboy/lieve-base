package com.lieve.base.common.annotation;

import com.lieve.base.common.annotation.condition.ConditionConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author sunlijiang
 * @date 2019/5/15
 */
public class AnnotationTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

    /*@Resource
    private ListService listService;*/

    @Test
    public void testContext() {
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name") + " command : " + listService.showListCmd());
    }
}
