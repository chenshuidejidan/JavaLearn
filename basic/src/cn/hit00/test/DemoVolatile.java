package cn.hit00.test;

public class DemoVolatile {


    public static boolean flag = true;
    public static int num;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task(),"mythread").start();
        Thread.sleep(200);
        flag = false;
        num = 120;
        System.out.println("flag: " + flag);
        System.out.println("value: " + Task.value);
        Thread.sleep(1500);
        System.out.println("value: " + Task.value);
    }
}