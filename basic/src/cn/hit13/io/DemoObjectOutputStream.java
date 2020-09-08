package cn.hit13.io;

import java.io.*;

public class DemoObjectOutputStream {
    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:" + File.separator + "a.txt")));
        ) {
            Student s1 = new Student("小明", 12, "男");
            oos.writeObject(s1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
