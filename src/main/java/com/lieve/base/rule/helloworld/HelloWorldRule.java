package com.lieve.base.rule.helloworld;

import lombok.Getter;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

/**
 * @author sunlijiang
 * @date 2019/7/25
 */
@Rule(name = "use engine rule")
public class HelloWorldRule {

    @Getter
    private boolean result;

    public HelloWorldRule(boolean result) {
        this.result = result;
    }

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then() {
        this.result = true;
        System.out.println("Hello World");
    }

}
