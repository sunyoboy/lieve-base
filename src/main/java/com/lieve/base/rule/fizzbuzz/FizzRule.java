package com.lieve.base.rule.fizzbuzz;

import org.jeasy.rules.annotation.*;

/**
 * @author sunlijiang
 * @date 2019/7/25
 */
@Rule
public class FizzRule extends AbstractRule {

    @Condition
    @Override
    public boolean meetTheConditon(@Fact("number") Integer number) {
        return number % 5 == 0;
    }

    @Action
    @Override
    public void action(@Fact("number") Integer number) {
        System.out.println("fizz");
    }

    @Priority
    @Override
    public int getPriority() {
        return 1;
    }
}
