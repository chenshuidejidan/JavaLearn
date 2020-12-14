package cn.hit19.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo3_Channle2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\b.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while(channel.read(byteBuffer)!=-1){
            //获取byteBuffer的字节数组，按字符串输出
            System.out.println(new String(byteBuffer.array()));
        }

        fileInputStream.close();
    }
}
