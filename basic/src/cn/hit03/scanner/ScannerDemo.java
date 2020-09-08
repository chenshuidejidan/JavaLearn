package cn.hit03.scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //键盘输入
        int i = sc.nextInt();
        System.out.println("输入的int是："+ i);
        String s = sc.next();
        System.out.println("输入的字符串是："+s);
    }
}
