package com.lieve.base.common.util;

import static org.junit.Assert.*;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

/**
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @version 1.0
 * @since 2018/12/14 下午2:17
 */
public class HttpUtilsTest {

    @Test
    public void demo() {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String[] urls = {
            "http://hc.apache.org/index.html",
            "http://hc.apache.org/index.html",
            "http://hc.apache.org/index.html"
        };

        HttpThread[] threads = new HttpThread[urls.length];
        for (int i = 0; i < threads.length; i++) {
            HttpGet httpGet = new HttpGet(urls[i]);
            threads[i] = new HttpThread(httpClient, httpGet);
        }

        for (HttpThread thread : threads) {
            thread.start();
        }

        for (HttpThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}