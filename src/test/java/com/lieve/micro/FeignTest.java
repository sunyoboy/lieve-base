package com.lieve.micro;


import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * @author sunlijiang
 * @date 2019/5/11
 */
public class FeignTest {

    @Test
    public void testLocalTime() {
        Duration duration = new Duration("09:00-18:00");
        Period period2 = new Period("09:00~18:00");
        SimpleDateFormat simpleDateFormat;
        Interval interval = new Interval("2019-04-12/2019-04-13");
        LocalTime beginLocalTime = LocalTime.parse("09:00", DateTimeFormat.forPattern("HH:mm"));
        LocalTime endLocalTime = LocalTime.parse("17:30", DateTimeFormat.forPattern("HH:mm"));
        int hours = Hours.hoursBetween(beginLocalTime, endLocalTime).getHours();
        int minutes = Minutes.minutesBetween(beginLocalTime, endLocalTime).getMinutes();
        System.out.println(hours);
        System.out.println(minutes);
        BigDecimal workingHours = BigDecimal.valueOf(minutes / 60.0D);
        System.out.println(workingHours);
        Period period;
        Period period1 = Period.parse("09:00~18:00");
        System.out.println(period1);
    }

    @Test
    void testKafka() {
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println(df.format(BigDecimal.valueOf(4.0000)));
        System.out.println(df.format(BigDecimal.valueOf(5.33300)));
    }

    @Test
    void channel() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean flag = socketChannel.connect(new InetSocketAddress(8009));
        Selector selector = Selector.open();
        while(socketChannel.isConnected()) {
            socketChannel.register(selector, SelectionKey.OP_WRITE);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put("hello world!".getBytes());
            socketChannel.write(byteBuffer);
            System.out.println("end");
        }
    }

    @Test
    void testNio() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8009));
        Selector selector = Selector.open();
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            // int readyChannels = selector.select();
            /*if (readyChannels == 0) {
                continue;
            }*/
            /*if (selectionKey.isReadable()) {
                Selector selector1 = selectionKey.selector();
            }
            int interestSet = selectionKey.interestOps();
            */
            // boolean isAccepted = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
            /*
            if (isAccepted) {
                SocketChannel clientSocketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                clientSocketChannel.configureBlocking(false);
                clientSocketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                clientSocketChannel.read(byteBuffer);
                System.out.println(new String(byteBuffer.array()));
                // System.out.println("isAccepted");
            }
            */
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while(keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove();
                if (key.isAcceptable()) {
                    System.out.println("isAcceptable");
                    SocketChannel clientSocketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                    clientSocketChannel.configureBlocking(false);
                    clientSocketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                } else if (key.isConnectable()) {
                    System.out.println("isConnectable");
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    long byteRead = clientChannel.read(byteBuffer);
                    if (byteRead == 1) {
                        clientChannel.close();
                    } else {
                        key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        System.out.println(byteRead + " " + new String(byteBuffer.array()));
                    }
                    System.out.println("isReadable");
                } else if (key.isReadable()) {
                    System.out.println("isReadable");
                }
                keyIterator.remove();
            }
        }
    }

    @Test
    void print() {
        DateTime dateTime = DateTime.now();
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonthOfYear());
    }

    @Test
    public void testTime() {
        Double.parseDouble("");
    }

    @Test
    void testMinus() {
        DateTime time1 = DateTime.now();

        DateTime time2 = time1.plusDays(5);
        org.joda.time.Period p = new org.joda.time.Period(time1, time2, PeriodType.days());
        int days = p.getDays();
    }

    /**
     * 布尔类型的使用
     */
    @Test
    void testEnumUtils() {

    }

    /**
     * check n进制转换
     */
    @Test
    public void printAlpha() {
        char ch = 'a';
        int i = 10;
        while (!(ch > 'z')) {
            System.out.println(i++ + " " + ch++ + " 2 * 36 + i = " + (2 * 36 + i));
        }

        String str36 = Integer.toString(100, 36);
        System.out.println(str36);
        System.out.println();
    }

    /**
     * Instant replace Date
     * LocalDateTime replace Calendar
     * DateTimeFormatter replace SimpleDateFormat
     */
    @Test
    void testInstant() {
        Instant instant = Instant.now();
        System.out.println(instant);
        LocalDateTime localDateTime = LocalDateTime.MAX;
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter;

        double a = 0.5D;
        double b = 0.5D;
        double c = Double.sum(a, b);
        System.out.println(c);
    }

    @Test
    void testInterval() {
        Interval interval = new Interval(DateTime.parse("2019-05-26"), DateTime.parse("2019-06-25"));
        Interval interval2 = new Interval(DateTime.parse("2019-04-26"), DateTime.parse("2019-07-25"));
        Interval t = interval.overlap(interval2);
        System.out.println(t);
    }

}
