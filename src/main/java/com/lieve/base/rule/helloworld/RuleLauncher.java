package com.lieve.base.rule.helloworld;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author sunlijiang
 * @date 2019/7/25
 */
public class RuleLauncher {
    public static void main(String[] args) {
        // create facts
        Facts facts = new Facts();

        HelloWorldRule helloWorldRule = new HelloWorldRule(false);
        // create rules
        Rules rules = new Rules();
        rules.register(helloWorldRule);

        // create a rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);
    }
}
