package cn.hit13.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DemoObjectInputStream {
    public static void main(String[] args) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:" + File.separator + "a.txt")))){
            Object s1 = ois.readObject();
            System.out.println(s1);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        new Thread().getName();
    }
}
