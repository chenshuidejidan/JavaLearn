package cn.hit13.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoFileInputStream {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("D:\\a.txt");
//        List<Byte> byteList = new ArrayList<>();
//        int read = 0;
//        while((read = fis.read())!=-1){
//            byteList.add((byte) read);
//        }
//        Object[] bytes = byteList.toArray();
//        String s = String.valueOf(bytes);
//        System.out.println(s);
//        fis.close();
        FileInputStream fis = new FileInputStream("D:\\a.txt");    //a中存放abcde
        byte[] bytes = new byte[2];
        int flag = 1;
        while(flag>=0) {
            flag = fis.read(bytes);
            System.out.println("flag="+flag+",bytes="+new String(bytes));    //String的构造方法，从byte[]数组创建String
        }
        fis.close();
    }
}
