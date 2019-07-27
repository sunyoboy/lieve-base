package com.lieve.base.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

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
            /**
             * 通过 ServerSocketChannel.accept() 方法监听新进来的连接。
             * 当 accept()方法返回的时候,它返回一个包含新进来的连接的 SocketChannel。因此, accept()方法会一直阻塞到有新连接到达。
             *
             * 通常不会仅仅只监听一个连接,在while循环中调用 accept()方法
             */
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                /**
                 * ServerSocketChannel可以设置成非阻塞模式。在非阻塞模式下，
                 * accept() 方法会立刻返回，如果还没有新进来的连接,返回的将是null。
                 * 因此，需要检查返回的SocketChannel是否是null
                 */
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                while(keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
//                    SocketChannel socketChannel = null;
                    if (key.isAcceptable()) {
                        register(selector, serverSocketChannel);
//                        key.attachment()
//                        socketChannel = serverSocketChannel.accept();
//                        socketChannel.configureBlocking(false);
                        System.out.println("a connection was accepted by a ServerSocketChannel.");
//                        send(channel, "who are you?");
                    } else if (key.isConnectable()) {
                        System.out.println("a connection was established with a remote server.");
                    } else if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = (ByteBuffer) key.attachment();
                        long bytesRead = channel.read(buffer);
                        if (bytesRead == -1) {
                            channel.close();
                        } else if (bytesRead > 0) {
                            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                            System.out.println("Get data length : " + bytesRead);
                        }
                        // System.out.println(receiver(channel));
                        System.out.println("a channel is ready for reading");
                    } else if (key.isValid() && key.isWritable()) {
                        ByteBuffer buffer = (ByteBuffer)key.attachment();
                        buffer.flip();
                        SocketChannel channel = (SocketChannel) key.channel();
                        channel.write(buffer);
                        if (!buffer.hasRemaining()) {
                            key.interestOps(SelectionKey.OP_READ);
                        }
                        buffer.compact();
                        // send(channel, "who are you?");
                    }
                    keyIterator.remove();
                }

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
     * 绑定SocketChannel 到selector
     * @param selector
     * @param serverSocketChannel
     * @throws IOException
     */
    public static void register(Selector selector, ServerSocketChannel serverSocketChannel) throws IOException {
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
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
             * 非阻塞模式下，write()方法在尚未写出任何内容时可能就返回了。所以需要在循环中调用write()。
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
