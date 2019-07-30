package com.lieve.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import static com.lieve.base.nio.NioConstants.BUFFER_CAPACITY;
import static com.lieve.base.nio.NioConstants.PORT;
import static com.lieve.base.nio.Server.send;
import static java.util.Objects.nonNull;

/**
 * TODO 非阻塞模式与选择器搭配会工作的更好，通过将一或多个SocketChannel注册到Selector，可以询问选择器哪个通道已经准备好了读取，写入等
 * @author sunlijiang
 * @date 2019/7/26
 */
public class Client {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(PORT));

            /**
             * 可以设置 @see SocketChannel 为非阻塞模式（non-blocking mode)。
             * 设置之后，就可以在异步模式下调用connect(),read()和write()了。
             * SocketChannel在非阻塞模式下，此时调用connect()，该方法可能在连接建立之前就返回了。
             * 为了确定连接是否建立，可以调用finishConnect()的方法。
             */
            socketChannel.configureBlocking(false);
            while (socketChannel.finishConnect()) {
                send(socketChannel, "who are you?");
                // receiver(socketChannel);
                /*
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);
                int bytesRead = socketChannel.read(buffer);
                while(bytesRead != -1) {
                    buffer.flip();
                    while(buffer.hasRemaining()) {
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        System.out.println(new String(bytes));
                    }
                    buffer.clear();
                    bytesRead = socketChannel.read(buffer);

                }
                socketChannel.close();*/
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从SocketChannel 读取数据到ByteBuffer
     * @param channel
     * @return
     */
    public static String receiver(SocketChannel channel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);

        StringBuilder result = new StringBuilder();
        if (nonNull(channel)) {
            int bytesRead = -1;
            try {
                /**
                 * 非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。
                 * 所以需要关注它的int返回值，它会告诉你读取了多少字节。
                 */
                bytesRead = channel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }

            /**
             *
             */
            if (bytesRead == -1) {
                System.out.println("Close channel : " + channel.getRemoteAddress());
                channel.close();
                System.exit(0);
            }

            while (bytesRead > 0) {
                System.out.println("read : " + bytesRead);
                /**
                 * 注意 buf.flip() 的调用,首先读取数据到Buffer,
                 * 然后反转Buffer,接着再从Buffer中读取数据。
                 */
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    result.append(new String(bytes));
                    System.out.println(new String(bytes));
                }
                buffer.clear();
                try {
                    bytesRead = channel.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
}
