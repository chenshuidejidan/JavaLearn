package cn.hit19.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Demo5_Channel4MappedByteBuffer {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\a.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();

        //使用读写模式，直接修改的起始位置是0，映射5字节的内存(可修改的范围)
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte)'*');
        mappedByteBuffer.put(1, (byte)'&');
        mappedByteBuffer.put(3, (byte)'@');

        randomAccessFile.close();
    }
}
