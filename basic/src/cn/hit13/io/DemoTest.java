package cn.hit13.io;

import java.io.*;
import java.util.Arrays;

public class DemoTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\a.txt");
        fos.write(-1);
        fos.write(97);
        fos.write((97-256));
        fos.close();

        FileInputStream fis1 = new FileInputStream("D:\\a.txt");
        int len = 0;
        byte[] chs = new byte[10];
        len = fis1.read(chs);
        System.out.println(Arrays.toString(chs));
        System.out.println(new String(chs, 0, len));
        fis1.close();

        FileInputStream fis2 = new FileInputStream("D:\\a.txt");
        byte value = 0;
        while((value=(byte)fis2.read())!=-1){
            System.out.print(value+"  ");
        }
    }
}
