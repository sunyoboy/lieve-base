package com.lieve.base.rule.helloworld;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

/**
 * @author sunlijiang
 * @date 2019/7/25
 */
@Rule(name = "use engine rule")
public class HelloWorldRule {

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then() {
        System.out.println("Hello World");
    }

}
