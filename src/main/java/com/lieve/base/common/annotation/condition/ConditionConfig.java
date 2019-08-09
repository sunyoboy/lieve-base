package com.lieve.base.common.annotation.condition;

import com.lieve.base.common.annotation.ListService;
import com.lieve.base.common.annotation.LinuxListServiceImpl;
import com.lieve.base.common.annotation.WindowListServieImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunlijiang
 * @date 2019/8/9
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListServiceImpl();
    }

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowListService() {
        return new WindowListServieImpl();
    }
}
