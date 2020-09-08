package cn.hit13.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoBufferedReader {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\a.txt"));)
        {
        String line = "";
        while((line = br.readLine())!=null){
            System.out.println(line);
        }}
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
