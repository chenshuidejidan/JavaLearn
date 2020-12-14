package cn.hit19.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Demo1_Buffer {
    public static void main(String[] args) {
        //创建buffer：存放5个int的buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        //存放数据
        for(int i = 0; i<2; i++){
            intBuffer.put(i*i);
        }

        //反转，读写切换，从写模式转换为读模式
        intBuffer.flip();

        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
