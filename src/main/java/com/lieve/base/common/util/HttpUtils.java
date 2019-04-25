package com.lieve.base.common.util;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunlijiang</a>
 * @since 2018/12/10 下午8:10
 */

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

public class HttpUtils {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    private PoolingHttpClientConnectionManager connectionManager;

    private CloseableHttpClient httpClient;

    private RequestConfig requestConfig;

    public HttpUtils(int connectTimeout, int retryCount) {
        init(connectTimeout, retryCount);
    }

    public void init(int connectTimeout, int retryCount) {
        PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager();
        clientConnectionManager.setMaxTotal(200);
        clientConnectionManager.setDefaultMaxPerRoute(20);
        HttpHost httpHost = new HttpHost("localhost", 80);
        clientConnectionManager.setMaxPerRoute(new HttpRoute(httpHost), 50);

        // requestConfig 配置
        requestConfig = RequestConfig.custom()
            .setConnectTimeout(1000)
            .setSocketTimeout(1000)
            .build();

        httpClient = HttpClients.custom()
            .setConnectionManager(connectionManager)
            .setDefaultRequestConfig(requestConfig)
            .setRetryHandler(
                new DefaultHttpRequestRetryHandler(3, false)) // 设置重试次数
            .build();
    }

    public static String release(CloseableHttpResponse response) {
        String repsonseStr = "";
        try {
            repsonseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            // OR
            EntityUtils.consume(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return repsonseStr;
    }



    public void close(CloseableHttpClient httpClient) {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public void demo() {
        HttpClientContext context = HttpClientContext.create();
        HttpClientConnectionManager connMrg = new BasicHttpClientConnectionManager();
        HttpRoute httpRoute = new HttpRoute(new HttpHost("localhost", 80));

        //
        ConnectionRequest connRequest = connMrg.requestConnection(httpRoute, null);
        HttpClientConnection conn = null;
        try {
            conn = connRequest.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (ConnectionPoolTimeoutException e) {
            e.printStackTrace();
        }

        try {
            if (!conn.isOpen()) {
                //
                connMrg.connect(conn, httpRoute, 1000, context);
                connMrg.routeComplete(conn, httpRoute, context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connMrg.releaseConnection(conn, null, 1, TimeUnit.SECONDS);
        }

    }

}
