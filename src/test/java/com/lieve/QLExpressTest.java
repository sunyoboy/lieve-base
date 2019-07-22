package com.lieve;

import com.google.common.collect.Lists;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author sunlijiang
 * @date 2019/7/11
 */
public class QLExpressTest {

    @Test
    public void testExpress() throws Exception {
        ExpressRunner runner = new ExpressRunner(true, true);
        /*DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a",1);
        context.put("b",2);
        context.put("c",3);
        String express = "a+b*c";
        Object r = runner.execute(express, context, null, true, false);
        System.out.println(r);*/

        DefaultContext<String, Object> defaultContext = new DefaultContext<>();
        defaultContext.put("a", 0.5D);
        defaultContext.put("b", 7.5D);
        defaultContext.put("c", 7.5D);
        String express1 = "c+a*b";
        Object out = runner.execute(express1, defaultContext, null, false, true );
        System.out.println(out);

    }

    @Test
    public void plus() {
        float a = 0.05f + 0.01f;
        Double b = 1.0D -0.42f;
        Double c = 4.015 * 100;
        float d= 123.3f * 100;

        System.out.println(a + "    " + b + "   " + c + "   " + d);
    }

    @Test
    public void testMacro() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        runner.addMacro("计算平均成绩", "(语文+数学+英语)");
        runner.addMacro("是否优秀", "计算平均成绩>90");
        IExpressContext<String, Object> context = new DefaultContext<>();
        context.put("语文", 88);
        context.put("数学",98);
        context.put("英语",89);
        List<String> errorList = Lists.newArrayList();
        Object result = runner.execute("是否优秀", context, errorList, true, true);
        System.out.println(result);
    }
}
