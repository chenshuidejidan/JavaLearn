package cn.hit13.io;

import java.io.*;
import java.nio.charset.Charset;

public class DemoOutputStream {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\a.txt"), Charset.forName("GBK")))) {
            bw.write("缓冲的带格式的写入方法".toCharArray());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\a.txt"), "GBK"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
