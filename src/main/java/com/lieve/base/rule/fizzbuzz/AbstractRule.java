package com.lieve.base.rule.fizzbuzz;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;

/**
 * abstract class
 * @author sunlijiang
 * @date 2019/7/25
 */
public abstract class AbstractRule {

    @Condition
    public abstract boolean meetTheConditon(Integer number);

    @Action
    public abstract void action(@Fact("number") Integer number);

    @Priority
    public abstract int getPriority();

}
