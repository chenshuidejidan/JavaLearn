package cn.hit13.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class DemoFileOutputStream {
    public static void main(String[] args) throws IOException {
        //创建FileOutputStream对象，传入文件
        FileOutputStream fos = new FileOutputStream("D:\\a.csv");
        String[][] strArr = new String[10][4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                String s = Double.valueOf(Math.random()+Math.random()).toString();
                strArr[i][j] = s;
            }
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 10; i++) {
                if (i == 9) {
                    fos.write((strArr[i][j] + "\r\n").getBytes());
                } else {
                    fos.write((strArr[i][j] + ",").getBytes());

                }
            }
        }
        fos.close();
    }

}
