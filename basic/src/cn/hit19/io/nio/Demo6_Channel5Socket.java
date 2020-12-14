package cn.hit19.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class Demo6_Channel5Socket {
    public static void main(String[] args) throws IOException {
        //channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //绑定端口到socket
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        //buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLen = 8;

        //循环读取
        while (true) {
            int byteCountRead = 0;
            while (byteCountRead < messageLen) {
                byteCountRead += socketChannel.read(byteBuffers);
                System.out.println("已读取" + byteCountRead + "个字节");
                Arrays.asList(byteBuffers).stream().map(buffer -> "positon=" +
                        buffer.position() + ",limit=" + buffer.limit()).forEach(System.out::println);
            }
            //将buffer反转
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            //回显到客户端
            int byteCountWrite = 0;
            while(byteCountWrite<messageLen){
                byteCountWrite += socketChannel.write(byteBuffers);
            }

            //buffer进行clear
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());

            System.out.println("一共读取了"+byteCountRead+",一共写入"+byteCountWrite);
        }
    }
}
