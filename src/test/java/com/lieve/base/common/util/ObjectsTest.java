package com.lieve.base.common.util;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @since 2018/11/30 下午6:31
 */

import com.google.common.base.Preconditions;
import com.lieve.base.LieveBaseApplication;
import java.lang.invoke.MethodHandles;
import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LieveBaseApplication.class)
public class ObjectsTest {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void checkNull() {
        String str = null;
        Assert.assertTrue(!Objects.nonNull(str));
        str = "abc";
        Assert.assertTrue(!Objects.isNull(str));
        logger.info("where message");
        Assert.assertFalse("check Error",!Objects.isNull(str));
    }

    private boolean notNull(Object obj) {
        return Objects.nonNull(obj);
    }

    @Test
    public void checkState() {
        Preconditions.checkState(notNull("Hello"), "error");
    }
}
