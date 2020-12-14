package algorithm.sort;

import java.io.IOException;

public class T{
    private int num = 8;
    public T(){
        new Thread(()->System.out.println(this.num)).start();
    }
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 100; i++) {
            new T();
        }
        System.in.read();
    }
}