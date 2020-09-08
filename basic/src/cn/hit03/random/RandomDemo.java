package cn.hit03.random;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random();
        int num1 = r.nextInt();
        int num2 = r.nextInt(10);    //产生[0,10)的数
        System.out.println(num1);
        System.out.println(num2);
    }
}
