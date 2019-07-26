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
 * @author sunlijiang
 * @date 2019/7/26
 */
public class Client {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", PORT));
            socketChannel.configureBlocking(false);
            while (socketChannel.finishConnect()) {
                send(socketChannel, "who are you?");
                receiver(socketChannel);
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
    public static String receiver(SocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_CAPACITY);

        StringBuilder result = new StringBuilder();
        if (nonNull(channel)) {
            int bytesRead = 0;
            try {
                bytesRead = channel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (bytesRead != -1) {
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
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
}
