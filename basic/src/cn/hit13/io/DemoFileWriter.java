package cn.hit13.io;

import java.io.FileWriter;
import java.io.IOException;

public class DemoFileWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fw = null;      //提高变量作用域，使finally中可以使用
        // 必须给初值，否则new出现异常无法执行finally
        try {
            fw = new FileWriter("D\\a.txt");
            fw.write(97);   //写入int的ASCII码

            char[] chs = {'a', 'b', 'c', '\r', '\n'};
            fw.write(chs);    //写入字符数组

            String s = "写入字符串了\r\n";
            fw.write(s);    //写入字符串
            fw.write(s, 0, 5);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {   //不为null时才close，否则会出现空指针异常
                try {       //close()的异常再次进行捕获
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
