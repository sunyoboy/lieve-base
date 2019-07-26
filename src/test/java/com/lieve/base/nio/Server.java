package com.lieve.base.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import static com.lieve.base.nio.Client.receiver;
import static com.lieve.base.nio.NioConstants.BUFFER_CAPACITY;
import static com.lieve.base.nio.NioConstants.PORT;
import static java.util.Objects.nonNull;

/**
 * @author sunlijiang
 * @date 2019/7/26
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                send(socketChannel, "who are you?");
                System.out.println(receiver(socketChannel));
                /*ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_CAPACITY);
                byteBuffer.clear();
                if (nonNull(socketChannel)) {
                    byteBuffer.put("hello world".getBytes());
                    byteBuffer.flip();

                    *//**
                 * write()方法无法保证能写多少字节到SocketChannel。
                 * 所以我们重复调用write()直到Buffer没有要写的字节为止。
                 *//*
                    while(byteBuffer.hasRemaining()) {
                        socketChannel.write(byteBuffer);
                    }
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * send message by channel
     * 写数据到SocketChannel, 使用channel.write(byteBuffer)
     * @param channel
     * @param message
     */
    public static void send(SocketChannel channel, String message) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_CAPACITY);
        byteBuffer.clear();
        if (nonNull(channel)) {
            byteBuffer.put(message.getBytes());
            byteBuffer.flip();

            /**
             * write()方法的调用是在一个while循环中的。
             * write()方法无法保证能写多少字节到SocketChannel。
             * 所以我们重复调用write()直到Buffer没有要写的字节为止。
             */
            while (byteBuffer.hasRemaining()) {
                try {
                    channel.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
