package com.lieve.base.common.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * @author sunlijiang
 * @date 2019/4/25
 */
public class NettyClient01 {
    static final int SIZE = 256;
    static final String HOST = "127.0.0.1";
    static final int PORT = 8080;

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyClient01Handler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect(HOST, PORT).sync();
        channelFuture.channel().closeFuture().sync();
        group.shutdownGracefully();
    }

}
