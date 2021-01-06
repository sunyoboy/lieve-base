package com.lieve.base.rule.fizzbuzz;

import org.jeasy.rules.annotation.*;

/**
 * @author sunlijiang
 * @date 2019/7/25
 */
@Rule
public class NonFizzBuzzRule extends AbstractRule {

    @Condition
    @Override
    public boolean meetTheConditon(@Fact("number") Integer number) {
        return number % 5 != 0 && number % 7 != 0;
    }

    @Action
    @Override
    public void action(@Fact("number") Integer number) {
        System.out.println(number);
    }

    @Priority
    @Override
    public int getPriority() {
        return 3;
    }
}
