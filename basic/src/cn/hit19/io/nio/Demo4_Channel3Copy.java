package cn.hit19.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Demo4_Channel3Copy {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\b.txt");
        FileChannel fromChannel = fileInputStream.getChannel();
        FileChannel toChannel = fileOutputStream.getChannel();
        toChannel.transferFrom(fromChannel, 0, fromChannel.size());

        fromChannel.close();
        toChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
