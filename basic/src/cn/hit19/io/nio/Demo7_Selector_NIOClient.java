package cn.hit19.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Demo7_Selector_NIOClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        if(!socketChannel.connect(inetSocketAddress)){
            while(!socketChannel.finishConnect()){
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他事情");
                Thread.sleep(100);
            }
        }

        String s = "hello,NIO";
        //wrap直接根据字符串大小创建对应大小的ByteBuffer，不需要手动指定大小
        ByteBuffer byteBuffer = ByteBuffer.wrap(s.getBytes());

        socketChannel.write(byteBuffer);
        socketChannel.close();
    }
}
