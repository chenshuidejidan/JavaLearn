package cn.hit19.io.nio;

import sun.nio.ch.FileChannelImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo2_Channel {
    public static void main(String[] args) throws Exception {
        String s = "hello啊";
        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将string写入到buffer
        byteBuffer.put(s.getBytes());
        //反转
        byteBuffer.flip();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\a.txt");
        //通过fileOutputStream获取Channel
        FileChannel fileChannel = fileOutputStream.getChannel();
        //向channel中写入缓冲区数据
        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }
}
