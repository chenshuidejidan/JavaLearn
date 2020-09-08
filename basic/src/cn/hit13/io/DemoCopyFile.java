package cn.hit13.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoCopyFile {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("D:\\lenan.bmp");
            FileOutputStream fos = new FileOutputStream("D:\\lena_copy.bmp");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("出错了"+e);
            e.printStackTrace();
        }
    }
}
