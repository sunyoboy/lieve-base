package com.lieve.base.common.annotation.condition;


import com.lieve.base.common.annotation.ListService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author sunlijiang
 * @date 2019/8/9
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles
@Log
public class ConditionConfigTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

    /*@Resource
    private ListService listService;*/

    @Test
    public void testContext() {
        ListService listService = context.getBean(ListService.class);
        log.info(context.getEnvironment().getProperty("os.name") + " command : " + listService.showListCmd());
    }

    public void closeContext() {
        context.close();
    }

}