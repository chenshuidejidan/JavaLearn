package cn.hit13.io;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class DemoFileReader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\a.txt");
        int myread = 0;
        while((myread = fr.read())!=-1) {
            System.out.println((char)myread);
        }
        fr.close();
    }
}
