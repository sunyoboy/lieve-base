package com.lieve.base.common.util.http;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2018/12/14 下午2:06
 */

import com.lieve.base.common.util.HttpUtils;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpThread extends Thread {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    private final CloseableHttpClient httpClient;

    private final HttpContext httpContext;

    private final HttpRequestBase httpRequestBase;

    public HttpThread (CloseableHttpClient httpClient, HttpRequestBase httpRequestBase) {
        this.httpClient = httpClient;
        this.httpContext = HttpClientContext.create();
        this.httpRequestBase = httpRequestBase;
    }

    @Override
    public void run() {
        try {
            CloseableHttpResponse response = httpClient.execute(httpRequestBase, httpContext);
            String responseStr = HttpUtils.release(response);
            System.out.println(responseStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
