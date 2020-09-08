package cn.hit13.io;

import java.io.*;

public class DemoBufferedStream {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.pdf"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\a_copy.pdf"));
        ) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = bis.read(bytes))!=-1){
                bos.write(bytes, 0, len);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-start)+"ms");
    }
}
