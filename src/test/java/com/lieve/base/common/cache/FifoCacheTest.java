package com.lieve.base.common.cache;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.FifoCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.junit.Test;

/**
 * @author sunlijiang
 * @date 2019/7/5
 */
public class FifoCacheTest {

    @Test
    public void testFifoCache() {
        Cache cache = new PerpetualCache("default");
        FifoCache fifoCache = new FifoCache(cache);
        final int N = 100000;
        for (int i = 1; i < N; i++) {
            fifoCache.putObject(i,i);
            System.out.println(fifoCache.getSize() + "  " + fifoCache.getId() + "   " + fifoCache.getObject(i));
            if (i % 1024 == 0) {
                System.out.println();
            }
        }
    }

    @Test
    public void testGc() {
        String s;
        System.gc();
        char ch = ' ';
        int a = ch;
        System.out.println(a);
    }

    @Test
    public void testString() {
        String str = "abcd";
        int code = str.codePointAt(3);
        System.out.println(code);
    }
}
